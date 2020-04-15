package com.online.shopping.User;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.online.shopping.admin.Admin;
import com.online.shopping.admin.AdminRepository;
import com.online.shopping.exceptions.AdminNotFoundException;
import com.online.shopping.filter.Specifications;
import com.online.shopping.product.Product;

@RestController
public class UserCartResources {
	
	@Autowired
	private UserCartRepository cartRepository ;
	
	@Autowired
	private AdminRepository adminRepository ;
	
	
	@PostMapping(path = "/user/cart")
	public ResponseEntity<Object> createCart(@Valid @RequestBody UserCart  userCart) {

		if (UserExist(userCart.getUserId())) {

			UserCart user = cartRepository.save(userCart);

			Map<String, String> response = new HashMap<String, String>();

			if (user != null) {
				response.put("message", "Cart save successfully ");
				return ResponseEntity.accepted().body(response);
			}

		}

		return null;
	}
	
	
	@GetMapping(path = "/user/cart")
	public List<UserCart> getUserCart(@RequestParam("userId") int userId) {

		List<UserCart> list = cartRepository.findAll(Specifications.getUserCart(userId));

		return list;

	}

	@PutMapping(path = "/user/cart/update")
	public ResponseEntity<Object> UpdateCart(@Valid @RequestBody UserCart userCart) {

		if (UserExist(userCart.getUserId())) {

		   Iterable<UserCart>carts = cartRepository.findAll();
		   
		   Iterator<UserCart> iterator =  carts.iterator();
		   
		   while (iterator.hasNext()) {
			UserCart cart =  iterator.next() ;
			
			if(cart.getProductId()==userCart.getProductId() && cart.getUserId() == userCart.getUserId()) {
				
				userCart.setId(cart.getId());
		     }
			
			UserCart user = cartRepository.save(userCart);

			Map<String, String> response = new HashMap<String, String>();

			if (user != null) {
				response.put("message", "Cart save successfully ");
				return ResponseEntity.accepted().body(response);
			}
		   }
		}

		return null;
	}
	
	
	@PostMapping(path = "/user/buy")
	public ResponseEntity<Object> buyProducts(@Valid @RequestBody UserCart  userCart) {

		if (UserExist(userCart.getUserId())) {

			 cartRepository.delete(userCart);

			Map<String, String> response = new HashMap<String, String>();

			if (userCart != null) {
				response.put("message", "buy successfully ");
				return ResponseEntity.accepted().body(response);
			}
		}
		return null;
	}
	
	public boolean UserExist(int id) {
		Optional<Admin> user = adminRepository.findById(id);
		if (user.isPresent()) {
			return true;
		}
		throw new AdminNotFoundException("User is not Exist: id -" + id);

	}

	
//	public List<UserCart> UserProducts(int id) {
//		Optional<UserCart> user = cartRepository.findAllById(id)) ;
//		if (user.isPresent()) {
//			return true;
//		}
//		throw new AdminNotFoundException("User is not Exist: id -" + id);
//
//	}

}
