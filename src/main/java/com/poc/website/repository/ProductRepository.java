package com.poc.website.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.poc.website.model.Product;

public interface ProductRepository extends JpaRepository<Product,Long>  {

}
