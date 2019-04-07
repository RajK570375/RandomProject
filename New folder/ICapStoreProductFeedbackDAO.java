package com.capgemini.capstore.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capgemini.capstore.beans.ProductFeedback;
@Repository
public interface ICapStoreProductFeedbackDAO extends JpaRepository<ProductFeedback, Integer> {

}
