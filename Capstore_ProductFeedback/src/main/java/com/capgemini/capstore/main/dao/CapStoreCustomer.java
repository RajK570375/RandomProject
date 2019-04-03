package com.capgemini.capstore.main.dao;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capgemini.capstore.main.beans.Customer;
@Transactional
public interface CapStoreCustomer extends JpaRepository<Customer, Integer>{

}
