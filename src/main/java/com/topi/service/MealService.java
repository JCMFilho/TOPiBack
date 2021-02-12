package com.topi.service;

import java.util.List;

import com.topi.model.Meal;

public interface MealService {

	Meal[] buscarMeals(String meal);
	
	List<Meal> buscarMealsPesquisados();
}
