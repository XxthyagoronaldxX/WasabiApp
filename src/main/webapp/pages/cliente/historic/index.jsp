<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.netbiis.wassabiapp_jsp.core.utils.RouteUtil" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<jsp:useBean id="historicolist" scope="session" type="java.util.List"/>

<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
            crossorigin="anonymous"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>

    <link href="index.css" rel="stylesheet"/>
    <link href="../../../css/global.css" rel="stylesheet"/>
    <link href="components/itempedido/index.css" rel="stylesheet">
    <link href="components/itemproduto/index.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/favicon.ico" rel="icon" />
    <script src="js/addEventShowProdutos.js" rel="stylesheet" defer></script>

    <title>Historico de compras</title>
</head>
<body>
<div id="historic-frame">
    <header>
        <h3 class="text-light">
            Wassabi<img src="../../../imgs/icon_sushi_login.png" alt="Icone de Login [Sushi]"/>App
        </h3>
        <a id="historic-button-leave"
           href="${pageContext.request.contextPath}/<%=RouteUtil.HOMEVIEW%>"
        ><img src="${pageContext.request.contextPath}/imgs/icon-voltar.png" alt="Icone de voltar"></a>
    </header>

    <div id="historic-pedidos-feitos">

        <c:forEach var="historico" items="${historicolist}">
            <a class="item-pedido" data-bs-toggle="collapse" role="button" aria-expanded="false"
               aria-controls="item-produtos-collapse">
                <jsp:include page="components/itempedido/index.jsp">
                    <jsp:param name="total" value="${historico.getTotal()}"/>
                    <jsp:param name="data" value="${historico.getDateFormatted()}"/>
                    <jsp:param name="nome" value="${historico.getProdutos()}"/>
                </jsp:include>

                <div class="collapse" id="item-produtos-collapse">
                    <c:forEach var="produto" items="${historico.getProdutos()}">
                        <jsp:include page="components/itemproduto/index.jsp">
                            <jsp:param name="nome" value="${produto.getNome()}"/>
                            <jsp:param name="image" value="${produto.getImage()}"/>
                            <jsp:param name="preco" value="${produto.getPreco()}"/>
                            <jsp:param name="descricao" value="${produto.getDescricao()}"/>
                            <jsp:param name="quantidade" value="${produto.getQuantidadeSelected()}"/>
                        </jsp:include>
                    </c:forEach>
                </div>
            </a>
        </c:forEach>

    </div>
</div>

<div class="bg-content"></div>

</body>
</html>
