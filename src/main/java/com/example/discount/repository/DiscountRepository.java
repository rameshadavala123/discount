package com.example.discount.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.discount.domain.Discount;

import jakarta.transaction.Transactional;

@Repository
public interface DiscountRepository extends JpaRepository<Discount, Integer> {
	
	Discount findDiscountByOrderId(int orderId);
	
	@Transactional
	@Modifying
	@Query("delete from Discount d where d.orderId=:orderId")
	void deleteDiscountByOrderId(@Param("orderId") int orderId);

}
