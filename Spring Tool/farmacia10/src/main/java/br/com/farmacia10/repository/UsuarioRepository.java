package br.com.farmacia10.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.farmacia10.model.UsuarioModel;

@Repository
public interface UsuarioRepository extends JpaRepository<UsuarioModel, Long>{
	public Optional<UsuarioModel> findByUsuario (String usuario); 
	/*Servirá para pegar um usuário pelo User Name. O tipo 'Optional' é usado porque ele pode 
	  retornar um nulo no usuário. O Usuario do 'findBy' refere-se ao atributo usuário da classe de Usuário Model*/
}
