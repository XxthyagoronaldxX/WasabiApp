<%@ page import="com.netbiis.wassabiapp_jsp.controller.events.admin.AdminEvent" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<header class="header-container">
    <div class="header-logo">
        <img src="${pageContext.request.contextPath}/imgs/icon_sushi_login.png" alt="Icone da logo"/>
        <h1>WassabiApp</h1>
    </div>

    <div id="header-buttons">
        <a class="header-button-selected button-select">Produto</a>
        <a class="button-select">Categoria</a>
        <a class="button-select">Cliente</a>
    </div>

    <div class="header-end">
        <a href="${pageContext.request.contextPath}/AdminController?event=<%=AdminEvent.LOGOUT%>">
            <img id="header-logout"
                 src="${pageContext.request.contextPath}/imgs/icon-logout.png" alt="Icone de LOG">
        </a>
    </div>

    <div class="header-bottom-border"></div>
</header>
