package com.example.discount.controller;



import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.example.discount.service.DiscountService;

@WebMvcTest(DiscountController.class)
public class DiscountControllerTest {
	
	@Autowired
	private MockMvc mvc;
	
	
	
	@MockBean
	DiscountService discountService;
	
	@Test
	public void calDiscountTest() throws Exception {
		mvc.perform(MockMvcRequestBuilders
				.post("/calDiscount")
				.content("{\"orderId\":12345,\"products\":[{\"id\":123,\"cost\":40,\"type\":\"CLOTHES\",\"noOfItems\":1,\"discount\":10},{\"id\":456,\"cost\":300,\"type\":\"ELECTRONICS\",\"noOfItems\":1,\"discount\":10}]}")
				.contentType(MediaType.APPLICATION_JSON))
		
		.andExpect(status().isOk());
	}

}
