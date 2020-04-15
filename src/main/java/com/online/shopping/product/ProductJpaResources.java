package com.online.shopping.product;

import java.net.URI;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.persistence.Id;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.online.shopping.admin.Admin;
import com.online.shopping.admin.AdminJpaResources;
import com.online.shopping.admin.AdminRepository;
import com.online.shopping.exceptions.AdminNotFoundException;

@RestController
public class ProductJpaResources {

	@Autowired
	private AdminRepository adminRepository;

	@Autowired
	private ProductRepository productRepository;

	@PostMapping(path = "/product")
	public ResponseEntity<Object> createProduct(@Valid @RequestBody Product product) {

		if (AdminExist(product.getAdmin_id())) {

			Product product2 = productRepository.save(product);

			Map<String, String> response = new HashMap<String, String>();

			if (product2 != null) {
				response.put("message", "Product save successfully ");
				return ResponseEntity.accepted().body(response);
			}

		}

		return null;
	}

	@GetMapping(path = "/product")
	public Iterable<Product> retrieveAllProduct() {
		return productRepository.findAll();
	}

	@GetMapping(path = "/product/{id}")
	public Product GetProductById(@PathVariable Integer id) {

		Optional<Product> Product = productRepository.findById(id);
		return Product.get();
	}

	@DeleteMapping(path = "/product/delete")
	public Void DeleteProductById(@Valid @RequestBody Product product) {

		if (AdminExist(product.getAdmin_id())) {
			productRepository.deleteById(product.getProduct_id());

			Map<String, String> response = new HashMap<String, String>();
			response.put("message", "Product Delete successfully ");
			ResponseEntity.accepted().body(response);
		}

		return null;

	}

	public boolean AdminExist(int id) {
		Optional<Admin> admin = adminRepository.findById(id);
		if (admin.isPresent()) {
			return true;
		}
		throw new AdminNotFoundException("Admin is not Exist: id -" + id);

	}

}
