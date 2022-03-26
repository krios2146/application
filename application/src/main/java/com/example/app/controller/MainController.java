package com.example.app.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.app.domain.Food;
import com.example.app.repos.FoodRepo;

@Controller
public class MainController {
	@Autowired 
	private FoodRepo foodRepo;
	
	@GetMapping("/main")
	public String main(Map<String, Object> model) {
		Iterable<Food> foods = foodRepo.findAll();
		
		model.put("foods", foods);
		
		return "main";
	}
	
	@PostMapping("/add")
	public String add(@RequestParam String name, @RequestParam Integer cost, @RequestParam String link, Map<String, Object> model) {
		
		Food food = new Food();
		food.setName(name);
		food.setCost(cost);
		food.setLink(link);
		
		foodRepo.save(food);
		
		main(model);
		
		return "main";
	}
	
	@PostMapping("/delete")
	public String delete(@RequestParam Integer id, Map<String, Object> model) {
		
		try {
			foodRepo.deleteById(id);
		} catch (Exception e) {
			model.put("delMessage", e.getMessage());
		}
		
		main(model);
		
		return "main";
	}
	
}
