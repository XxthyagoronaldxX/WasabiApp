<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>

<a class="btn card categoria-item">
    <img alt="ImagemProduto" src="${param.image}"/>
    <p class="mb-0">${param.nome}</p>
    <input id="categoria-id" type="hidden" value="${param.id}"/>
</a>