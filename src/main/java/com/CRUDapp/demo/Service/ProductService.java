package com.CRUDapp.demo.Service;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.*;
import com.CRUDapp.demo.Repositories.ProductRepository;
import com.CRUDapp.demo.Entity.*;
import java.util.*;

@Service
public class ProductService {
	@Autowired
	private ProductRepository repository;
	
	public Product saveProduct (Product product) {
		return repository.save(product);
	}
	
	public List<Product> saveProducts (List<Product> products) {
		return repository.saveAll(products);
		
	}
	
	public List<Product> getProducts(){
		return repository.findAll();
	}
	
	public Product getProductById(int id) {
		
		return repository.findById(id).orElse(null);
	}
	
	public Product getProductByName(String name) {
		
		return repository.findByName(name);
		
	}
	
	
	public String deleteProduct(int id) {
		repository.deleteById(id);
		return  "Product Deleted"+ id;
	}
	
	public Product updateProduct(Product product) {
		Product existingProduct=repository.findById(product.getId()).orElse(null);
		existingProduct.setName(product.getName());
		existingProduct.setQuantity(product.getQuantity());
		existingProduct.setPrice(product.getPrice());
		return repository.save(existingProduct);
	}
}
