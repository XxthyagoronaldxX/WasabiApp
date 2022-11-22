<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>

<li class="list-group-item cart-item-content" id="cart-item" data-bs-toggle="modal"
    data-bs-target="#staticBackdrop">
    <div class="list-start">
        <div class="image-wrapper">
            <img src="${param.image}" alt="Imagem Produto Selecionado"/>
        </div>
        <div class="product-info">
            <div class="title-price-content">
                <h5>${param.nome}</h5>
                <span class="rounded-pill bg-danger">R$ ${param.preco}</span>
            </div>
            <div class="descricao-quantidade-content">
                <h6>${param.descricao}</h6>
                <h6>Quant.: ${param.quantidade}</h6>
            </div>
        </div>
    </div>

    <input type="hidden" id="item-cart-nome" value="${param.nome}">
    <input type="hidden" id="item-cart-preco" value="${param.preco}">
    <input type="hidden" id="item-cart-descricao" value="${param.descricao}">
    <input type="hidden" id="item-cart-image" value="${param.image}">
    <input type="hidden" id="item-cart-quantidade-produto" value="${param.quantidadeProduto}">
    <input type="hidden" id="item-cart-id" value="${param.id}"/>
    <input type="hidden" class="cart-item-produto-quantidade" id="item-cart-quantidade" value="${param.quantidade}">
    <input type="hidden" class="cart-item-produto-preco" value="${param.preco}">
</li>
