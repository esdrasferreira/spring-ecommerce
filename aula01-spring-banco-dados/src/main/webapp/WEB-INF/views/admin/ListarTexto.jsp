<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="json" uri="http://www.atg.com/taglibs/json" %>
    <%@taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<json:object>
	<json:array name="produtos" var="produto" items="${catEprod }">
		<json:object>
			<json:property name="id" value="${produto.produtoid }"/>
			<json:property name="nome" value="${produto.nome }"/>
			<json:property name="descricao" value="${produto.descricao }"/>
			<json:property name="valor" value="${produto.valor }"/>
		</json:object>
	</json:array>
</json:object>