package com.minhaescola.db_escola.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.minhaescola.db_escola.model.aluno;
import com.minhaescola.db_escola.repository.alunoRepository;

@RestController
@RequestMapping("/aluno")
@CrossOrigin("*")
public class alunoController {

	@Autowired
	private alunoRepository repository;
	
	
	@GetMapping
	public ResponseEntity<List<aluno>> listarTurmas(){ //findAll()
		return ResponseEntity.ok(repository.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<aluno> listarTurmaPorId(@PathVariable long id){ //findById()
		return repository.findById(id).map(resp -> ResponseEntity.ok(resp)).orElse(ResponseEntity.notFound().build());
	}
	
	@PostMapping
	public ResponseEntity<aluno> incluirTurma(@RequestBody aluno aluno){ //postBody
		
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(aluno));
	}
	
	@PutMapping
	public ResponseEntity<aluno> atualizarTurma(@RequestBody aluno aluno){ //putBody
		return ResponseEntity.status(HttpStatus.OK).body(repository.save(aluno));
	}
	
	@DeleteMapping("/{id}")
	public void deletarTurma(@PathVariable long id){
		repository.deleteById(id);
	}
}