package com.example.Day2.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Day2.model.Employee;

public interface Employeerepo extends JpaRepository<Employee, Integer>{

}
