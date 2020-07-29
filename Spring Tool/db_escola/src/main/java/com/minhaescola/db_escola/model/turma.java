package com.minhaescola.db_escola.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.sun.istack.NotNull;

@Entity /*Vai ser mapeado e passado para o bd em forma de tabela*/
@Table(name="turma")
public class turma {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY) /*Geração de valores: aquele número recebe o conceito de identidade*/
	private long id;
	
	@NotNull
	private String turma;
	
	@NotNull
	private boolean ativo;
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTurma() {
		return turma;
	}

	public void setTurma(String turma) {
		this.turma = turma;
	}

	public boolean isAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}
}
