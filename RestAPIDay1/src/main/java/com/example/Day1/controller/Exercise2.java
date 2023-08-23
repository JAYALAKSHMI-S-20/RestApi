package com.example.Day1.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Exercise2 {
	@Value("${name}")
	public String studentName;
	@GetMapping("name")
	public String GetName() {
	   return "Welcome "+studentName+"!";
	}		
}
