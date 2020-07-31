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

import com.minhaescola.db_escola.model.turma;
import com.minhaescola.db_escola.repository.turmaRepository;

@RestController
@RequestMapping("/turma")
@CrossOrigin("*")
public class turmaController {

	@Autowired
	private turmaRepository repository;
	
	@GetMapping
	public ResponseEntity<List<turma>> listarTurmas(){ //findAll()
		return ResponseEntity.ok(repository.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<turma> listarTurmaPorId(@PathVariable long id){ //findById()
		return repository.findById(id).map(resp -> ResponseEntity.ok(resp)).orElse(ResponseEntity.notFound().build());
	}
	
	@PostMapping
	public ResponseEntity<turma> incluirTurma(@RequestBody turma turma){ //postBody
		
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(turma));
	}
	
	@PutMapping
	public ResponseEntity<turma> atualizarTurma(@RequestBody turma turma){ //putBody
		return ResponseEntity.status(HttpStatus.OK).body(repository.save(turma));
	}
	
	@DeleteMapping("/{id}")
	public void deletarTurma(@PathVariable long id){
		repository.deleteById(id);
	}
}