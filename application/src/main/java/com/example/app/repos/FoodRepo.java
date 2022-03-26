package com.example.app.repos;

import org.springframework.data.repository.CrudRepository;

import com.example.app.domain.Food;

public interface FoodRepo extends CrudRepository<Food, Integer>{

}