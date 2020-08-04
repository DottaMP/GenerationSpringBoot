package br.com.minharedesocial.controller;

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

import br.com.minharedesocial.model.PostagemModel;
import br.com.minharedesocial.repository.PostagemRepository;

@RequestMapping("/postagem")
@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class PostagemController {
	@Autowired
	private PostagemRepository repository;
	
	@GetMapping	
	public ResponseEntity<List<PostagemModel>> listarPostagem (){
		return ResponseEntity.ok(repository.findAll()); 
	}
	
	@GetMapping("/{id}") //
	public ResponseEntity<PostagemModel> listarPostagemPorId(@PathVariable long id){ //findById()
		return repository.findById(id).map(resp -> ResponseEntity.ok(resp)).orElse(ResponseEntity.notFound().build());
	}
	
	@PostMapping
	public ResponseEntity<PostagemModel> postarPostagem(@RequestBody PostagemModel postagem){
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(postagem));
	}
	
	@PutMapping
	public ResponseEntity<PostagemModel> editarPostagem(@RequestBody PostagemModel postagem){
		return ResponseEntity.status(HttpStatus.OK).body(repository.save(postagem));
	}
	
	@DeleteMapping("/{id}")
	public void deletarPostagem(@PathVariable long id) {
		repository.deleteById(id);
	}
}
