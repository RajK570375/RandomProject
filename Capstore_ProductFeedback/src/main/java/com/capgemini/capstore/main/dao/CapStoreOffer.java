package com.capgemini.capstore.main.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capgemini.capstore.main.beans.Offer;

public interface CapStoreOffer extends JpaRepository<Offer, Integer>{

}
