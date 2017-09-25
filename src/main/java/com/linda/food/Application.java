package com.linda.food;

import com.linda.food.model.Ingredient;
import com.linda.food.service.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application implements CommandLineRunner {

	@Autowired
	private FoodService foodService;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		//foodService.save(new Ingredient("0", "orange"));
		//foodService.save(new Ingredient("1", "banana"));
		//foodService.save(new Ingredient("2", "apple"));
	}
}
