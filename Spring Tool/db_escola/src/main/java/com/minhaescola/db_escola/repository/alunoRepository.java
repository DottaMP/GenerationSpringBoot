package com.minhaescola.db_escola.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.minhaescola.db_escola.model.aluno;

@Repository
public interface alunoRepository extends JpaRepository<aluno, Long> {

}

