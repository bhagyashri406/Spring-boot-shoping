package com.online.shopping.admin;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

 

@Repository
public interface AdminRepository extends JpaRepository<Admin , Integer>{
	



}