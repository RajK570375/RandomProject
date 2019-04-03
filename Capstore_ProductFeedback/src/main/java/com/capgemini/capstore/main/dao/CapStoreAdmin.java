package com.capgemini.capstore.main.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capgemini.capstore.main.beans.Admin;

public interface CapStoreAdmin extends JpaRepository<Admin, Integer>{

}
