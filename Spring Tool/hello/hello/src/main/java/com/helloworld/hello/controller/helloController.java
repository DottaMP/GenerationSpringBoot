package com.helloworld.hello.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")


public class helloController {
	@GetMapping
	public String hello() {
		return "Hello!!!\nAtenção aos detalhes e comunicação!!! \nPersistência e responsabilidade pessoal!!!";
	}
}

