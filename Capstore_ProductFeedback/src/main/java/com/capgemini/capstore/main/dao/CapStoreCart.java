package com.capgemini.capstore.main.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capgemini.capstore.main.beans.Cart;

public interface CapStoreCart extends JpaRepository<Cart, Integer>{

}
