package com.minhaescola.db_escola.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sun.istack.NotNull;

@Entity
@Table(name = "tb_aluno")
public class aluno {
	
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_aluno")
	private long id;
	
	@Column(name = "nome_aluno")
	@NotNull
	private String nome;
	
	@Column(name = "matriculado_aluno")
	@NotNull
	private String matriculado;
	
	@ManyToOne
	@JsonIgnoreProperties("aluno")
	private turma turma;
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getMatriculado() {
		return matriculado;
	}

	public void setMatriculado(String matriculado) {
		this.matriculado = matriculado;
	}

	public turma getTurma() {
		return turma;
	}

	public void setTurma(turma turma) {
		this.turma = turma;
	}
	
}