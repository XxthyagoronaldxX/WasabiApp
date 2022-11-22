<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<jsp:useBean id="pedidolist" scope="session" type="java.util.List"/>
<c:set var="size" value="${pedidolist.size()}"/>

<c:if test="${size > 0}">
    <c:forEach var="pedido" items="${pedidolist}">
        <c:set var="produto" value="${pedido.getProdutoByProdutoId()}"/>

        <jsp:include page="../cartitem/index.jsp">
            <jsp:param name="id" value="${produto.getId()}"/>
            <jsp:param name="nome" value="${produto.getNome()}"/>
            <jsp:param name="descricao" value="${produto.getDescricao()}"/>
            <jsp:param name="preco" value="${produto.getPreco().toString()}"/>
            <jsp:param name="image" value="${produto.getImage()}"/>
            <jsp:param name="quantidade" value="${pedido.getQuantidade().toString()}"/>
            <jsp:param name="quantidadeProduto" value="${produto.getQuantidade()}"/>
        </jsp:include>
    </c:forEach>
</c:if>
