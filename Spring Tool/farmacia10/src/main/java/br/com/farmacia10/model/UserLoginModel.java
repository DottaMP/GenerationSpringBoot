package br.com.farmacia10.model;

public class UserLoginModel { /*Não possuirá repository e controller, pois será utilizada apenas para que consiga responder 
								para o client as informações que ele precisa saber referente ao usuário, que será nome, 
	  							usuário, senha e a chave de acesso (token)*/
	
	private String nome;
	
	private String usuario;
	
	private String senha;
	
	private String token;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

}
