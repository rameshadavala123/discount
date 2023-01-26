package com.example.discount.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.discount.domain.Product;
import com.example.discount.service.ProductService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class ProductController {
	
	@Autowired
	ProductService productService;
	
	@PostMapping("/calDiscount")
	public String getDiscount(@RequestBody List<Product> products) {
		return productService.getDiscount(products);
	}
	

}
