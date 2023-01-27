package com.example.discount.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.discount.domain.Discount;
import com.example.discount.domain.Order;
import com.example.discount.service.DiscountService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class DiscountController {
	
	@Autowired
	DiscountService discountService;
	
	@PostMapping("/calDiscount")
	public String calDiscount(@RequestBody  Order order) {
		return discountService.calculateDiscount(order.getProducts());
	}
	
	@PostMapping("/addDiscount")
	public Discount addDiscount(@RequestBody Order order) {
		return discountService.addDiscount(order);
	}
	
	@GetMapping("/getDiscount")
	public Discount getDiscount(@RequestParam  Integer orderId) {
		return discountService.getDiscount(orderId);
	}
	
	@DeleteMapping("/removeDiscount")
	public String removeDiscount(@RequestParam  Integer orderId) {
		 discountService.removeDiscount(orderId);
		 return "Removed the Discount for this order "+ orderId;
	}
	

}
