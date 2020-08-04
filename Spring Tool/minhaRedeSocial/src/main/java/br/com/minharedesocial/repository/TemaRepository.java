package br.com.minharedesocial.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.minharedesocial.model.TemaModel;

@Repository
public interface TemaRepository extends JpaRepository<TemaModel, Long>{

}
