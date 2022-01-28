package com.sanjit.crudexample2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sanjit.crudexample2.entity.Product;
import com.sanjit.crudexample2.service.ProductService;

@RestController
public class ProductController {
	@Autowired
	private ProductService service;
	
	@GetMapping("/products")
	public List<Product> getAllProducts()
	{
		return service.display();
	}
	@GetMapping("/productid/{id}")
	public Product productbyID(@PathVariable int id)
	{
		return service.getProductById(id);
	}
	
	@GetMapping("/productname/{name}")
	public Product productbyName(@PathVariable String name)
	{
		return service.getProductsByName(name);
	}
	
	@PostMapping("/add")
	public Product addProduct(@RequestBody Product product)
	{
		return service.add(product);
	}
	
	@PostMapping("/addAll")
	public List<Product> addAllProduct(@RequestBody List<Product> productList)
	{
		return service.saveProducts(productList);
	}
	@DeleteMapping("/delete/{id}")
	public String deleteProduct(@PathVariable int id )
	{
		return service.deleteProduct(id);
	}
	
	@PutMapping("/update")
	public Product update (@RequestBody Product product)
	{
		return service.updateProduct(product);
	}

}
