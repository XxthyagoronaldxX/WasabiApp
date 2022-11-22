<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.netbiis.wassabiapp_jsp.controller.events.cliente.ClienteEvent" %>
<%@ page import="com.netbiis.wassabiapp_jsp.core.utils.RouteUtil" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
            crossorigin="anonymous"></script>
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
            integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
            crossorigin="anonymous">
    </script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery.mask/1.14.16/jquery.mask.js"
            integrity="sha256-yE5LLp5HSQ/z+hJeCqkz9hdjNkk1jaiGG0tDCraumnA="
            crossorigin="anonymous">
    </script>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>

    <script src="../../../js/cartaoFormatterMask.js" type="text/javascript" defer></script>
    <script src="../../../js/cpfFormatterMask.js" type="text/javascript" defer></script>
    <script src="../../../js/telefoneFormatterMask.js" type="text/javascript" defer></script>
    <script src="../../../js/jquery-3.6.0.js" type="text/javascript" defer></script>
    <script src="../../../js/sweetalert2.all.js" type="text/javascript" defer></script>
    <script src="../../../js/toastAlertTopRight.js" type="text/javascript" defer></script>
    <script src="../../../js/adpterVhCss.js" type="text/javascript" defer></script>
    <script src="js/addEventRegister.js" type="text/javascript" defer></script>
    <link href="index.css" rel="stylesheet"/>
    <link href="${pageContext.request.contextPath}/favicon.ico" rel="icon" />

    <title>CadastroWassabi</title>
</head>
<body>
<div class="register-frame">
    <div id="logo_content">
        <h3 class="text-light">Wassabi</h3>
        <img src="../../../imgs/icon_sushi_login.png" alt="Icone de Login [Sushi]"/>
        <h3 class="text-light">App</h3>
    </div>

    <form id="register_form">
        <div class="form-inputs">
            <div class="form-group mt-2 input-content">
                <label for="nomeInput" class="form-label input-label">Nome:</label>
                <input type="text" class="form-control" id="nomeInput" name="nome" required/>
            </div>
            <div class="form-group mt-2 input-content">
                <label for="telefoneInput" class="form-label input-label">Telefone:</label>
                <input type="tel" class="form-control" id="telefoneInput" name="telefone" placeholder="(00) 00000-0000"
                       required/>
            </div>
            <div class="form-group mt-2 input-content">
                <label for="enderecoInput" class="form-label input-label">Endereço:</label>
                <input type="text" class="form-control" id="enderecoInput" name="endereco" required/>
            </div>
            <div class="double-input-group">
                <div class="form-group mt-2 input-content">
                    <label for="cpfInput" class="form-label input-label">CPF:</label>
                    <input type="text" class="form-control" id="cpfInput" name="cpf" placeholder="000.000.000-00"
                           required/>
                </div>
                <div class="form-group mt-2 input-content">
                    <label for="cartaoInput" class="form-label input-label">Cartão:</label>
                    <input type="text" class="form-control" id="cartaoInput" name="cartao"
                           placeholder="0000 0000 0000 0000" minlength="19"
                           required/>
                </div>
            </div>
            <div class="double-input-group">
                <div class="form-group mt-2 input-content">
                    <label for="senhaInput" class="form-label input-label">Senha:</label>
                    <input type="password" class="form-control" id="senhaInput" name="senha" minlength="8" required/>
                </div>
                <div class="form-group mt-2 input-content">
                    <label for="repetirSenhaInput" class="form-label input-label">Repetir senha:</label>
                    <input type="password" class="form-control" id="repetirSenhaInput" name="repetirSenha" minlength="8"  required/>
                </div>
            </div>
        </div>
    </form>

    <div class="buttons">
        <a class="btn fw-bolder bg-danger" type="button" href="../login/index.jsp">Cancelar</a>
        <button class="btn fw-bolder bg-danger" form="register_form" id="register_button">Cadastrar</button>
    </div>
</div>

<div class="bg-content"></div>

<input type="hidden" id="cliente_controller_url" value="${pageContext.request.contextPath}/ClienteController"/>
<input type="hidden" id="cliente_controller_event_register" value="<%=ClienteEvent.REGISTER%>">
<input type="hidden" id="redirect_page" value="${pageContext.request.contextPath}/<%=RouteUtil.LOGINVIEW%>"/>
</body>
</html>