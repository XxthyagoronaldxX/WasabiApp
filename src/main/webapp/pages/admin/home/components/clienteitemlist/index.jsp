<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="item-container-cliente item-fadein" data-bs-toggle="collapse" aria-expanded="false"
     aria-controls="item-pagamentos-collapse">
    <div class="item-info-cliente">
        <h3>Nome: ${param.nome}<br/> Cpf: ${param.cpf}</h3>
        <h3>Telefone: ${param.telefone}<br/>Endereço: ${param.endereco}</h3>
        <h3> Pagamentos: ${param.quantidadePagamentos}<br/>  Total: ${param.totalGasto}</h3>
    </div>
</div>

<input type="hidden" id="item-list-id" value="${param.id}"/>