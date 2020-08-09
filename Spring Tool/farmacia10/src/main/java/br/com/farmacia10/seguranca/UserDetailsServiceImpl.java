package br.com.farmacia10.seguranca;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.farmacia10.model.UsuarioModel;
import br.com.farmacia10.repository.UsuarioRepository;

@Service /*Para deixar anotado que a classe trata-se de um serviço*/
public class UserDetailsServiceImpl implements UserDetailsService{
	
	@Autowired
	private UsuarioRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		
		Optional<UsuarioModel> user = userRepository.findByUsuario(userName);
		user.orElseThrow(() -> new UsernameNotFoundException(userName+ " not found."));
		
		return user.map(UserDetailsImpl::new).get();
	}
}
