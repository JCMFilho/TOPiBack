package com.topi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.topi.model.Meal;

@Repository
public interface MealRepository extends JpaRepository<Meal,Integer>{
	@Query("Select m from Meal m")
	public List<Meal> buscarMealsPesquisados();
}
