package com.example.Rev2.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Rev2.model.Customer;

public interface Customerrepo extends JpaRepository<Customer, Integer>{

}
