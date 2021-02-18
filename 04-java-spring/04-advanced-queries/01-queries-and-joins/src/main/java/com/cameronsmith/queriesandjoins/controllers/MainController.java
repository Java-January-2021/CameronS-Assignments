package com.cameronsmith.queriesandjoins.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cameronsmith.queriesandjoins.services.ApiService;

@RestController
public class MainController {
	@Autowired
	private ApiService apiService;
	
	
	
}
