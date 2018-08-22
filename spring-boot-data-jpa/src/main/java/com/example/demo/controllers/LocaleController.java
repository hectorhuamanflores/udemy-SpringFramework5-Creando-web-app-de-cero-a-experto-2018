package com.example.demo.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LocaleController {
    
	@GetMapping("/locale")
	public String locale(HttpServletRequest request){
		String ultimaUrl = request.getHeader("referer"); //nos retorna la ultima url
		
		return "redirect:".concat(ultimaUrl);
	}
}
