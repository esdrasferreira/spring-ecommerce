package com.esdras.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Carrinho {

	private List<CarrinhoItem> itensNoCarrinho;

	private Double totalGeral;

	public void setTotalGeral(Double totalGeral) {
		this.totalGeral = totalGeral;
	}

	public List<CarrinhoItem> getItensNoCarrinho() {
		return itensNoCarrinho;
	}

	public Carrinho() {

		itensNoCarrinho = new ArrayList<CarrinhoItem>();
	}

	// expressao lambda
	public void add(Produto produto) {
		Optional<CarrinhoItem> noCarrinho = itensNoCarrinho.stream()
				.filter(item -> item.getProduto().getProdutoid() == produto.getProdutoid()).peek(e -> e.increase())
				.findAny();

		if (noCarrinho.isEmpty()) {
			CarrinhoItem item = new CarrinhoItem(produto);
			itensNoCarrinho.add(item);
		}
	}

	public void addOld(Produto produto) {

		boolean eNovo = true;
		for (CarrinhoItem carItem : itensNoCarrinho) {
			if (carItem.getProduto().getProdutoid() == produto.getProdutoid()) {
				eNovo = false;
				carItem.increase();
			}
		}

		if (eNovo) {
			CarrinhoItem item = new CarrinhoItem(produto);
			itensNoCarrinho.add(item);
		}

	}

//    public void atualizarLamb(int id, int quantidade) {
//
//        Optional<CarrinhoItem> noCarrinho = itensNoCarrinho.stream()
//                .filter(item -> item.getProduto().getId() == id)
//                .peek(item -> item.setQuantidade(quantidade))
//                .filter(item -> item.getQuantidade() > 0)
//                .findAny();
//
//        if(noCarrinho.isEmpty()) {
//            this.remover(id);
//        }
//
//    }

	public static void atualizar(Carrinho carrinho, int id, Integer quantidade) {

		for (CarrinhoItem carItem : carrinho.itensNoCarrinho) {

			if (carItem.getProduto().getProdutoid() == id) {
				carItem.setQuantity(quantidade);
				carItem.setParcial(carItem.getQuantity() * carItem.getProduto().getValor());

			}

		}

	}

	public Double getTotalGeral() {

		return itensNoCarrinho.stream().mapToDouble(e -> e.getParcial()).sum();
	}

//    public Double getTotal02() {
//
//        Double total = 0.0;
//
//        for (CarrinhoItem item : itensNoCarrinho) {
//
//            total += item.getQuantidade()* item.getProduto().getPreco();
//        }
//
//        return total;
//    }

	public void remove(int id) {
		itensNoCarrinho.removeIf(item -> item.getProduto().getProdutoid() == id);
	}

}
