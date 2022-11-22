<%@ page import="com.netbiis.wassabiapp_jsp.controller.events.cliente.ClienteEvent" %>
<%@ page import="com.netbiis.wassabiapp_jsp.core.utils.RouteUtil" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<html lang="pt">
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
            crossorigin="anonymous"></script>
    <script
            src="https://code.jquery.com/jquery-1.12.4.min.js"
            integrity="sha256-ZosEbRLbNQzLpnKIkEdrPv7lOy9C27hHQ+Xp8a4MxAQ="
            crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery.mask/1.14.16/jquery.mask.js"
            integrity="sha256-yE5LLp5HSQ/z+hJeCqkz9hdjNkk1jaiGG0tDCraumnA="
            crossorigin="anonymous">
    </script>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>

    <link href="index.css" rel="stylesheet"/>
    <link href="${pageContext.request.contextPath}/favicon.ico" rel="icon" />
    <script src="../../../js/adpterVhCss.js" type="text/javascript"></script>
    <script src="../../../js/sweetalert2.all.js" type="text/javascript" defer></script>
    <script src="../../../js/toastAlertTopRight.js" type="text/javascript" defer></script>
    <script src="../../../js/cpfFormatterMask.js" type="text/javascript" defer></script>
    <script src="../../../js/jquery-3.6.0.js" type="text/javascript" defer></script>
    <script src="js/addEventLogin.js" type="text/javascript" defer></script>
    <script src="https://cdn.jsdelivr.net/npm/jquery-validation@1.19.5/dist/jquery.validate.js" defer></script>

    <title>WasabiApp</title>
</head>
<body>

<form id="login_form">
    <div id="logo_content">
        <h3 class="text-light">Wasabi</h3>
        <img src="../../../imgs/icon_sushi_login.png" alt="Icone de Login [Sushi]"/>
        <h3 class="text-light">App</h3>
    </div>

    <div class="form-group">
        <label for="cpfInput" class="form-label form-login-label">CPF:</label>
        <input type="text" class="form-control" placeholder="000.000.000-00" id="cpfInput" name="cpf"
               minlength="14" required/>
    </div>
    <div class="form-group">
        <label for="senhaInput" class="form-label form-login-label">Senha:</label>
        <input type="password" class="form-control" id="senhaInput" minlength="8" name="senha" required/>
    </div>

    <button class="btn btn-primary mt-4" id="login_button">Entrar</button>
    <a class="form-btn-cadastro"
       href="${pageContext.request.contextPath}/<%=RouteUtil.REGISTERVIEW%>">cadastrar-se</a>
</form>

<div class="bg-content"></div>

<input type="hidden" id="cliente_controller_url" value="${pageContext.request.contextPath}/ClienteController"/>
<input type="hidden" id="cliente_controller_event_login" value="<%=ClienteEvent.LOGIN%>">
<input type="hidden" id="home_redirect" value="${pageContext.request.contextPath}/<%=RouteUtil.HOMEVIEW%>"/>
</body>

</html>