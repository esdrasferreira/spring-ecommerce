package com.esdras.model;

public class Categoria {

	private int categoriaid;
	private String nome;

	public Categoria() {
	}

	public Categoria(int categoriaid, String nome) {
		super();
		this.categoriaid = categoriaid;
		this.nome = nome;
	}

	public int getCategoriaid() {
		return categoriaid;
	}

	public void setCategoriaid(int categoriaid) {
		this.categoriaid = categoriaid;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
