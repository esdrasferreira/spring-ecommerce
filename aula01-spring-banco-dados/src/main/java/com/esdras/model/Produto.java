package com.esdras.model;

public class Produto {
	private int produtoid;
	private int categoriaid;
	private String nome;
	private String descricao;
	private Double valor;
	private Produto parent;
	private Categoria categoria;
	private Imagem imagem;

	public Produto() {
	}

	public Produto(int produtoid, int categoriaid, String nome, String descricao, Double valor) {

		this.produtoid = produtoid;
		this.categoriaid = categoriaid;
		this.nome = nome;
		this.descricao = descricao;
		this.valor = valor;
	}

	public Produto(int produtoid, int categoriaid, String nome, String descricao, Double valor, Produto parent) {

		this.produtoid = produtoid;
		this.categoriaid = categoriaid;
		this.nome = nome;
		this.descricao = descricao;
		this.valor = valor;
		this.parent = parent;
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
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
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

	public Produto deepCopy() {
		return new Produto(this.produtoid, this.categoriaid, this.nome, this.descricao, this.valor,
				this.parent != null ? this.parent.deepCopy() : null);
	}

}
