package com.capgemini.capstore.main.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capgemini.capstore.main.beans.Order;

public interface CapStoreOrder extends JpaRepository<Order, Integer>{

}
