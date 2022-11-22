<%@ page import="com.netbiis.wassabiapp_jsp.core.utils.RouteUtil" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>Página de Erro 404</title>

    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/pages/error/404/font-awesome.min.css" />
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/pages/error/404/index.css" />
    <link href="${pageContext.request.contextPath}/favicon.ico" rel="icon" />

    <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
</head>

<body>

<div id="notfound">
    <div class="notfound-bg"></div>
    <div class="notfound">
        <div class="notfound-404">
            <h1>404</h1>

        </div>
        <img src="${pageContext.request.contextPath}/imgs/404.gif" class="img-thumbnail" alt="Imagem de error 404">
        <h2>Oops! Desculpe, mas a página que você
            está procurando não existe</h2>
        <div class="notfound-social">

        </div>
        <a href="${pageContext.request.contextPath}/<%=RouteUtil.HOMEVIEW%>">Back To Homepage</a>
    </div>
</div>

</body>

</html>

