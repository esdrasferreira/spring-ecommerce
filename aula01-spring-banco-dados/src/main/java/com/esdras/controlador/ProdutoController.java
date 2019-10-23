package com.esdras.controlador;

import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.esdras.model.Categoria;
import com.esdras.model.Imagem;
import com.esdras.model.Produto;
import com.esdras.service.CategoriaService;
import com.esdras.service.ImagemService;
import com.esdras.service.ProdutoService;

@Controller
public class ProdutoController {

	@Autowired
	private ProdutoService produtoService;

	@Autowired
	private CategoriaService categoriaService;

	@Autowired
	private ImagemService imgService;

	/* metodo carrega itens para alimentar pagina home e direcioa para home-page */
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
		
		List<Imagem> imagens = imgService.todosComPaginacao(page_num, totalPorPagina);

		for (Imagem imagem : imagens) {
			for (Produto produto : produtos) {
				if (produto.getProdutoid() == imagem.getProdutoid()) {
					produto.setImagem(imagem);
					System.out
							.println("Adicionado imagem ao produto ]]]]]]]]]]]]]]]]]]]]]]]]]]" + imagem.getNome());
				}
			}
		}
		
		List<Produto> tresProdutos = produtos.stream().limit(3).collect(Collectors.toList());
		model.addObject("tres", tresProdutos);
		model.addObject("catEprod", produtos);
		model.addObject("totalEncontrado", produtoService.getTotalEncontrado());
		model.addObject("numeroDePaginas", produtoService.getPaginas());
		model.addObject("pagina", page_num);

		model.setViewName("starter-alibaba-home");

		return model;
	}
	/* metodo carrega itens para alimentar pagina product-detail ******** */
	@RequestMapping(value = { "/product" }, method = RequestMethod.GET)
	public ModelAndView product(@RequestParam(value = "pagina", required = false) Integer page_num,

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
		
		List<Imagem> imagens = imgService.todosComPaginacao(page_num, totalPorPagina);

		for (Imagem imagem : imagens) {
			for (Produto produto : produtos) {
				if (produto.getProdutoid() == imagem.getProdutoid()) {
					produto.setImagem(imagem);
					System.out
							.println("Adicionado imagem ao produto ]]]]]]]]]]]]]]]]]]]]]]]]]]" + imagem.getNome());
				}
			}
		}
		
		model.addObject("catEprod", produtos);
		model.addObject("totalEncontrado", produtoService.getTotalEncontrado());
		model.addObject("numeroDePaginas", produtoService.getPaginas());
		model.addObject("pagina", page_num);

		model.setViewName("starter-alibaba-product-detail");

		return model;
	}

	/*
	 * método carrega itens para alimentar pagina CRUD e direciana para paginaCRUD
	 * starter-page-order
	 */
	@RequestMapping(value = { "/produtos" }, method = RequestMethod.GET)
	public ModelAndView produtos(@RequestParam(value = "pagina", required = false) Integer page_num,

			ModelAndView model, HttpSession session) {

		if (session.getAttribute("admin") == null) {
			model.setViewName("redirect:/");
		} else {

			int totalPorPagina = 5;

			if (page_num == null) {
				page_num = 1;
			}

			List<Categoria> categorias = categoriaService.todos();
			model.addObject("categorias", categorias);

			List<Produto> produtos = produtoService.todosComPaginacao(page_num, totalPorPagina);

			List<Imagem> imagens = imgService.todosComPaginacao(page_num, totalPorPagina);

			for (Imagem imagem : imagens) {
				for (Produto produto : produtos) {
					if (produto.getProdutoid() == imagem.getProdutoid()) {
						produto.setImagem(imagem);
						System.out
								.println("Adicionado imagem ao produto ]]]]]]]]]]]]]]]]]]]]]]]]]]" + imagem.getNome());
					}
				}
			}

			for (Produto produto : produtos) {
				System.out.println("--------------------------------Descrição do produto: " + produto.getDescricao());
			}

			model.addObject("catEprod", produtos);
			System.out.println("numero de paginas: " + produtoService.getPaginas());
			System.out.println("pagina: " + page_num);
			System.out.println("totalEncontrado: " + produtoService.getTotalEncontrado());
			model.addObject("numeroDePaginas", produtoService.getPaginas());
			model.addObject("pagina", page_num);
			model.addObject("totalEncontrado", produtoService.getTotalEncontrado());

			model.setViewName("/admin/starter-page-order");
		}

		return model;
	}
	
	/*
	 * método carrega itens para alimentar pagina TXT e direciana para pagina TXT
	 * 	 * starter-page-order
	 */
	@RequestMapping(value = { "/produtos-txt" }, method = RequestMethod.GET)
	public ModelAndView produtosTxt(@RequestParam(value = "pagina", required = false) Integer page_num,

			ModelAndView model, HttpSession session) {

		if (session.getAttribute("admin") == null) {
			model.setViewName("redirect:/");
		} else {

			int totalPorPagina = 5;

			if (page_num == null) {
				page_num = 1;
			}

			List<Categoria> categorias = categoriaService.todos();
			model.addObject("categorias", categorias);

			List<Produto> produtos = produtoService.todosComPaginacao(page_num, totalPorPagina);

			List<Imagem> imagens = imgService.todosComPaginacao(page_num, totalPorPagina);

			for (Imagem imagem : imagens) {
				for (Produto produto : produtos) {
					if (produto.getProdutoid() == imagem.getProdutoid()) {
						produto.setImagem(imagem);
						System.out
								.println("Adicionado imagem ao produto ]]]]]]]]]]]]]]]]]]]]]]]]]]" + imagem.getNome());
					}
				}
			}

			for (Produto produto : produtos) {
				System.out.println("--------------------------------Descrição do produto: " + produto.getDescricao());
			}

			model.addObject("catEprod", produtos);
			System.out.println("numero de paginas: " + produtoService.getPaginas());
			System.out.println("pagina: " + page_num);
			System.out.println("totalEncontrado: " + produtoService.getTotalEncontrado());
			model.addObject("numeroDePaginas", produtoService.getPaginas());
			model.addObject("pagina", page_num);
			model.addObject("totalEncontrado", produtoService.getTotalEncontrado());

			model.setViewName("/admin/ListarTexto");
		}

		return model;
	}


	/*
	 * método adiciona novo produto ao banco de dados e direciana para metodo que
	 * carrega pag CRUD novamente starter-page-order
	 */
	@RequestMapping(value = { "/addProduto" }, method = RequestMethod.POST)
	public ModelAndView addProdutos(@RequestParam(value = "categoria", required = false) Integer categoriaid,
			@RequestParam(value = "nova-categoria", required = false) String novaCategoria,
			@RequestParam(value = "nomeProduto", required = false) String nomeProduto,
			@RequestParam(value = "descrProduto", required = false) String descrProduto,
			@RequestParam(value = "valorProduto", required = false) Double valor,

			ModelAndView model, HttpSession session) {

		if (session.getAttribute("admin") == null) {
			model.setViewName("redirect:/");
		} else {

			Categoria categoria = new Categoria();
			categoria.setNome(novaCategoria);

			Produto produto = new Produto();
			produto.setNome(nomeProduto);
			produto.setDescricao(descrProduto);
			produto.setValor(valor);

			if (novaCategoria != null && novaCategoria != "") {

				/*
				 * se houver nova categoria a ser cadastrada, então cadastra a mesma e utiliza a
				 * nova ID de categoria para salvar o novo produto
				 */
				categoriaService.salvar(categoria);

				Categoria nCategoria = (Categoria) categoriaService.pesquisar(categoria);
				produto.setCategoriaid(nCategoria.getCategoriaid());

			} else {
				/*
				 * se a categoria já é existente apenas usa o ID resgatado do JSP para salvar
				 * novo produto
				 */

				produto.setCategoriaid(categoriaid);
			}

			produtoService.salvar(produto);

			model.setViewName("redirect:/produtos");
		}

		return model;
	}

	/*
	 * método atualiza ou exclui produto carrega pag CRUD novamente
	 * starter-page-order
	 */
	@RequestMapping(value = { "/update" }, method = RequestMethod.POST)
	public ModelAndView updateOrDelete(@RequestParam(value = "salvar", required = false) String salvar,
			@RequestParam(value = "categoria-id", required = false) Integer categoria_id,
			@RequestParam(value = "produtoid", required = false) Integer produtoid,
			@RequestParam(value = "produtonome", required = false) String nome,
			@RequestParam(value = "descricaoProduto", required = false) String descricao,
			@RequestParam(value = "valorProduto", required = false) Double valor,

			ModelAndView model, HttpSession session) {

		/* se salvar não for nulo então atualiza o produto */
		if (salvar != null && !descricao.isEmpty()) {

			Produto produto = new Produto(produtoid, categoria_id, nome, descricao, valor);
			session.setAttribute("produto", produto);

			produtoService.atualizar(produto);

			model.setViewName("redirect:/produtos");

		} else if (salvar != null) {

			Produto produto = produtoService.pesquisarPorId(produtoid);

			produto.setCategoriaid(categoria_id);
			produto.setNome(nome);
			produto.setValor(valor);
			session.setAttribute("produto", produto);

			produtoService.atualizar(produto);

			model.setViewName("redirect:/produtos");
		} else {
			/* se salvar é nulo então exclui o produto */
			Produto produto = new Produto();
			produto.setProdutoid(produtoid);
			session.setAttribute("produto", produto);

			produtoService.excluir(produto);

			model.setViewName("redirect:/produtos");
		}

		return model;
	}

}
