package com.example.electro.controller.spring_mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/product")
public class ProductPageController {

	@GetMapping
	public String getProduct() {
		return "product";
	}

}
