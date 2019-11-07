package com.esdras.model;

public class Produto {
	private int produtoid;
	private int categoriaid;
	private String nomeproduto;
	private String descricao;
	private Double valor;

	private Categoria categoria;
	private Imagem imagem;

	public Produto() {
	}

	public Produto(int produtoid, int categoriaid, String nomeproduto, String descricao, Double valor) {

		this.produtoid = produtoid;
		this.categoriaid = categoriaid;
		this.nomeproduto = nomeproduto;
		this.descricao = descricao;
		this.valor = valor;
	}

	public int getProdutoid() {
		return produtoid;
	}

	public void setProdutoid(int produtoid) {
		this.produtoid = produtoid;
	}

	public int getCategoriaid() {
		return categoriaid;
	}

	public void setCategoriaid(int categoriaid) {
		this.categoriaid = categoriaid;
	}

	public String getNome() {
		return nomeproduto;
	}

	public void setNome(String nome) {
		this.nomeproduto = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public Imagem getImagem() {
		return imagem;
	}

	public void setImagem(Imagem imagem) {
		this.imagem = imagem;
	}

}
