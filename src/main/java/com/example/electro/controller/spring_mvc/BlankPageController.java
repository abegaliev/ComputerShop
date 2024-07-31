package com.example.electro.controller.spring_mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/blank")
public class BlankPageController {

	@GetMapping
	public String getBlankPage() {
		return "blank";
	}

}
