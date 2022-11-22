<%@ page contentType="text/html;charset=UTF-8" %>

<a role="button" class="carousel-item-button" data-bs-toggle="modal" data-bs-target="#staticBackdrop"
   id="carousel-item">
    <div class="carousel-content" data-bs-toggle="modal" data-bs-target="#staticBackdrop">
        <div class="carousel-content-start">
            <img src="${param.image}" alt="Imagem produto mais vendido!"/>
            <div class="carousel-item-info">
                <h1>${param.nome}
                </h1>
                <h3>${param.descricao}
                </h3>
            </div>
        </div>
        <h2 class="carousel-item-info-preco">R$ ${param.preco}
        </h2>
    </div>

    <input type="hidden" id="carousel-item-quantidade" value="${param.quantidade}">
    <input type="hidden" id="carousel-item-quantidade-produto" value="${param.quantidadeProduto}">
    <input type="hidden" id="carousel-item-nome" value="${param.nome}"/>
    <input type="hidden" id="carousel-item-descricao" value="${param.descricao}"/>
    <input type="hidden" id="carousel-item-image" value="${param.image}"/>
    <input type="hidden" id="carousel-item-preco" value="${param.preco}"/>
    <input type="hidden" id="carousel-item-id" value="${param.id}"/>
</a>