package com.esdras.controlador;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.esdras.model.Categoria;
import com.esdras.model.Produto;
import com.esdras.service.CategoriaService;
import com.esdras.service.ProdutoService;

@Controller
public class ProdutoController {

	@Autowired
	private ProdutoService produtoService;

	@Autowired
	private CategoriaService categoriaService;

	@RequestMapping(value = { "/" }, method = RequestMethod.GET)
	public ModelAndView home(@RequestParam(value = "pagina", required = false) Integer page_num,

			ModelAndView model) {

		int totalPorPagina = 5;

		if (page_num == null) {
			page_num = 1;
		}

		List<Categoria> categorias = categoriaService.todos();

		List<Categoria> seisPrimeiras = categorias.stream().limit(6).collect(Collectors.toList());
		List<Categoria> aposSeisPrimeiras = categorias.stream().skip(6).collect(Collectors.toList());
		model.addObject("categorias", categorias);
		model.addObject("categorias1", seisPrimeiras);
		model.addObject("categorias2", aposSeisPrimeiras);

		List<Produto> produtos = produtoService.todosComPaginacao(page_num, totalPorPagina);
		model.addObject("catEprod", produtos);
		model.addObject("totalEncontrado", produtoService.getTotalEncontrado());
		model.addObject("numeroDePaginas", produtoService.getPaginas());
		model.addObject("pagina", page_num);

		model.setViewName("starter-alibaba-home");

		return model;
	}

	@RequestMapping(value = { "/produtos" }, method = RequestMethod.GET)
	public ModelAndView produtos(@RequestParam(value = "pagina", required = false) Integer page_num,

			ModelAndView model) {

		int totalPorPagina = 5;

		if (page_num == null) {
			page_num = 1;
		}

		List<Produto> todosProdutos = produtoService.todosComPaginacao(page_num, totalPorPagina);
		model.addObject("produtosList", todosProdutos);
		model.addObject("numeroDepaginas", produtoService.getPaginas());
		model.addObject("pagina", page_num);
		model.addObject("total", produtoService.getTotalEncontrado());

		model.setViewName("listarTodosProdutos");

		return model;
	}

}
