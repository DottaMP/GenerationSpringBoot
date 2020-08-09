package br.com.farmacia10.service;

import java.nio.charset.Charset;
import java.util.Optional;
import org.apache.commons.codec.binary.Base64;

import br.com.farmacia10.model.UserLoginModel;
import br.com.farmacia10.model.UsuarioModel;
import br.com.farmacia10.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service /*Para deixar anotado que a classe trata-se de um serviço*/
public class UsuarioService {
	
	@Autowired
	private UsuarioRepository repository;
	
	public UsuarioModel CadastrarUsuario(UsuarioModel usuario) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		
		String senhaEncoder = encoder.encode(usuario.getSenha());
		usuario.setSenha(senhaEncoder);
		/*Ao Cadastrar o usuário, a senha cadastrada será encriptada e salva*/
		
		return repository.save(usuario);
	}
	
	public Optional<UserLoginModel> Logar(Optional<UserLoginModel> user){
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		Optional<UsuarioModel> usuario = repository.findByUsuario(user.get().getUsuario());
		
		if(usuario.isPresent()) /*Se houve algo dentro de usuário*/{
			if (encoder.matches(user.get().getSenha(), usuario.get().getSenha())) /*Pegando duas senha, 
				a que está encriptada e a que foi inserida pelo usuário, se as duas forem iguais ele 
				retornará um verdadeiro*/{
				
				String auth = user.get().getUsuario()+ ":" + user.get().getSenha();
				byte[] encodedAuth = Base64.encodeBase64(auth.getBytes(Charset.forName("US-ASCII")));	
				String authHeader = "Basic " + new String(encodedAuth);
				
				user.get().setToken(authHeader);
				user.get().setNome(usuario.get().getNome());
				
				return user;
			}
		}
		
		return null; /*Se não entrar dentro do if, entende-se que não existe esse usuário 
		dentro da base de dados, retornando assim algo nulo*/
		
	}

}
