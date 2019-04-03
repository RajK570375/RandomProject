package com.capgemini.capstore.main.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capgemini.capstore.main.beans.ReturnRequest;

public interface CapStoreReturnRequest extends JpaRepository<ReturnRequest, Integer>{

}
