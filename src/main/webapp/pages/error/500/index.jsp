<%@ page import="com.netbiis.wassabiapp_jsp.core.utils.RouteUtil" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
  String message = (String) request.getAttribute("javax.servlet.error.message");

  System.out.println(message);
%>

<!DOCTYPE html>
<html lang="pt-br">
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1">

  <title>Página de Erro 500</title>

  <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/pages/error/500/font-awesome.min.css" />
  <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/pages/error/500/index.css" />
  <link href="${pageContext.request.contextPath}/favicon.ico" rel="icon" />

  <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
  <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
</head>

<body>

<div id="notfound">
  <div class="notfound-bg"></div>
  <div class="notfound">
    <div class="notfound-404">
      <h1>500</h1>

    </div>
    <img src="${pageContext.request.contextPath}/imgs/500.gif" class="img-thumbnail" alt="Imagem de error 500">
    <h2>Oops! Desculpe, serviço indisponível.</h2>
    <div class="notfound-social">

    </div>
    <a href="${pageContext.request.contextPath}/<%=RouteUtil.HOMEVIEW%>">Back To Homepage</a>
  </div>
</div>

</body>

</html>

