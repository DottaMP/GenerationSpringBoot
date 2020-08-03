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

import br.com.farmacia10.model.ProdutoModel;
import br.com.farmacia10.repository.ProdutoRepository;

@RequestMapping("/produto")
@RestController
@CrossOrigin("*")
public class ProdutoController {
	
	@Autowired
	private ProdutoRepository repository;
	
	@GetMapping("/buscaProduto") //Buscar específica após o /categoria
	public ResponseEntity<List<ProdutoModel>> listarProduto (){//Como se fosse a resposta de um formulário em forma de lista, seguido de um método em forme de verbo
		return ResponseEntity.ok(repository.findAll());  //O 'ok' traz o status ok (200), desse formulário eu quero trazer o repository da categoria
	}
	
	@GetMapping("/{id}") //
	public ResponseEntity<ProdutoModel> listarProdutoPorId(@PathVariable long id){ //findById()
		return repository.findById(id).map(resp -> ResponseEntity.ok(resp)).orElse(ResponseEntity.notFound().build());
	}
	
	@PostMapping
	public ResponseEntity<ProdutoModel> postarProduto(@RequestBody ProdutoModel produto){
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(produto));
	}
	
	@PutMapping
	public ResponseEntity<ProdutoModel> editarProduto(@RequestBody ProdutoModel produto){
		return ResponseEntity.status(HttpStatus.OK).body(repository.save(produto));
	}
	
	@DeleteMapping("/{id}")
	public void deletarProduto(@PathVariable long id) {
		repository.deleteById(id);
	}
}
