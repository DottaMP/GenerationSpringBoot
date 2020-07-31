package com.minhaescola.db_escola.repository;

import java.util.List;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.minhaescola.db_escola.model.turma;

@Repository
public interface turmaRepository extends JpaRepository<turma, Long> { /*comunicação entre bd e api*/
	
}
