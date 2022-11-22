<%@ page import="com.netbiis.wassabiapp_jsp.controller.events.admin.AdminEvent" %>
<%@ page import="com.netbiis.wassabiapp_jsp.core.utils.RouteUtil" %>
<%@ page contentType="text/html;charset=UTF-8" %>

<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
            crossorigin="anonymous"></script>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>

    <link href="index.css" rel="stylesheet"/>
    <link href="../../../css/global.css" rel="stylesheet"/>
    <link href="${pageContext.request.contextPath}/favicon.ico" rel="icon" />
    <script src="js/addEventLogin.js" rel="stylesheet" defer></script>
    <script src="../../../js/jquery-3.6.0.js" type="text/javascript"></script>
    <script src="../../../js/sweetalert2.all.js" type="text/javascript" defer></script>
    <script src="../../../js/toastAlertTopRight.js" type="text/javascript" defer></script>
    <script src="../../../js/adpterVhCss.js" type="text/javascript"></script>

    <title>Admin Login</title>
</head>
<body>
<div id="admin-login">
    <div id="login-container">
        <h1> Login Admin </h1>

        <form id="login-form" method="post" >
            <div class="input-container">
                <label for="username-label" class="form-label">Username</label>
                <input type="text" class="form-control" id="username-label" placeholder="Ex: Thyago Ronald" required>
            </div>
            <div class="input-container">
                <label for="senha-label" class="form-label">Senha</label>
                <input type="password" class="form-control" id="senha-label" minlength="8" placeholder="" required>
            </div>
        </form>

        <button class="btn btn-primary" id="login-btn" form="login-form">Login</button>
    </div>

    <input type="hidden" id="admin-home-redirect" value="${pageContext.request.contextPath}/<%=RouteUtil.ADMINHOMEVIEW%>"/>
    <input type="hidden" id="admin-event-login" value="<%=AdminEvent.LOGIN%>" />
    <input type="hidden" id="admin-controller-url" value="${pageContext.request.contextPath}/AdminController"/>
</div>
</body>
</html>
