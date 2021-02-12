package com.topi.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.topi.model.Meal;
import com.topi.service.MealService;

@RestController
@RequestMapping("/api/meal")
@CrossOrigin
public class MealController {
	
	private final MealService mealService;
	
	public MealController(MealService mealService) {
		this.mealService = mealService;
	}
	
	@GetMapping("/buscar-meal/{meal}")
	private ResponseEntity<Meal[]> buscarMeals(@PathVariable("meal") String meal){
		return ResponseEntity.ok(this.mealService.buscarMeals(meal));
	}
	
	@GetMapping
	private ResponseEntity<List<Meal>> buscarMealsPesquisados(){
		return ResponseEntity.ok(this.mealService.buscarMealsPesquisados());
	}

}
