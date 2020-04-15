package com.online.shopping.admin;

import java.net.URI;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.online.shopping.exceptions.AdminNotFoundException;

@RestController
public class AdminJpaResources  {

	@Autowired
	private AdminRepository AdminJpaResources;

	@PostMapping(path = "/admin")
	public ResponseEntity<Object> createAdmin(@Valid @RequestBody Admin admin) {
		Admin _admin = AdminJpaResources.save(admin);

		Map<String, String> response = new HashMap<String, String>();

		if (_admin != null) {
			response.put("message", "Admin save successfully ");
			return ResponseEntity.accepted().body(response);
		}

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(_admin.getId())
				.toUri();

		return ResponseEntity.created(location).build();

	}

	@GetMapping(path = "/admin")
	public List<Admin> retrieveAllAdmin() {
		return AdminJpaResources.findAll();
	}

	@GetMapping(path = "/admin/{id}")
	public Optional<Admin> retrieveAdmin(@PathVariable int id) {
		Optional<Admin> user = AdminJpaResources.findById(id);
		if (!user.isPresent())
			throw new AdminNotFoundException("Admin is not Exist : id -" + id);

		return user;
	}

	//@GetMapping(path = "/admin/{id}")
//	public boolean AdminExist(@PathVariable int id) {
//		Optional<Admin> admin = AdminJpaResources.findById(id);
//		if (admin.isPresent()) {
//			return true;
//		} else
//			return false;
//
//	}

}
