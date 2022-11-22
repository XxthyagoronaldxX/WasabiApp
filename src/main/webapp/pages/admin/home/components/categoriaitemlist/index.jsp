<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<li class="item-list-categoria item-fadein" data-bs-toggle="modal"
    data-bs-target="#modal-adicionar">
    <div class="item-container-categoria">
        <img src="${param.image}" alt="Imagem do produto">
        <div class="item-info-categoria">
            <h3>Nome: ${param.nome}</h3>
            <h3>Quantidade de produtos: ${param.quantidade}</h3>
        </div>
    </div>

    <input type="hidden" id="item-list-nome" value="${param.nome}"/>
    <input type="hidden" id="item-list-image" value="${param.image}"/>
    <input type="hidden" id="item-list-id" value="${param.id}"/>
</li>