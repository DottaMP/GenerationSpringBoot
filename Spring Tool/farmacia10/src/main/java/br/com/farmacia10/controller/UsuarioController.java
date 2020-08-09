package br.com.farmacia10.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.farmacia10.model.UserLoginModel;
import br.com.farmacia10.model.UsuarioModel;
import br.com.farmacia10.service.UsuarioService;

@RestController
@RequestMapping("/usuarios")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class UsuarioController {
	
	@Autowired
	private UsuarioService usuarioService; /*Ao invés de injetar o repository, é injetado o nosso Serviço de Usuário*/
	
	/*Não é utilizadado o end-point GET, pois não é seguro, uma vez que é utilizado a URL, sendo assim utilizaremos a body*/
	@PostMapping("/logar")
	public ResponseEntity<UserLoginModel> Autentication(@RequestBody Optional<UserLoginModel> user){
		return usuarioService.Logar(user).map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.status(HttpStatus.UNAUTHORIZED).build());
	}
	
	@PostMapping("/cadastrar")
	public ResponseEntity<UsuarioModel> Post (@RequestBody UsuarioModel usuario){
		return ResponseEntity.status(HttpStatus.CREATED).body(usuarioService.CadastrarUsuario(usuario));
	}

}
