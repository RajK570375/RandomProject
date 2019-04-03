package com.capgemini.capstore.main.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capgemini.capstore.main.beans.Email;

public interface CapStoreEmail extends JpaRepository<Email, Integer>{

}
