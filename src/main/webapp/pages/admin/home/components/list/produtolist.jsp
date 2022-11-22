<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<jsp:useBean id="produtolistadmin" scope="session" type="java.util.List" />

<ul id="list-produto">
  <c:forEach var="produto" items="${produtolistadmin}">
    <c:set var="categoria" value="${produto.getProdutoHasCategoriasById().get(0).getCategoriaByCategoriaId()}" />

    <jsp:include page="../produtoitemlist/index.jsp">
      <jsp:param name="nome" value="${produto.getNome()}"/>
      <jsp:param name="descricao" value="${produto.getDescricao()}"/>
      <jsp:param name="preco" value="${produto.getPreco()}"/>
      <jsp:param name="image" value="${produto.getImage()}"/>
      <jsp:param name="quantidade" value="${produto.getQuantidade()}"/>
      <jsp:param name="id" value="${produto.getId()}"/>
      <jsp:param name="categoriaid" value="${categoria.getId()}"/>
      <jsp:param name="categorianome" value="${categoria.getNome()}"/>
    </jsp:include>
  </c:forEach>
</ul>
