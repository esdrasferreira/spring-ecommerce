<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE HTML>
<html lang="pt-br">

<head>
<meta charset="utf-8">
<meta http-equiv="pragma" content="no-cache" />
<meta http-equiv="cache-control" content="max-age=604800" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="author" content="Bootstrap-ecommerce">

<title>Admin template</title>

<link href="admin_css/home_style/images/favicon.ico" rel="shortcut icon"
	  type="image/x-icon">

<!-- jQuery -->
<script src="admin_css/home_style/js/jquery-2.0.0.min.js" type="text/javascript"></script>

<!-- Axios -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/axios/0.19.0/axios.min.js" type="text/javascript"></script>



<!-- Bootstrap4 files-->
<script src="admin_css/home_style/js/bootstrap.bundle.min.js"
	type="text/javascript"></script>
<link href="admin_css/home_style/css/bootstrap.css" rel="stylesheet"
	  type="text/css" />

<!-- Font awesome 5 -->
<link href="admin_css/home_style/fonts/fontawesome/css/fontawesome-all.min.css"
	type="text/css" rel="stylesheet">

<!-- custom style -->
<link href="admin_css/home_style/css/ui.css" rel="stylesheet" type="text/css" />
<link href="admin_css/home_style/css/responsive.css" rel="stylesheet"
	  media="only screen and (max-width: 1200px)" />

<!-- custom javascript -->
<script src="admin_css/home_style/js/script.js" type="text/javascript"></script>

<script type="text/javascript">
	/// some script

	// jquery ready start
	$(document).ready(function() {
		// jQuery code

	});
	// jquery end
</script>

</head>

<body>
	<header class="section-header">
		<nav
			class="navbar navbar-top navbar-expand-lg navbar-dark bg-secondary">
			<div class="container">
				<button class="navbar-toggler" type="button" data-toggle="collapse"
					data-target="#navbarNav" aria-controls="navbarNav"
					aria-expanded="false" aria-label="Toggle navigation">
					<span class="navbar-toggler-icon"></span>
				</button>
				<div class="collapse navbar-collapse" id="navbarNav">
					<ul class="navbar-nav">
						<li class="nav-item active"><a class="nav-link" href="/">Home
								<span class="sr-only">(current)</span>
						</a></li>
						<li class="nav-item"><a class="nav-link" href="listar-txt.html">
								Produtos JSON </a></li>
						<li class="nav-item dropdown"><a
							class="nav-link  dropdown-toggle" href="#" data-toggle="dropdown">
								Dropdown </a>
							<ul class="dropdown-menu">
								<li><a class="dropdown-item" href="#"> Menu item 1</a></li>
								<li><a class="dropdown-item" href="#"> Menu item 2 </a></li>
							</ul></li>

					</ul>
				</div>
			</div>
			<!-- container //  -->
		</nav>
		<section class="header-main">
			<div class="container">
				<div class="row align-items-center">
					<div class="col-lg-3 col-sm-4">
						<div class="brand-wrap">
							<img class="logo" src="admin_css/home_style/images/logo-dark.png">
							<h2 class="logo-text">LOGO</h2>
						</div>
						<!-- brand-wrap.// -->
					</div>
					<div class="col-lg-6 col-sm-8">
						<form action="#" class="search-wrap">
							<div class="input-group w-100">
								<input type="text" class="form-control" style="width: 55%;"
									placeholder="Search"> <select class="custom-select"
									name="category_name">
									<option value="">All type</option>
									<option value="codex">Special</option>
									<option value="comments">Only best</option>
									<option value="content">Latest</option>
								</select>
								<div class="input-group-append">
									<button class="btn btn-primary" type="submit">
										<i class="fa fa-search"></i>
									</button>
								</div>
							</div>
						</form>
						<!-- search-wrap .end// -->
					</div>
					<!-- col.// -->
					<div class="col-lg-3 col-sm-12">
						<a href="#" class="widget-header float-md-right">
							<div class="icontext">
								<div class="icon-wrap">
									<i class="flip-h fa-lg fa fa-phone"></i>
								</div>
								<div class="text-wrap">
									<small>Phone</small>
									<div>+97150 2813773</div>
								</div>
							</div>
						</a>
					</div>
					<!-- col.// -->
				</div>
				<!-- row.// -->
			</div>
			<!-- container.// -->
		</section>
		<!-- header-main .// -->
	</header>
	<!-- section-header.// -->


	<!-- ========================= SECTION CONTENT ========================= -->
	<section class="section-content bg padding-y border-top">
		<div class="container">

			<div class="row">
				<main class="col-sm-12">

				<div class="card">
					<table class="table table-hover shopping-cart-wrap">
						<thead class="text-muted">
							<tr>
								<th scope="" class="col-sm-10">Product</th>



							</tr>
						</thead>
						<tbody>

							<tr>
								<!--form  START-->
								<form action="/addProduto" method="post">
									<td>
										<figure class="media">
											<div class="img-wrap">
												<img src="admin_css/home_style/images/items/1.jpg"
													class="img-thumbnail img-sm">
											</div>
											<figcaption class="media-body">
												<div class="row">
													<div class="col">
														<h5 class="title text-sm-right">Categorias :</h5>
													</div>
													<div class="col">
														<div class="form-group">
															<select class="form-control col-sm-8" name="categoria"
																id="exampleFormControlSelect1">
																<c:forEach var="categorias" items="${categorias}">
																	<option value="${categorias.categoriaid}">
																		${categorias.nome}</option>
																</c:forEach>
															</select>
														</div>
													</div>
													<div class="col">
														<input class="form-control  col-sm-8 " type="text"
															name="nova-categoria" value=""
															style="background-color: white;"
															placeholder="Criar nova categoria">
													</div>
												</div>

												<input class="form-control mb-2" type="text"
													name="nomeProduto" value=""
													style="background-color: white;"
													placeholder="Nome do produto"> <textarea
													class="form-control mb-2"  name="descrProduto"
													style="background-color: white;"
													placeholder="Descrição do produto" rows="3"></textarea>
												
												<div class="row">
													<%-- INICIO LINHA  VALOR --%>
													<div class="col">
														<%-- inicio COLUNA1 --%>
														<%-- --------INICIO valor do produto------- --%>
														<input class="form-control  col-sm-2  text-right"
															type="number" name="valorProduto" value=""
															style="background-color: white;" placeholder="0.00">
														<%-- --------FIM valor do produto------- --%>
													</div><%-- FIM COLUNA1 --%>
													


												</div><%--FIM LINHA  VALOR --%>



											</figcaption>
										</figure>
									

									</td>
									<td class="text-wrap">
										<button class="btn btn-outline-success" type="submit">
											Adicionar</button>

									</td>
								</form>
								<!--form  END-->
							</tr>

						</tbody>
					</table>
				</div>
				<!-- card.// --> </main>
				<!-- col.// -->

			</div>


		</div>
		<!-- container .//  -->
	</section>
	<!-- ========================= SECTION CONTENT END// ========================= -->

	<!-- ========================= SECTION CONTENT 2========================= -->
	<section class="section-content bg padding-y border-top">
		<div class="container">

			<div class="row">
				<main class="col-sm-12">

				<div class="card">
					<table class="table shopping-cart-wrap">
						<thead class="text-muted">
							<tr>
								<th scope="" class="col-sm-10">Product</th>



							</tr>
						</thead>
						<c:forEach var="produtos" items="${catEprod}">
							<!--  recebe List de Produtos e Categorias -->
							<tbody>
								<tr>
									<!--form  START-->

									<form action="${pageContext.request.contextPath}/update" method="post" enctype="multipart/form-data">
										<td> 
										  
											<figure class="media">
												<div class="img-wrap">
												

												

													<img src="${pageContext.request.contextPath}/imagens/${produtos.imagem.nome}"
													class="img-thumbnail img-sm">
														
												</div>
												<figcaption class="media-body">



													<div class="form-group row">
														<label  class="col-sm-2 col-form-label text-right">Categoria:</label>

													<div class="col-sm-10">


															<select class="form-control col-sm-4 text-right"
																id="exampleFormControlSelect1" name="categoria-id">
																<c:forEach var="categorias" items="${categorias}">
																	<!--  recebe List de	categorias -->
																	<option value="${categorias.categoriaid}"
																		<c:if test="${produtos.categoria.categoriaid == categorias.categoriaid}"> selected </c:if>>
																		${categorias.nome}</option>
																</c:forEach>

															</select>
														</div>
													</div>
													</div>
													
													<div class="form-group row">
														<label  class="col-sm-2 col-form-label text-right">Produto:</label>

													<div class="col-sm-10">
													
													<input class="form-control mb-2" type="text"
														name="produtonome" value="${produtos.nome}"
														style="background-color: white;"
														placeholder="${produtos.nome}"> 
														
															</div>
													</div>
													
													<div class="form-group row">
						<label  class="col-sm-2 col-form-label text-right">Descrição:</label>

						<div class="col-sm-10">
														<textarea
													class="form-control mb-2"  name="descricaoProduto"
													style="background-color: white;"
													placeholder="${produtos.descricao }" rows="3"></textarea>
													</div>
					</div>
														<div class="form-group row">
																<label  class="col-sm-2 col-form-label text-right">Valor:</label>

																<div class="col-sm-10">
														<input class="form-control  col-sm-4  text-right" type="number"
														name="valorProduto" value="${produtos.valor}"
														style="background-color: white;"
														placeholder="${produtos.valor}"> 
														 <input	type="hidden" name="produtoid"
														value="${produtos.produtoid}">
														</div> <%--close col1 --%>
															</div>
														
														
														




												</figcaption>
											</figure>
										

										</td>
										<td class="text-wrap">

											<button type="submit" class="btn btn-outline-warning"
												name="salvar">Atualizar</button>
											<button type="submit" class="btn btn-outline-danger"
												name="excluir">Excluir</button>

										</td>
									</form>
									<!--form  END-->
									
									
									
								</tr>
								<tr>
								
								
								<td class="text-muted">
								<div  padding-left: ($spacer * .5) !important;>
															<%-- --------INICIO escolha de figura para upload------- --%>

														<form class="form-inline" action="${pageContext.request.contextPath}/upload" method="post"
															enctype="multipart/form-data">
															<div class="input-group mb-3">
																<div class="custom-file">

																	<input type="file" name="imagem"
																		class="custom-file-input" id="inputGroupFile02">
																	<label class="custom-file-label" for="inputGroupFile02"></label>

																</div>
																<div class="input-group-append">
																	<button class="btn btn-dark rounded-right"
																		type="submit">Enviar Imagem</button>
																	<input type="hidden" value="${produtos.produtoid}" name="id">
																</div>
															</div>
														</form>

														<%-- --------FIM escolha de figura para upload------- --%>
														<script type="text/javascript">
															$('#inputGroupFile02').on('change',function() {
															//get the file name
																var fileName = $(this).val().replace('C:\\fakepath\\'," ");
															//replace the "Choose a file" label
																$(this).next('.custom-file-label').html(fileName);
																})
														</script> 


													</div>
														</div> <%--close col2 --%>
								</td>
								
								</tr>

							</tbody>
						</c:forEach>
					</table>
				</div>
				<!-- card.// --> </main>
				<!-- col.// -->

			</div>

		</div>
		<!-- container .//  -->
	</section>
	<!-- ========================= SECTION CONTENT 2 END// ========================= -->
	<!-- ========================= PAGINACAO // ========================= -->


	<nav aria-label="Page navigation example">
		<ul class="pagination justify-content-center">

			<%-- mostra previos link --%>
			<c:forEach begin="1" end="${numeroDePaginas}" var="i">
				<c:choose>
					<c:when test="${pagina eq i && pagina != 1}">
						<li class="page-item"><a class="page-link"
							href="?pagina=${i-1}"> Previous </a>
					</c:when>
					<c:otherwise>
						<%-- se for primeira pagina não mostra nada--%>
					</c:otherwise>
				</c:choose>


			</c:forEach>
			<%-- mostra Previos link  desativado se for primeira pagina--%>
			<c:if test="${pagina == 1}">
				<li class="page-item disabled"><a class="page-link" href="#">
						Previous </a>
			</c:if>

			</li>
			<%-- Para mostrar o número de páginas --%>
			<c:forEach begin="1" end="${numeroDePaginas}" var="i">
				<c:choose>
					<c:when test="${pagina eq i}">
						<li class="page-item disabled"><a class="page-link" href="#">${i}</a></li>
					</c:when>
					<c:otherwise>
						<li class="page-item"><a class="page-link"
							href="?pagina=${i}">${i}</a></li>

					</c:otherwise>
				</c:choose>
			</c:forEach>
			<%-- mostra Next link --%>
			<c:forEach begin="1" end="${numeroDePaginas}" var="i">
				<c:choose>
					<c:when test="${pagina eq i && pagina != numeroDePaginas}">

						<li class="page-item"><a class="page-link"
							href="?pagina=${i+1}"> Next </a>
					</c:when>
					<c:otherwise>
						<%-- se for ultima pagina não mostra nada--%>
					</c:otherwise>
				</c:choose>


			</c:forEach>
			<%-- mostra Next link  desativado se for primeira pagina--%>
			<c:if test="${pagina == numeroDePaginas}">
				<li class="page-item disabled"><a class="page-link" href="#">
						Next </a>
			</c:if>


			</li>
		</ul>
	</nav>

	<!-- ========================= PAGINACAO END// ========================= -->


	<!-- ========================= SECTION  ========================= -->
	<section class="section-name bg-white padding-y">
		<div class="container">
			<header class="section-heading">
				<h2 class="title-section">Section name</h2>
			</header>
			<!-- sect-heading -->

			<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed
				do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut
				enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi
				ut aliquip ex ea commodo consequat. Duis aute irure dolor in
				reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla
				pariatur. Excepteur sint occaecat cupidatat non proident, sunt in
				culpa qui officia deserunt mollit anim id est laborum.</p>
		</div>
		<!-- container // -->
	</section>
	<!-- ========================= SECTION  END// ========================= -->

	<!-- ========================= SECTION  ========================= -->
	<section class="section-name bg padding-y">
		<div class="container">
			<h4>Another section if needed</h4>
			<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed
				do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut
				enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi
				ut aliquip ex ea commodo consequat. Duis aute irure dolor in
				reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla
				pariatur. Excepteur sint occaecat cupidatat non proident, sunt in
				culpa qui officia deserunt mollit anim id est laborum.</p>
		</div>
		<!-- container // -->
	</section>
	<!-- ========================= SECTION  END// ========================= -->

	<!-- ========================= FOOTER ========================= -->
	<footer class="section-footer bg-secondary">
		<div class="container">
			<section class="footer-top padding-top">
				<div class="row">
					<aside class="col-sm-3 col-md-3 white">
						<h5 class="title">Customer Services</h5>
						<ul class="list-unstyled">
							<li><a href="#">Help center</a></li>
							<li><a href="#">Money refund</a></li>
							<li><a href="#">Terms and Policy</a></li>
							<li><a href="#">Open dispute</a></li>
						</ul>
					</aside>
					<aside class="col-sm-3  col-md-3 white">
						<h5 class="title">My Account</h5>
						<ul class="list-unstyled">
							<li><a href="#"> User Login </a></li>
							<li><a href="#"> User register </a></li>
							<li><a href="#"> Account Setting </a></li>
							<li><a href="#"> My Orders </a></li>
							<li><a href="#"> My Wishlist </a></li>
						</ul>
					</aside>
					<aside class="col-sm-3  col-md-3 white">
						<h5 class="title">About</h5>
						<ul class="list-unstyled">
							<li><a href="#"> Our history </a></li>
							<li><a href="#"> How to buy </a></li>
							<li><a href="#"> Delivery and payment </a></li>
							<li><a href="#"> Advertice </a></li>
							<li><a href="#"> Partnership </a></li>
						</ul>
					</aside>
					<aside class="col-sm-3">
						<article class="white">
							<h5 class="title">Contacts</h5>
							<p>
								<strong>Phone: </strong> +123456789 <br> <strong>Fax:</strong>
								+123456789
							</p>

							<div class="btn-group white">
								<a class="btn btn-facebook" title="Facebook" target="_blank"
									href="#"><i class="fab fa-facebook-f  fa-fw"></i></a> <a
									class="btn btn-instagram" title="Instagram" target="_blank"
									href="#"><i class="fab fa-instagram  fa-fw"></i></a> <a
									class="btn btn-youtube" title="Youtube" target="_blank"
									href="#"><i class="fab fa-youtube  fa-fw"></i></a> <a
									class="btn btn-twitter" title="Twitter" target="_blank"
									href="#"><i class="fab fa-twitter  fa-fw"></i></a>
							</div>
						</article>
					</aside>
				</div>
				<!-- row.// -->
				<br>
			</section>
			<section class="footer-bottom row border-top-white">
				<div class="col-sm-6">
					<p class="text-white-50">
						Made with <3 <br> by Vosidiy M.
					</p>
				</div>
				<div class="col-sm-6 text-right">
					<p class="text-sm-right text-white-50">
						Copyright &copy 2018 <br> <a href="#" class="text-white-50">ecommerce</a>
					</p>
				</div>
			</section>
			<!-- //footer-top -->
		</div>
		<!-- //container -->
	</footer>
	<!-- ========================= FOOTER END // ========================= -->


</body>

</html>