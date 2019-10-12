<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"    
    %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Lista de Produtos</title>
</head>
<body>
Total de registros encontrados: <strong>${total}</strong>.<br>

<table border="1">

<c:forEach var="produto" items="${produtosList}">
	<tr>
		<td>${produto.id }</td>
		<td>${produto.nome }</td>
		<td><a href="excluir-produto?id=${produto.id}">Excluir</a> </td>
		<td><a href="atualiza-produto?id=${produto.id}">Atualizar?</a> </td>
	
	</tr>


</c:forEach>
</table>

<br>
<c:if test="${pagina != 1}">
	<a href="?pagina=1">Primeira</a> &nbsp;
</c:if>

<c:forEach begin="1" end="${numeroDePaginas}" var="i"> <!-- for(pagina=1;pagina<2;pagina++) i -->

	<c:choose>
		<c:when test="${pagina eq i}">
			${i}&nbsp;
		</c:when>
		<c:otherwise>
			<a href="?pagina=${i}">${i}</a> &nbsp;
		</c:otherwise>
	</c:choose>

</c:forEach>

<c:if test="${pagina != numeroDePaginas }">
<a href="?pagina=${numeroDePaginas}">Última</a> &nbsp;
</c:if>

</body>
</html>