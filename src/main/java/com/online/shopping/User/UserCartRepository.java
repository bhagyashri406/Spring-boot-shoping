package com.online.shopping.User;

import java.util.List;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserCartRepository extends CrudRepository<UserCart, Integer>{

	List<UserCart> findAll(Specification<UserCart> userCart);

}
