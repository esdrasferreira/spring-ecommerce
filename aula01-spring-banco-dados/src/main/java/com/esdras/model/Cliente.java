package com.esdras.model;

public class Cliente {

	private int clienteid;
	private String cpf;
	private String nome;
	private String email;
	private int emailConfirmado;
	private String senha;
	private int status;

	public Cliente() {
	}

	public Cliente(int clienteid, String cpf, String nome, String email, int emailConfirmado, String senha,
			int status) {
		this.clienteid = clienteid;
		this.cpf = cpf;
		this.nome = nome;
		this.email = email;
		this.emailConfirmado = emailConfirmado;
		this.senha = senha;
		this.status = status;
	}

	public int getClienteid() {
		return clienteid;
	}

	public void setClienteid(int clienteid) {
		this.clienteid = clienteid;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getEmailConfirmado() {
		return emailConfirmado;
	}

	public void setEmailConfirmado(int emailConfirmado) {
		this.emailConfirmado = emailConfirmado;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

}
