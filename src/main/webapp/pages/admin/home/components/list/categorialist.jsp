<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<jsp:useBean id="categorialistadmin" scope="session" type="java.util.List" />

<ul id="list-categoria" class="list">
    <c:forEach var="categoria" items="${categorialistadmin}">
        <jsp:include page="../categoriaitemlist/index.jsp">
            <jsp:param name="nome" value="${categoria.getNome()}"/>
            <jsp:param name="image" value="${categoria.getImage()}"/>
            <jsp:param name="id" value="${categoria.getId()}"/>
            <jsp:param name="quantidade" value="${categoria.getProdutoHasCategoriasById().size()}"/>
        </jsp:include>
    </c:forEach>
</ul>
