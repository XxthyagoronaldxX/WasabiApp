<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="historic-item-produto">
    <div class="historic-list-start">
        <img src="${param.image}" alt="Imagem Produto Selecionado"/>
        <div class="historic-product-info">
            <div class="title-price-content">
                <h5>${param.nome}</h5>
                <span class="rounded-pill bg-danger">R$ ${param.preco}</span>
            </div>
            <h6>${param.descricao}</h6>
        </div>
    </div>

    <span class="historic-quantidade">Quantidade: ${param.quantidade}</span>
</div>
