package com.sony.springbootbasics.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/products")
public class ProductController {

	// http://localhost:8080/api/products/info
	@RequestMapping("/info")
	public String info() {
		return "<h3>This is the endpoint for Product resources.</h3>";
	}
	
	@RequestMapping("/author-info")
	public String authorInfo() {
		return "Name: Vinod Kumar<br>Email: vinod@vinod.co";
	}
}
