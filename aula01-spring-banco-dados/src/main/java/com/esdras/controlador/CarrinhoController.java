package com.esdras.controlador;

import java.util.Enumeration;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
	 * da categoria....para listing-page
	 */
	@RequestMapping(value = { "carrinho" }, method = RequestMethod.GET)
	public ModelAndView carrinho(HttpSession session, @RequestParam(value = "id", required = false) Integer idProduto,

			ModelAndView model) {

		Carrinho carrinho = (Carrinho) session.getAttribute("carrinho");

		if (carrinho == null) {
			carrinho = new Carrinho();
		}
		System.out.println(idProduto);

		if (idProduto != null) {
			List<Produto> produto2 = produtoService.listPorId(idProduto);

			for (Produto produto : produto2) {
				carrinho.add(produto);

				System.out.println(
						"ID da categoria: " + produto.getCategoriaid() + "||  ID do produto: " + produto.getProdutoid()
								+ " || Nome do produto: " + produto.getNome() + " || Descrição do produto: "
								+ produto.getDescricao() + "  ||Valor do produto: " + produto.getValor());
			}
		}

		List<Categoria> categorias = categoriaService.todos();
		model.addObject("categorias", categorias);

		session.setAttribute("idProduto", idProduto);
		session.setAttribute("carrinho", carrinho);

		model.setViewName("carrinho");

		return model;
	}

	/*
	 * atualizar carrinho
	 */
	@RequestMapping(value = { "atualizar-carrinho" }, method = RequestMethod.POST)
	public ModelAndView atualizar(HttpServletRequest request, HttpServletResponse response, HttpSession session,
			@RequestParam(value = "id", required = false) Integer idProduto, ModelAndView model) {

		Carrinho carrinho = (Carrinho) session.getAttribute("carrinho");

		if (carrinho == null) {
			carrinho = new Carrinho();
		}

		Enumeration<?> parametros = request.getParameterNames();

		while (parametros.hasMoreElements()) {
			String param = (String) parametros.nextElement();
			System.out.println("Parametros :" + param);
			int lastIndex = param.lastIndexOf("_");
			String idProduto1 = param.substring(lastIndex + 1);

			System.out.println(
					String.format("ID do Produto : %s - Quantidade: %s", idProduto1, request.getParameter(param)));

			Carrinho.atualizar(carrinho, Integer.parseInt(idProduto1), Integer.parseInt(request.getParameter(param)));

		}
		Double total = carrinho.getTotalGeral();
		session.setAttribute("total", total);

		model.setViewName("redirect:carrinho");

		return model;
	}

	/*
	 * remove item
	 */
	@RequestMapping(value = { "remover" }, method = RequestMethod.GET)
	public ModelAndView remover(HttpSession session,
			@RequestParam(value = "produtoid", required = false) Integer produtoid,

			ModelAndView model) {

		Carrinho carrinho = (Carrinho) session.getAttribute("carrinho");

		if (produtoid != null) {
			carrinho.remove(produtoid);
		}

		session.setAttribute("carrinho", carrinho);

		Double total = carrinho.getTotalGeral();
		session.setAttribute("total", total);

		model.setViewName("redirect:carrinho");

		return model;
	}

}
