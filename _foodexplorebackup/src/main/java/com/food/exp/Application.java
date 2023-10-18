package com.food.exp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.food.exp.controller.MainController;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(MainController.class, args);
		System.out.println("FoodExploreMainController 실행");

	}

}
