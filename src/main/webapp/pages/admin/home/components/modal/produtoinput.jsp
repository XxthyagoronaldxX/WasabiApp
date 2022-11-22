<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<jsp:useBean id="categorialistadmin" scope="session" type="java.util.List"/>

<div class="input-content">
    <label for="input-produto-nome">Nome:</label>
    <input type="text" class="form-control" id="input-produto-nome" required/>
</div>
<div class="input-content">
    <label for="input-produto-descricao">Descrição:</label>
    <input type="text" class="form-control" id="input-produto-descricao" required/>
</div>
<div class="input-content">
    <label for="input-produto-preco">Preço:</label>
    <input type="number" class="form-control" id="input-produto-preco" required/>
</div>
<div class="input-content">
    <label for="input-produto-quantidade">Quantidade:</label>
    <input type="number" class="form-control" id="input-produto-quantidade" required/>
</div>
<div class="input-content">
    <label for="input-produto-image">Imagem (URL):</label>
    <input type="text" class="form-control" id="input-produto-image" required/>
</div>
<div class="input-content">
    <label for="select-produto-categoria">Categoria:</label>
    <select class="form-select select-filter" id="select-produto-categoria" required>
        <option value="-1" selected>Selecionar</option>
        <c:forEach var="categoria" items="${categorialistadmin}">
            <option value="${categoria.getId()}">${categoria.getNome()}</option>
        </c:forEach>
    </select>
</div>
