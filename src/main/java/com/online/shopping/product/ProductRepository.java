package com.online.shopping.product;

import java.util.List;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ProductRepository extends CrudRepository<Product , Integer> ,JpaSpecificationExecutor<Product>{

	List<Product> findAll(Specification<Product> productByNameSpec);

}
