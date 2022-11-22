<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>

<jsp:useBean id="bestsellers" scope="session" type="java.util.List"/>

<div class="pic-ctn">
    <c:forEach var="produto" items="${bestsellers}">
        <jsp:include page="../carouselitem/index.jsp">
            <jsp:param name="nome" value="${produto.getNome()}"/>
            <jsp:param name="descricao" value="${produto.getDescricao()}"/>
            <jsp:param name="preco" value="${produto.getPreco().toString()}"/>
            <jsp:param name="id" value="${produto.getId()}"/>
            <jsp:param name="image" value="${produto.getImage()}"/>
            <jsp:param name="quantidadeProduto" value="${produto.getQuantidade()}"/>
            <jsp:param name="quantidade" value="${produtoBean.getQuantidadeSelected()}"/>
            <jsp:param name="selected" value="${produto.isSelected()}"/>
        </jsp:include>
    </c:forEach>
</div>

