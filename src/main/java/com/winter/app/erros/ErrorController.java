package com.winter.app.erros;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/errors/*")
public class ErrorController {

	@GetMapping("/error400")
	public String error400() {
		return "errors/error";
	}
}
