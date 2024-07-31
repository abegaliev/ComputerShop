package com.example.electro.controller.spring_mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/store")
public class StorePageController {

	@GetMapping
	public String getProduct() {
		return "store";
	}
}
