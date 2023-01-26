package com.example.discount.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.discount.domain.Product;


import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductService {
	
	
	
	
	@Autowired
	DiscountService discountService;
	
	
	public String getDiscount(List<Product> products) {
	
		
		return discountService.calculateDiscount(products);
	}
	
	

}
