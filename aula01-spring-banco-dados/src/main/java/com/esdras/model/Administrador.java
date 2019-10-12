package com.esdras.model;

public class Administrador {

	private int administradorid;
	private String cpf;
	private String nome;
	private String email;
	private int emailConfirmado;
	private String senha;
	private int nivelAdministrador;
	private int status;

	public Administrador() {
	}

	public Administrador(int administradorid, String cpf, String nome, String email, int emailConfirmado, String senha,
			int nivelAdministrador, int status) {
		this.administradorid = administradorid;
		this.cpf = cpf;
		this.nome = nome;
		this.email = email;
		this.emailConfirmado = emailConfirmado;
		this.senha = senha;
		this.nivelAdministrador = nivelAdministrador;
		this.status = status;
	}

	public int getAdministradorid() {
		return administradorid;
	}

	public void setAdministradorid(int administradorid) {
		this.administradorid = administradorid;
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

	public int getNivelAdministrador() {
		return nivelAdministrador;
	}

	public void setNivelAdministrador(int nivelAdministrador) {
		this.nivelAdministrador = nivelAdministrador;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

}
