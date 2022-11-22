<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div id="item-content">
    <div class="item-container-color"></div>

    <div class="item-pedido-content">
        <div class="item-pedido-leading">
            <img src="${pageContext.request.contextPath}/imgs/icon-money-pedido.png" alt="Icone de dinheiro.">
            <span class="item-pedido-total">Total: R$ ${param.total}</span>
        </div>

        <span class="item-pedido-created-at">Data: ${param.data}</span>
    </div>
</div>

