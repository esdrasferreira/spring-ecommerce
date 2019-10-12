package com.esdras.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.esdras.service.CategoriaService;

@Controller
public class CategoriaController {

	@Autowired
	private CategoriaService categoriaService;

//	@RequestMapping(value = { "/produtos" }, method = RequestMethod.GET)
//	public ModelAndView produtos(ModelAndView model) {
//
//		List<Categoria> todosProdutos = categoriaService.todos();
//		model.addObject("produtosList", todosProdutos);
//		model.setViewName("listarTodasCategorias");
//
//		return model;
//	}

}
