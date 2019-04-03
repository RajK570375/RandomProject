package com.capgemini.capstore.main.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capgemini.capstore.main.beans.User;

public interface CapStoreUser extends JpaRepository<User, String>{

}
