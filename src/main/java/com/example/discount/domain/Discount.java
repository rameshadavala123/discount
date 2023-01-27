package com.example.discount.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Discount {
	
	@Id
	@GeneratedValue
	private int id;
	private int orderId;
	private String discountType;
	private double dicountAmount;
	
	public String getDiscountType() {
		return discountType;
	}
	public void setDiscountType(String discountType) {
		this.discountType = discountType;
	}
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public double getDicountAmount() {
		return dicountAmount;
	}
	public void setDicountAmount(double dicountAmount) {
		this.dicountAmount = dicountAmount;
	}
	
	

}
