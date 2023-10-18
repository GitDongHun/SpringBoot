package com.food.exp.controller;

<<<<<<< HEAD
public class MainController {

=======
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

		@GetMapping("main")
		public String main() {
			return "MainController";
		}



>>>>>>> bbdf54529b24586e7d2b3cc65fd3b2d2e3c15f54
}
