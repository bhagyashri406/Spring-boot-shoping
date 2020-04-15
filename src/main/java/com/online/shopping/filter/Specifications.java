package com.online.shopping.filter;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.cglib.core.Predicate;
import org.springframework.data.jpa.domain.Specification;

import com.online.shopping.User.UserCart;
import com.online.shopping.admin.Admin;
import com.online.shopping.product.Product;

public class Specifications {
 
	
	 public static Specification<Product> getProductByNameSpec(String name) {
	      return new Specification<Product>() {
	          @Override
	          public javax.persistence.criteria.Predicate toPredicate(Root<Product> root,
	                                       CriteriaQuery<?> query,
	                                       CriteriaBuilder criteriaBuilder) {
	              javax.persistence.criteria.Predicate equalPredicate = criteriaBuilder.equal(root.get("product_name"), name);
	              return equalPredicate;
	          }
	      };
	  }

	 
	 public static Specification<Product> getProductByPriceSpec(double price) {
	      return new Specification<Product>() {
	          @Override
	          public javax.persistence.criteria.Predicate toPredicate(Root<Product> root,
	                                       CriteriaQuery<?> query,
	                                       CriteriaBuilder criteriaBuilder) {
	              javax.persistence.criteria.Predicate equalPredicate = criteriaBuilder.equal(root.get("product_price"), price);
	              return equalPredicate;
	          }
	      };
	  }
	 
	 
	 
	 public static Specification<Admin> AdminExist(double email) {
	      return new Specification<Admin>() {
	          @Override
	          public javax.persistence.criteria.Predicate toPredicate(Root<Admin> root,
	                                       CriteriaQuery<?> query,
	                                       CriteriaBuilder criteriaBuilder) {
	              javax.persistence.criteria.Predicate equalPredicate = criteriaBuilder.equal(root.get("email"), email);
	              return equalPredicate;
	          }
	      };
	  }
	 
	 
	 public static Specification<UserCart> getUserCart(int id) {
	      return new Specification<UserCart>() {
	          @Override
	          public javax.persistence.criteria.Predicate toPredicate(Root<UserCart> root,
	                                       CriteriaQuery<?> query,
	                                       CriteriaBuilder criteriaBuilder) {
	              javax.persistence.criteria.Predicate equalPredicate = criteriaBuilder.equal(root.get("userId"), id);
	              return equalPredicate;
	          }
	      };
	  }


//	 public static Specification<Object> getUserCart(String paremKey ,String value) {
//	      return new Specification<Object>() {
//	          @Override
//	          public javax.persistence.criteria.Predicate toPredicate(Root<Object> root,
//	                                       CriteriaQuery<?> query,
//	                                       CriteriaBuilder criteriaBuilder) {
//	              javax.persistence.criteria.Predicate equalPredicate = criteriaBuilder.equal(root.get("paremValue"), value);
//	              return equalPredicate;
//	          }
//	      };
//	  }

	/*
	 * @Override public javax.persistence.criteria.Predicate
	 * toPredicate(Root<Object> root, CriteriaQuery<?> query, CriteriaBuilder
	 * criteriaBuilder) { // TODO Auto-generated method stub
	 * 
	 * javax.persistence.criteria.Predicate equalPredicate =
	 * criteriaBuilder.equal(root.get(), id); return equalPredicate; return null; }
	 */

	

}