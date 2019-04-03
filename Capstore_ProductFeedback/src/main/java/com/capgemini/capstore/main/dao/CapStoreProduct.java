package com.capgemini.capstore.main.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capgemini.capstore.main.beans.Product;

public interface CapStoreProduct extends JpaRepository<Product, Integer>{

}
