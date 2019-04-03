package com.capgemini.capstore.main.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capgemini.capstore.main.beans.DummyOrder;

public interface CapStoreDummyOrder extends JpaRepository<DummyOrder, Integer>{

}
