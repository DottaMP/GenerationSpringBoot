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
@RequestMapping("/turmas")
@CrossOrigin("*")
public class turmaController {
	
	@Autowired
		private turmaRepository repository;
	
	@GetMapping
		public ResponseEntity<List<turma>> GetAll(){
			return ResponseEntity.ok(repository.findAll());
	}
	
	@GetMapping("/{id}")
		public ResponseEntity<turma> GetById(@PathVariable long id){
			return repository.findById(id).map(resp -> ResponseEntity.ok(resp)).orElse(ResponseEntity.notFound().build());
		}
		
	@GetMapping("/turma/{turma}")
		public ResponseEntity<List<turma>> GetByturma(@PathVariable String turma){
			return ResponseEntity.ok(repository.findAllByturmaContainingIgnoreCase(turma));
		}
	
	@PostMapping
	public ResponseEntity<turma> post (@RequestBody turma turma){
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(turma));
	}
	
	@PutMapping
	public ResponseEntity<turma> put (@RequestBody turma turma){
		return ResponseEntity.status(HttpStatus.OK).body(repository.save(turma));
	}
	
	@DeleteMapping ("/{id}")
	 public void delete (@PathVariable long id) {
		repository.deleteById(id);
	}
}
