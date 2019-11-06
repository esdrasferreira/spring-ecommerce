package com.esdras.controlador;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.esdras.model.Carrinho;
import com.esdras.model.Categoria;
import com.esdras.model.Produto;
import com.esdras.service.CategoriaService;
import com.esdras.service.ImagemService;
import com.esdras.service.ProdutoService;

@Controller
public class CarrinhoController {

	@Autowired
	private ProdutoService produtoService;

	@Autowired
	private CategoriaService categoriaService;

	@Autowired
	private ImagemService imgService;

	/*
	 * metodo carrega produtos por ID da categoria e alimenta pagina com os produtos
	 * da categoria listing-page
	 */
	@RequestMapping(value = { "carrinho" }, method = RequestMethod.GET)
	public ModelAndView carrinho(HttpSession session, @RequestParam(value = "id", required = false) Integer idProduto,

			ModelAndView model) {
		session.getAttribute("carrinho");

		Carrinho carrinho = (Carrinho) session.getAttribute("carrinho");

		if (carrinho == null) {
			carrinho = new Carrinho();
		}

		Produto produto = produtoService.pesquisarPorId(idProduto);
		carrinho.add(produto);

		Double total = carrinho.calc(carrinho);

		List<Categoria> categorias = categoriaService.todos();
		model.addObject("categorias", categorias);

		session.setAttribute("total", total);
		session.setAttribute("idProduto", idProduto);
		session.setAttribute("carrinho", carrinho);

		model.setViewName("carrinho");

		return model;
	}

}
