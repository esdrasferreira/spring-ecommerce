package com.esdras.controlador;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.esdras.model.Administrador;
import com.esdras.model.Cliente;
import com.esdras.service.AdminService;
import com.esdras.service.ClienteService;

@Controller
public class LoginController {

	@Autowired
	private ClienteService clienteService;

	@Autowired
	private AdminService adminService;

	/*
	 * Método que recebe o login do usuario e após validar envia para homepage
	 * novamente com o login efetuado
	 */
	@RequestMapping(value = { "/login" }, method = RequestMethod.POST)
	public ModelAndView login(@RequestParam("email") String email, @RequestParam("senha") String senha,
			HttpSession session, ModelMap modelMap, ModelAndView model) {
		if (email != null && email != "" && senha != null && senha != "") {

			Cliente cliente = new Cliente();
			cliente.setEmail(email);
			cliente.setSenha(senha);

			cliente = (Cliente) clienteService.pesquisar(cliente);
			if (cliente == null) {
				/*
				 * se o login for invalido redireciona para homepage novamente sem efetuar o
				 * login
				 */
				model.setViewName("starter-alibaba-home");
			} else {
				/* se o login validado cria a sessao e direciona para homepage */
				session.setAttribute("cliente", cliente);
				model.setViewName("redirect:/");
			}
		}

		return model;
	}

	/*
	 * Método que recebe o login do Administrador e após validar, direciona para
	 * classe esdras.controlador
	 */
	@RequestMapping(value = { "/adm-page" }, method = RequestMethod.POST)
	public ModelAndView admPage(@RequestParam("email") String email, @RequestParam("senha") String senha,
			HttpSession session, ModelMap modelMap, ModelAndView model) {
		if (email != null && email != "" && senha != null && senha != "") {

			Administrador adm = new Administrador();
			adm.setEmail(email);
			adm.setSenha(senha);

			adm = (Administrador) adminService.pesquisar(adm);
			if (adm == null) {
				model.setViewName("redirect:/");
			} else {

				session.setAttribute("admin", adm);
				session.setAttribute("email", email);
				model.setViewName("redirect:/produtos");
			}
		}

		return model;
	}

	/* Método que realiza o logout e direciona para home page novamente */
	@RequestMapping(value = { "/logout" }, method = RequestMethod.POST)
	public ModelAndView logout(ModelAndView model, HttpSession session) {
		session.invalidate();

		model.setViewName("redirect:/");

		return model;
	}

	/* Método que direciona para a pagina de login para administrador */
	@RequestMapping(value = { "/admin-login-page" }, method = RequestMethod.GET)
	public ModelAndView loginAdmin(ModelAndView model, HttpSession session) {
		session.invalidate();

		model.setViewName("login-admin-page");

		return model;
	}

}
