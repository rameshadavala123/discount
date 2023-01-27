package com.example.discount.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.discount.domain.Discount;
import com.example.discount.domain.Order;
import com.example.discount.domain.Product;
import com.example.discount.repository.DiscountRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DiscountService {
	
	@Autowired
	private DiscountRepository discountRepository;
	
	public Discount addDiscount(Order order) {
		Discount dis = createDiscount(order.getProducts());
		dis.setOrderId(order.getOrderId());
		return discountRepository.save(dis);
	}
	
	
	public Discount getDiscount(int orderId){
		
		return discountRepository.findDiscountByOrderId(orderId);
		
	}
	
	public void removeDiscount(int orderId) {
		 discountRepository.deleteDiscountByOrderId(orderId);
	}
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
	
	
public Discount createDiscount(List<Product> products) {
		
		double abcTotal= 0.0,cdeTotal=0.0, fghTotal=0.0, discount;
		Discount  discountObj = new Discount();
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
			discountObj.setDicountAmount(discount);
			discountObj.setDiscountType("FGH");
			
			return discountObj;
			
		}else if (cdeTotal >= 100) {
			
			discount = cdeTotal * 0.15;
			discountObj.setDicountAmount(discount);
			discountObj.setDiscountType("CDE");
			return discountObj;
			
		} else {
			discount = abcTotal * 0.1;
			discountObj.setDicountAmount(discount);
			discountObj.setDiscountType("ABC");
			return discountObj;
			
		}
		
	}

}
