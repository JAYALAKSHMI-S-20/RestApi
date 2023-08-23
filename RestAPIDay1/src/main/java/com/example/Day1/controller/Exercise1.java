package com.example.Day1.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Exercise1{
     @GetMapping("welcome")
     public String welcome() {
    	 return "Welcome String Boot!";
     }
}