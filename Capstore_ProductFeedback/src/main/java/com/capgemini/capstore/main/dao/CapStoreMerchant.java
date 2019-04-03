package com.capgemini.capstore.main.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capgemini.capstore.main.beans.Merchant;

public interface CapStoreMerchant extends JpaRepository<Merchant, Integer> {
}

