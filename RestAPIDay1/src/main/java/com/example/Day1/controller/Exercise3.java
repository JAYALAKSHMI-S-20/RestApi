package com.example.Day1.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Exercise3 {
	@Value("${favcolor}")
	public String yourFavColor;
     @GetMapping("color")
     public String getMyFav() {
    	 return "My favorite color is "+yourFavColor;
     }
}
