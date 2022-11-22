<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.netbiis.wassabiapp_jsp.controller.events.cliente.ClienteEvent" %>
<%@ page import="com.netbiis.wassabiapp_jsp.core.utils.RouteUtil" %>
<%@ page contentType="text/html;charset=UTF-8" %>

<nav class="navbar-expand-lg navbar-content">
    <div class="profile-content">
        <div class="navbar-icon-cliente">
            <ul class="navbar-nav">
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" role="button" id="dropdownProfile" data-bs-toggle="dropdown"
                       aria-expanded="false">
                        <img class="mx-2 icon-img"
                             src="${pageContext.request.contextPath}/imgs/icon_user_home.png" alt="UsuárioIcon">
                    </a>
                    <ul class="dropdown-menu dropdown-menu-dark" aria-labelledby="dropdownProfile">
                        <li><a class="dropdown-item"
                               href="${pageContext.request.contextPath}/SelfClienteController?event=<%=ClienteEvent.LOGOUT%>">Sair</a>
                        </li>
                        <li><a class="dropdown-item" id="header-btn-historico">Histórico</a></li>
                        <li><a class="dropdown-item"
                               href="${pageContext.request.contextPath}/<%=RouteUtil.EDITVIEW%>">Editar</a></li>
                    </ul>
                </li>
            </ul>
        </div>

        <div class="navbar-cliente-info">
            <p class="mb-0 cliente-nome-info">Nome: ${param.nome}</p>
            <p class="mb-0 cliente-endereco-info">Endereço: ${param.endereco}</p>
        </div>
    </div>
    <div class="navbar-icon-logo">
        <p class="mb-0">Wasabi</p>
        <img src="${pageContext.request.contextPath}/imgs/icon_sushi_login.png" class="icon-img" alt="WasabiIcon"/>
        <p class="mb-0">App</p>
    </div>
    <div class="navbar-item mr-2 cart-content">
        <a href="${pageContext.request.contextPath}/<%=RouteUtil.CARTVIEW%>" class="btn  position-relative">
            <img src="${pageContext.request.contextPath}/imgs/icon_carrinho_home.png" class="icon-img"
                 alt="CarrinhoIcon">
            <span class="count-cart rounded-pill bg-danger" id="cart-counter">99+</span>
        </a>
    </div>
</nav>