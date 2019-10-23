package com.esdras.controlador;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.esdras.service.ImagemService;

import com.esdras.model.*;

@Controller
public class UploadController {
	
	
	@Autowired
	private ImagemService imgService;
	
	
	
	@GetMapping("/formulario")
	public ModelAndView formulario(ModelAndView model) {
		return new ModelAndView("formulario");
	}

	
	@PostMapping("/upload")
	public ModelAndView upload(@RequestParam MultipartFile imagem, @RequestParam("id") Integer id, ModelAndView model, HttpServletRequest request )
			throws IllegalStateException, IOException {
		String caminhoApp = request.getServletContext().getRealPath("");
		System.out.println("Caminho  app aqui : " + caminhoApp);
		String nomeDoArquivo = this.upoadFile(imagem, id, caminhoApp);
		
	

		if (nomeDoArquivo == null)
			model.addObject("mensagem", "Upload com problema");
		else
			model.addObject("mensagem", "Upload realizado da imagem" + nomeDoArquivo);

		model.setViewName("redirect:/produtos");

		return model;

	}
	
	private String upoadFile(MultipartFile arquivo, Integer id, String caminho) throws IllegalStateException, IOException {

		
		
		
		
		//String caminhoUsuario = System.getProperty("user.home");
		String tipoDeArquivo = arquivo.getContentType();

		List<String> tiposPermitidos = new ArrayList<String>();

		tiposPermitidos.add("image/jpeg");
		tiposPermitidos.add("image/png");

		if (tiposPermitidos.contains(tipoDeArquivo)) {

			String caminhoDoArquivo = caminho + "imagens" + File.separator;
			System.out.println("Caminho das imagens no app aqui : " + caminhoDoArquivo);
			

			String nomeDoArquivo = arquivo.getOriginalFilename();
			String nomeComID = id+nomeDoArquivo;

			File file = new File(caminhoDoArquivo + nomeComID);

			arquivo.transferTo(file);
			
			Imagem img = new Imagem();
			img.setProdutoid(id);
			img.setNome(nomeComID);
			
			
			
			imgService.salvar(img);

			return nomeDoArquivo;

		}

		return null;
	}

}
