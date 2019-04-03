package com.capgemini.capstore.main.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capgemini.capstore.main.beans.Wishlist;

public interface CapStoreWishlist extends JpaRepository<Wishlist, Integer>{

}
