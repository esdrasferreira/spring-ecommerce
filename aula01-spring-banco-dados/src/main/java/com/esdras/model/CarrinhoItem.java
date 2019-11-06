package com.esdras.model;

public class CarrinhoItem {

	private Produto produto;
	Integer quantity;
	Double parcial;

	public CarrinhoItem(Produto produto) {
		this.produto = produto;
		this.quantity = 1;

		this.parcial = getParcial();
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public void increase() {
		this.quantity++;
	}

	public void decrement() {
		this.quantity--;
	}

	public Double getParcial() {
		return parcial;
	}

	public void setParcial(Double parcial) {
		this.parcial = parcial;
	}

}
