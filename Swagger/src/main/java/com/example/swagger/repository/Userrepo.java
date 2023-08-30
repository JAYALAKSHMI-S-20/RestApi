package com.example.swagger.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.swagger.model.Usermodel;

public interface Userrepo extends JpaRepository<Usermodel, Long>{

}
