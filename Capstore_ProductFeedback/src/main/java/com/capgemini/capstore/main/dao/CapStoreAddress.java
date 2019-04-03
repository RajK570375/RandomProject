package com.capgemini.capstore.main.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capgemini.capstore.main.beans.Admin;

public interface CapStoreAddress extends JpaRepository<Admin, Integer>{

}
