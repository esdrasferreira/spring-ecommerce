package com.esdras.controlador;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.esdras.model.Cliente;
import com.esdras.service.ClienteService;

@Controller
public class LoginController {

	@Autowired
	private ClienteService clienteService;

	@RequestMapping(value = { "/login" }, method = RequestMethod.POST)
	public ModelAndView login(@RequestParam("email") String email, @RequestParam("senha") String senha,
			HttpSession session, ModelMap modelMap, ModelAndView model) {
		if (email != null && email != "" && senha != null && senha != "") {

			Cliente cliente = new Cliente();
			cliente.setEmail(email);
			cliente.setSenha(senha);

			cliente = (Cliente) clienteService.pesquisar(cliente);
			if (cliente == null) {
				model.setViewName("starter-alibaba-home");
			} else {
				session.setAttribute("cliente", cliente);
				model.setViewName("/");
			}
		}

		return model;
	}

	@RequestMapping(value = { "/logout" }, method = RequestMethod.POST)
	public ModelAndView produtos(ModelAndView model, HttpSession session) {
		session.invalidate();

		model.setViewName("/");

		return model;
	}

}
