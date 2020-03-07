package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {

	@Autowired
	Order order;
	
	@Autowired
	OrderRepo orderRepo;
	
	@PostMapping(path = "/placeOrder")
	public void setOrder(@RequestParam String email, int itemId) {
		order = new Order();
		order.setEmail(email);
		order.setItemId(itemId);
		orderRepo.save(order);
		
	}
}
