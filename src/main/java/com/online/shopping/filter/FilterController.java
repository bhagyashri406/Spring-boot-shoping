package com.online.shopping.filter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.online.shopping.product.Product;
import com.online.shopping.product.ProductRepository;

@RestController
public class FilterController {

	@Autowired
	private ProductRepository productRepository;

	@GetMapping("/filterByName")
	public List<Product> FilterbyName(@RequestParam("product_name") String product_name, Pageable pageable) {

        List<Product> list = productRepository.findAll(Specifications.getProductByNameSpec(product_name));
	//	List<Object> list = productRepository.findAll(Specifications.getUserCart("product_name" , product_name));

		return list;
	}

	@GetMapping("/filterByPrice")
	public List<Product> FilterbyPrice(@RequestParam("product_price") double product_price, Pageable pageable) {

		List<Product> list = productRepository.findAll(Specifications.getProductByPriceSpec(product_price));

		return list;
	}

}