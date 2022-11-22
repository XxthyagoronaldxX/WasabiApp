<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>

<div class="card card-conteiner">
    <div class="card-img-content">
        <img alt="ImagemProduto" class="card-img-top"
             src="${param.image}"/>
    </div>

    <div class="card-description-content">
        <h5>${param.nome}</h5>
        <h6>${param.descricao}</h6>
    </div>

    <c:choose>
        <c:when test="${param.selected == false}">
            <p class="btn adicionar-badge badge" id="card-button-add-produto" data-bs-toggle="modal"
               data-bs-target="#staticBackdrop">
                Adicionar
            </p>
        </c:when>
        <c:otherwise>
            <div class="buttons-remove-adicionado-produto">
                <a class="btn remover-badge badge" id="button-remove-produto">
                    <img src="${pageContext.request.contextPath}/imgs/icon_remover_produto.png"
                         alt="Icone de remover produto"/>
                </a>
                <a class="btn adicionado-badge badge" id="card-button-added-produto" data-bs-toggle="modal"
                   data-bs-target="#staticBackdrop">
                    Adicionado
                </a>
            </div>

            <span class="card-quantidade-adicionado rounded-pill">${param.quantidade}</span>
        </c:otherwise>
    </c:choose>

    <span class="price-product rounded-pill">R$ ${param.preco}</span>

    <input type="hidden" id="item-card-quantidade" value="${param.quantidade}" />
    <input type="hidden" id="item-card-descricao" value="${param.descricao}" />
    <input type="hidden" id="item-card-image" value="${param.image}" />
    <input type="hidden" id="item-card-preco" value="${param.preco}" />
    <input type="hidden" id="item-card-id" value="${param.id}" />
    <input type="hidden" id="item-card-nome" value="${param.nome}" />
    <input type="hidden" id="item-card-quantidade-produto" value="${param.quantidadeProduto}" />
</div>
