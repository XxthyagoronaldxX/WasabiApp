<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<li class="item-list-produto item-fadein" data-bs-toggle="modal"
    data-bs-target="#modal-adicionar">
    <div class="item-container-produto">
        <img src="${param.image}" alt="Imagem do produto">
        <div class="item-info-produto">
            <h3>Nome: ${param.nome}</h3>
            <h3>Descrição: ${param.descricao}</h3>
            <h3>Preço: R$ ${param.preco} Quantidade: ${param.quantidade}</h3>
            <h3>Categoria: ${param.categorianome}</h3>
        </div>
    </div>

    <input type="hidden" id="item-list-nome" value="${param.nome}"/>
    <input type="hidden" id="item-list-descricao" value="${param.descricao}"/>
    <input type="hidden" id="item-list-image" value="${param.image}"/>
    <input type="hidden" id="item-list-preco" value="${param.preco}"/>
    <input type="hidden" id="item-list-quantidade" value="${param.quantidade}"/>
    <input type="hidden" id="item-list-id" value="${param.id}"/>
    <input type="hidden" id="item-list-categoria-id" value="${param.categoriaid}"/>
    <input type="hidden" id="item-list-categoria-nome" value="${param.categorianome}"/>
</li>
