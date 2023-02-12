package com.CRUDapp.demo.Repositories;

import com.CRUDapp.demo.Entity.*;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer>{

	Product findByName(String name);
	
	
	

}
