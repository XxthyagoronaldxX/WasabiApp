<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>

<jsp:useBean id="produtolistfiltered" scope="session" type="java.util.List"/>

<c:forEach var="produto" items="${produtolistfiltered}">
    <jsp:include page="../card/index.jsp">
        <jsp:param name="nome" value="${produto.getNome()}"/>
        <jsp:param name="descricao" value="${produto.getDescricao()}"/>
        <jsp:param name="image" value="${produto.getImage()}"/>
        <jsp:param name="preco" value="${produto.getPreco().toString()}"/>
        <jsp:param name="id" value="${produto.getId().toString()}"/>
        <jsp:param name="quantidadeProduto" value="${produto.getQuantidade().toString()}"/>
        <jsp:param name="quantidade" value="${produto.getQuantidadeSelected()}"/>
        <jsp:param name="selected" value="${produto.isSelected()}"/>
    </jsp:include>
</c:forEach>


