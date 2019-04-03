package com.capgemini.capstore.main.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capgemini.capstore.main.beans.Promo;

public interface CapStorePromo extends JpaRepository<Promo, String>{

}
