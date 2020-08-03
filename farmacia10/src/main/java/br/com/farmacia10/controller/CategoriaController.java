package br.com.farmacia10.controller;

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

import br.com.farmacia10.model.CategoriaModel;
import br.com.farmacia10.repository.CategoriaRepository;

@RequestMapping("/categoria")
@RestController
@CrossOrigin("*")
public class CategoriaController {
	
	@Autowired
	private CategoriaRepository repository;
	
	@GetMapping("/buscaCategoria") //Buscar específica após o /categoria
	public ResponseEntity<List<CategoriaModel>> listarCategoria (){//Como se fosse a resposta de um formulário em forma de lista, seguido de um método em forme de verbo
		return ResponseEntity.ok(repository.findAll());  //O 'ok' traz o status ok (200), desse formulário eu quero trazer o repository da categoria
	}
	
	@GetMapping("/{id}") //
	public ResponseEntity<CategoriaModel> listarCategoriaPorId(@PathVariable long id){ //findById()
		return repository.findById(id).map(resp -> ResponseEntity.ok(resp)).orElse(ResponseEntity.notFound().build());
	}
	
	@PostMapping
	public ResponseEntity<CategoriaModel> postarCategoria(@RequestBody CategoriaModel categoria){
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(categoria));
	}
	
	@PutMapping
	public ResponseEntity<CategoriaModel> editarCategoria(@RequestBody CategoriaModel categoria){
		return ResponseEntity.status(HttpStatus.OK).body(repository.save(categoria));
	}
	
	@DeleteMapping("/{id}")
	public void deletarCategoria(@PathVariable long id) {
		repository.deleteById(id);
	}
}
