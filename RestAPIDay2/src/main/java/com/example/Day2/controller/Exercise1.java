package com.example.Day2.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Exercise1 {
	@Value("${name1}")
	public String name1;
	@GetMapping("/name1")
	public String Display() {
	   return "Hello everyone , I m "+name1+"!";
	}		
}
