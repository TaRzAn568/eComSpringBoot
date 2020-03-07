package com.example.demo;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;




@RestController
public class ItemController {
	@Autowired
	private ItemRepo itemRepo;
	@Autowired
	public Item item;
	
	@PostMapping(path = "/create")
	public Item create(@RequestParam String itemName, int itemPrice) {
		item.setItemName(itemName);
		item.setItemPrice(itemPrice);
		return itemRepo.save(item);
	}
	
	@GetMapping(path = "/getItem/{id}")
	public Optional<Item> getItem(@PathVariable("id") int id) {
		
		return itemRepo.findById(id);
		
	}
	
	@GetMapping(path = "/getItem")
	public java.util.List<Item> getItem() {
		
		return itemRepo.findAll();
		
	}
	
	@DeleteMapping(path = "/delItem/{id}")
	public void delItem(@PathVariable("id") int id) {
		
		 itemRepo.deleteById(id);
		
	}

	@PutMapping(path="/updateItem/{id}")
	public Item updateItem(@PathVariable("id") int id, @RequestParam String itemName ,int itemPrice) {
		
		Item item = itemRepo.findById(id).orElse(null);
		item.setItemName(itemName);
		item.setItemPrice(itemPrice);
		return itemRepo.save(item);
		
	}
	
}
