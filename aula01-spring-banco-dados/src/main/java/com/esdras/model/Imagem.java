package com.esdras.model;

public class Imagem {

	private int imagemid;
	private int produtoid;
	private String nome;

	public Imagem() {
	}

	public Imagem(int imagemid, int produtoid, String nome) {

		this.imagemid = imagemid;
		this.produtoid = produtoid;
		this.nome = nome;
	}

	public int getImagemid() {
		return imagemid;
	}

	public void setImagemid(int imagemid) {
		this.imagemid = imagemid;
	}

	public int getProdutoid() {
		return produtoid;
	}

	public void setProdutoid(int produtoid) {
		this.produtoid = produtoid;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
