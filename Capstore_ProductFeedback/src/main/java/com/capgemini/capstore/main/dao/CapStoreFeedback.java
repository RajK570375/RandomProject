package com.capgemini.capstore.main.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capgemini.capstore.main.beans.Feedback;

@Repository
public interface CapStoreFeedback extends JpaRepository<Feedback, Integer>{

}
