package com.topi.service.impl;

import java.util.List;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.google.gson.Gson;
import com.topi.model.Meal;
import com.topi.repository.MealRepository;
import com.topi.service.MealService;

@Service
public class MealServiceImpl implements MealService {

	 private final RestTemplate restTemplate;
	 private final MealRepository repository;
	 public MealServiceImpl(RestTemplateBuilder restTemplateBuilder,MealRepository repository) {
	     this.restTemplate = restTemplateBuilder.build();
	     this.repository = repository;
	 }

	@Override
	public Meal[] buscarMeals(String meal) {
		String url = "https://www.themealdb.com/api/json/v1/1/search.php?s="+meal;
		String resultado = this.restTemplate.getForObject(url, String.class);
		resultado = (String) resultado.subSequence(9, resultado.length()-1);
		Gson gson = new Gson();
		Meal[] meals = gson.fromJson(resultado, Meal[].class);
		for(Meal m : meals) {
			this.repository.saveAndFlush(m);
		}
		return meals;
	}

	@Override
	public List<Meal> buscarMealsPesquisados() {
		return this.repository.buscarMealsPesquisados();
	}
}
