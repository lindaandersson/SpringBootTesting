package com.linda.food.service;

import com.linda.food.model.Ingredience;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class FoodServiceImpl implements FoodService {

    static private List<Ingredience> ingredience = Arrays.asList(
            new Ingredience("1", "orange"),
            new Ingredience("1", "banana")
    );

    @Override
    public Iterable<Ingredience> findAll() {
        return ingredience;
    }
}
