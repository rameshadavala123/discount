package com.example.discount.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.discount.domain.Product;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DiscountService {
	
	public String calculateDiscount(List<Product> products) {
		
		double abcTotal= 0.0,cdeTotal=0.0, fghTotal=0.0, discount;
		
		for(Product product : products) {
			
			if("CLOTHES".equals(product.getType())) {
				abcTotal += product.getNoOfItems() * product.getCost();
			}
			
			if(product.getId() == 123) {
				fghTotal += product.getNoOfItems() * product.getCost();
			}
			
			cdeTotal += product.getNoOfItems() * product.getCost();
		}
		
		if (fghTotal >= cdeTotal) {
			discount = fghTotal * 0.20;
			return "The discount FGH and a total cost of $" + (fghTotal - discount);
			
		}else if (cdeTotal >= 100) {
			
			discount = cdeTotal * 0.15;
			return "The discount CDE and a total cost of $" + (cdeTotal - discount);
			
		} else {
			discount = abcTotal * 0.1;
			return "The discount ABC and a total cost of $" + (abcTotal - discount);
		}
		
	}

}
