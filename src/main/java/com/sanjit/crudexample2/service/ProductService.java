package com.sanjit.crudexample2.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sanjit.crudexample2.entity.Product;
import com.sanjit.crudexample2.repository.ProductRepository;
@Service
public class ProductService {
	@Autowired
	private ProductRepository repository;
	
	public  Product add (Product product)
	{
		return repository.save(product);
		
	}
	
	public List<Product> saveProducts(List<Product> products)
	{
	  return repository.saveAll(products)	;
	}
	public List<Product> display()
	{
		 List<Product> list =repository.findAll();
		 return list;
	}
	
   public Product getProductById(int id)
   {
	   return repository.findById(id).orElse(null);
   }
   
   public Product getProductsByName(String name)
   {
	   return repository.findByName(name);
   }
   
   public String deleteProduct(int id)
   {
	   repository.deleteById(id);
	   return ("Record deleted with id  "+ id);
   }
   
  public Product updateProduct(Product product)
  {
	  Product existingProduct = repository.findById(product.getId()).orElse(null);
	  existingProduct.setName(product.getName());
	  existingProduct.setQuantity(product.getQuantity());
	  existingProduct.setPrice(product.getPrice());
	  return repository.save(existingProduct);
	  
  }
   
   
   
}
