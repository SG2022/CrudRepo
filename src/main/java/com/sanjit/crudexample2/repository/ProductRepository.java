package com.sanjit.crudexample2.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sanjit.crudexample2.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {

	public Product findByName(String name);

}
