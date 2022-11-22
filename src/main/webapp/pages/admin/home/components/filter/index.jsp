<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<jsp:useBean id="categorialistadmin" scope="session" type="java.util.List"/>

<div class="filter" id="filter-container">
    <div class="input-group filter-container" id="filter-options">
        <span class="input-group-text label-filter"> Filtro: </span>
        <select class="form-select select-filter" id="filter-select">
            <option value="0" selected>Selecionar</option>
            <option value="1">Nome</option>
            <option value="2">Valor</option>
            <option value="3">Categoria</option>
        </select>

        <div id="filter-input-text-container" class="input-text input-filter-flag ms-2">
            <div class="input-group h-100">
                <span class="input-group-text label-filter"> Nome: </span>
                <input id="filter-input-text" type="text" class="form-control input-filter"
                       aria-label="Text input with dropdown button">
            </div>
        </div>

        <div id="filter-input-valor-container" class="input-valor ms-2 input-filter-flag">
            <div class="input-group">
                <span class="input-group-text label-filter"> Maior que: </span>
                <input id="filter-input-higherthan" type="number" class="form-control input-filter"/>
            </div>
            <div class="input-group">
                <span class="input-group-text label-filter"> Menor que: </span>
                <input id="filter-input-lessthan" type="number" class="form-control input-filter"/>
            </div>
        </div>

        <div id="filter-input-select-container" class="input-filter-flag ms-2">
            <span class="input-group-text label-filter"> Categoria: </span>
            <select class="form-select select-filter" id="filter-input-select" required>
                <option value="-1" selected>Selecionar</option>
                <c:forEach var="categoria" items="${categorialistadmin}">
                    <option value="${categoria.getId()}">${categoria.getNome()}</option>
                </c:forEach>
            </select>
        </div>
    </div>
    <button class="btn btn-primary" id="filter-btn-adicionar" data-bs-toggle="modal"
            data-bs-target="#modal-adicionar">Adicionar
    </button>
</div>
