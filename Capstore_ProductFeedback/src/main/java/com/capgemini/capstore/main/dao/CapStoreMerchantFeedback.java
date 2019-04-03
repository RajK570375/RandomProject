package com.capgemini.capstore.main.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capgemini.capstore.main.beans.MerchantFeedback;

public interface CapStoreMerchantFeedback extends JpaRepository<MerchantFeedback, Integer>{

}
