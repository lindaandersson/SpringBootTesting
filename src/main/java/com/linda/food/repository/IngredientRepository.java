package com.linda.food.repository;

import com.linda.food.model.Ingredient;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface IngredientRepository extends ElasticsearchRepository<Ingredient, String>{
    Iterable<Ingredient>findByName(String name);
}
