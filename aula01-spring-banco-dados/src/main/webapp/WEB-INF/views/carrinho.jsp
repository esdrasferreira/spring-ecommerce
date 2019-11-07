<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE HTML>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="pragma" content="no-cache" />
<meta http-equiv="cache-control" content="max-age=604800" />
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="author" content="Bootstrap-ecommerce by Vosidiy">

<title>UI KIT - Marketplace and Ecommerce html template</title>

<link href="images/favicon.ico" rel="shortcut icon" type="image/x-icon">

<!-- jQuery -->
	<script src="home_style/js/jquery-2.0.0.min.js" type="text/javascript"></script>

	<!-- Bootstrap4 files-->
	<script src="home_style/js/bootstrap.bundle.min.js"
			type="text/javascript"></script>
	<link href="home_style/css/bootstrap.css" rel="stylesheet"
		  type="text/css" />

<!-- Font awesome 5 -->
	<link href="home_style/fonts/fontawesome/css/fontawesome-all.min.css"
		  type="text/css" rel="stylesheet">

	<!-- custom style -->
	<link href="home_style/css/ui.css" rel="stylesheet" type="text/css" />
	<link href="home_style/css/responsive.css" rel="stylesheet"
		  media="only screen and (max-width: 1200px)" />

	<!-- custom javascript -->
	<script src="home_style/js/script.js" type="text/javascript"></script>

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
<nav class="navbar navbar-top navbar-expand-lg navbar-dark bg-secondary">
<div class="container">
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>
  <div class="collapse navbar-collapse" id="navbarNav">
    <ul class="navbar-nav">
<li class="nav-item active">
<a class="nav-link" href="${pageContext.request.contextPath}/">Home <span class="sr-only">(current)</span></a>
</li>
<li class="nav-item"><a class="nav-link" href="html-components.html"> Documentation </a></li>
<li class="nav-item dropdown">
	<a class="nav-link  dropdown-toggle" href="#" data-toggle="dropdown">  Categorias  </a>
    <ul class="dropdown-menu">
	  <%--INICIO foreach para as categorias --%>
								<c:forEach var="categorias" items="${categorias}">

									<li><a class="dropdown-item" href="listing?categoria=${categorias.categoriaid}">${categorias.nome}</a></li>

								</c:forEach>
		<%--FIM foreach para as categorias --%>
    </ul>
    
    
    
</li>
<li class="nav-item"><a class="nav-link" href="http://bootstrap-ecommerce.com"> Download <i class="fa fa-download"></i></a></li>
    </ul>
  </div>
</div> <!-- container //  -->
</nav>
<section class="header-main">
	<div class="container">
<div class="row align-items-center">
	<div class="col-lg-3 col-sm-4">
	<div class="brand-wrap">
		<img class="logo" src="images/logo-dark.png">
		<h2 class="logo-text">LOGO</h2>
	</div> <!-- brand-wrap.// -->
	</div>
	<div class="col-lg-6 col-sm-8">
			<form action="#" class="search-wrap">
				<div class="input-group w-100">
				    <input type="text" class="form-control" style="width:55%;" placeholder="Search">
				    <select class="custom-select"  name="category_name">
							<option value="">All type</option><option value="codex">Special</option>
							<option value="comments">Only best</option>
							<option value="content">Latest</option>
					</select>
				    <div class="input-group-append">
				      <button class="btn btn-primary" type="submit">
				        <i class="fa fa-search"></i>
				      </button>
				    </div>
			    </div>
			</form> <!-- search-wrap .end// -->
	</div> <!-- col.// -->
	<div class="col-lg-3 col-sm-12">
			<a href="#" class="widget-header float-md-right">
				<div class="icontext">
					<div class="icon-wrap"><i class="flip-h fa-lg fa fa-phone"></i></div>
					<div class="text-wrap">
						<small>Phone</small>
						<div>+97150 2813773</div>
					</div>
				</div>
			</a>
	</div> <!-- col.// -->
</div> <!-- row.// -->
	</div> <!-- container.// -->
</section> <!-- header-main .// -->
</header> <!-- section-header.// -->


<!-- ========================= SECTION CONTENT ========================= -->
<section class="section-content bg padding-y border-top">
<div class="container">

<div class="row">
	<main class="col-sm-9">

<div class="card">
	<!-- ========================= INICIO DO FORM  ========================= -->
	<form action="atualizar-carrinho" method="post">
<table class="table table-hover shopping-cart-wrap">
<thead class="text-muted">
<tr>
  <th scope="col">Product</th>
  <th scope="col" width="120">Quantity</th>
  <th scope="col" width="120">Price</th>
  <th scope="col" width="120">Total Price</th>
  <th scope="col" class="text-right" width="200">Action</th>
</tr>
</thead>
<tbody>
<c:forEach var="carrinho" items="${carrinho.itensNoCarrinho}">
<tr> <!-- inicio each -->
	<td>
<figure class="media">
	<div class="img-wrap"><img src="images/items/1.jpg" class="img-thumbnail img-sm"></div>
	<figcaption class="media-body">
		<h6 class="title text-truncate">${carrinho.produto.nome} </h6>
		<dl class="dlist-inline small">
		  <dt>Size: </dt>
		  <dd>XXL</dd>
		</dl>
		<dl class="dlist-inline small">
		  <dt>Color: </dt>
		  <dd>Orange color</dd>
		</dl>
	</figcaption>
</figure> 
	</td>
	<td>
		<input type="number" min="1" value="${carrinho.quantity}" name="quantidade_${carrinho.produto.produtoid}">
<%--		<select class="form-control" type="number" name="quantidade_${carrinho.produto.produtoid}" >--%>
<%--			<option>1</option>--%>
<%--			<option>2</option>--%>
<%--			<option>3</option>--%>
<%--			<option>4</option>--%>
<%--			<option>5</option>--%>
<%--			<option>6</option>--%>
<%--		</select>--%>

	</td>
	<td>

		<div class="price-wrap">
			<var class="price"><fmt:formatNumber value="${carrinho.produto.valor}" type="currency" /></var>
			<small class="text-muted">(USD5 each)</small>
		</div> <!-- price-wrap .// -->
	</td>
	<td>
		<div class="price-wrap">
			<c:choose>
				<c:when test="${carrinho.parcial == null}">
				<var class="price" id="total-price"><fmt:formatNumber value="${carrinho.produto.valor}" type="currency" /> </var>
				</c:when>
				<c:otherwise>
				<var class="price" id="total-price"><fmt:formatNumber value="${carrinho.parcial}" type="currency" /> </var>
				</c:otherwise>
			</c:choose>


		</div> <!-- price-wrap .// -->
	</main>
	<td class="text-right">

		<button type="button" onclick="window.location.href='remover?produtoid=${carrinho.produto.produtoid}';" class="btn btn-danger" name="remove">Remove</button>
		
	</td>
</tr>  <!-- fim each   -->
</c:forEach>

</tbody>
</table>
		<div>


			

			<button type="submit" class="btn btn-primary">Update</button>

		</div>
	</form>
	<!-- ========================= FIM DO FORM  ========================= -->
</div> <!-- card.// -->

	</main> <!-- col.// -->
	<aside class="col-sm-3">
<p class="alert alert-success">Add USD 5.00 of eligible items to your order to qualify for FREE Shipping. </p>
<dl class="dlist-align">

  <dt>Total price: </dt>
  <dd class="text-right">USD 658</dd>
</dl>
<dl class="dlist-align">
  <dt>Discount:</dt>
  <dd class="text-right">USD 658</dd>
</dl>
<dl class="dlist-align h4">
  <dt>Total:</dt>
  <c:choose>
  <c:when test="${total != null}">
  <dd class="text-right"><strong><var class="price" id="total"><fmt:formatNumber value="${total}" type="currency" /></var></strong></dd>
 </c:when>
 <c:otherwise>
 <dd class="text-right"><strong><var class="price" id="total"><fmt:formatNumber value="0.00" type="currency" /></var></strong></dd>
 </c:otherwise>
  </c:choose>
</dl>
<hr>



<figure class="itemside mb-3">
	<aside class="aside"><img src="images/icons/pay-visa.png"></aside>
	 <div class="text-wrap small text-muted">
Pay 84.78 AED ( Save 14.97 AED )
By using ADCB Cards 
	 </div>
</figure>
<figure class="itemside mb-3">
	<aside class="aside"> <img src="images/icons/pay-mastercard.png"> </aside>
	<div class="text-wrap small text-muted">
Pay by MasterCard and Save 40%. <br>
Lorem ipsum dolor 
	</div>
</figure>

	</aside> <!-- col.// -->
</div>

</div> <!-- container .//  -->
</section>
<!-- ========================= SECTION CONTENT END// ========================= -->

<!-- ========================= SECTION  ========================= -->
<section class="section-name bg-white padding-y">
<div class="container">
<header class="section-heading">
<h2 class="title-section">Section name</h2>
</header><!-- sect-heading -->

<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod
tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam,
quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo
consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse
cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non
proident, sunt in culpa qui officia deserunt mollit anim id est laborum.</p>
</div><!-- container // -->
</section>
<!-- ========================= SECTION  END// ========================= -->

<!-- ========================= SECTION  ========================= -->
<section class="section-name bg padding-y">
<div class="container">
<h4>Another section if needed</h4>
<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod
tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam,
quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo
consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse
cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non
proident, sunt in culpa qui officia deserunt mollit anim id est laborum.</p>
</div><!-- container // -->
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
						<li> <a href="#">Help center</a></li>
						<li> <a href="#">Money refund</a></li>
						<li> <a href="#">Terms and Policy</a></li>
						<li> <a href="#">Open dispute</a></li>
					</ul>
				</aside>
				<aside class="col-sm-3  col-md-3 white">
					<h5 class="title">My Account</h5>
					<ul class="list-unstyled">
						<li> <a href="#"> User Login </a></li>
						<li> <a href="#"> User register </a></li>
						<li> <a href="#"> Account Setting </a></li>
						<li> <a href="#"> My Orders </a></li>
						<li> <a href="#"> My Wishlist </a></li>
					</ul>
				</aside>
				<aside class="col-sm-3  col-md-3 white">
					<h5 class="title">About</h5>
					<ul class="list-unstyled">
						<li> <a href="#"> Our history </a></li>
						<li> <a href="#"> How to buy </a></li>
						<li> <a href="#"> Delivery and payment </a></li>
						<li> <a href="#"> Advertice </a></li>
						<li> <a href="#"> Partnership </a></li>
					</ul>
				</aside>
				<aside class="col-sm-3">
					<article class="white">
						<h5 class="title">Contacts</h5>
						<p>
							<strong>Phone: </strong> +123456789 <br> 
						    <strong>Fax:</strong> +123456789
						</p>

						 <div class="btn-group white">
						    <a class="btn btn-facebook" title="Facebook" target="_blank" href="#"><i class="fab fa-facebook-f  fa-fw"></i></a>
						    <a class="btn btn-instagram" title="Instagram" target="_blank" href="#"><i class="fab fa-instagram  fa-fw"></i></a>
						    <a class="btn btn-youtube" title="Youtube" target="_blank" href="#"><i class="fab fa-youtube  fa-fw"></i></a>
						    <a class="btn btn-twitter" title="Twitter" target="_blank" href="#"><i class="fab fa-twitter  fa-fw"></i></a>
						</div>
					</article>
				</aside>
			</div> <!-- row.// -->
			<br> 
		</section>
		<section class="footer-bottom row border-top-white">
			<div class="col-sm-6"> 
				<p class="text-white-50"> Made with <3 <br>  by Vosidiy M.</p>
			</div>
			<div class="col-sm-6 text-right">
				<p class="text-sm-right text-white-50">
	Copyright &copy 2018 <br>
<a href="http://bootstrap-ecommerce.com" class="text-white-50">Bootstrap-ecommerce UI kit</a>
				</p>
			</div>
		</section> <!-- //footer-top -->
	</div><!-- //container -->
</footer>
<!-- ========================= FOOTER END // ========================= -->


</body>
</html>