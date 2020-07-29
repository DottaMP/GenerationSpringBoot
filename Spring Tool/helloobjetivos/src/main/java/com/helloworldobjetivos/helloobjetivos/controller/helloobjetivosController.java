package com.helloworldobjetivos.helloobjetivos.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/objetivos")
public class helloobjetivosController {
	
	@GetMapping
	public String objetivos() {
		return "Obsorver e desenvolver bem o conteúdo proposto!";
	}
}
