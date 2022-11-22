<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.netbiis.wassabiapp_jsp.controller.events.cliente.ClienteProdutoEvent" %>
<%@ page import="com.netbiis.wassabiapp_jsp.controller.events.cliente.ClientePedidoEvent" %>
<%@ page import="com.netbiis.wassabiapp_jsp.core.utils.RouteUtil" %>
<%@ page contentType="text/html;charset=UTF-8" %>

<jsp:useBean id="cliente" scope="session" class="com.netbiis.wassabiapp_jsp.model.entities.ClienteEntity"/>
<jsp:useBean id="categorialist" scope="session" type="java.util.List"/>
<jsp:useBean id="produtolistfiltered" scope="session" type="java.util.List"/>

<html>
<head lang="pt">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
            crossorigin="anonymous"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>

    <link href="components/header/index.css" rel="stylesheet">
    <link href="components/card/index.css" rel="stylesheet">
    <link href="components/carouselview/index.css" rel="stylesheet">
    <link href="components/carouselitem/index.css" rel="stylesheet">
    <link href="components/categoryitem/index.css" rel="stylesheet">
    <link href="components/modal/index.css" rel="stylesheet">
    <link href="components/productlist/index.css" rel="stylesheet">
    <link href="components/pagination/index.css" rel="stylesheet">
    <link href="index.css" rel="stylesheet">
    <link href="../../../css/global.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/favicon.ico" rel="icon" />
    <script src="../../../js/adpterVhCss.js" type="text/javascript"></script>
    <script src="../../../js/sweetalert2.all.js" type="text/javascript" defer></script>
    <script src="../../../js/toastAlertTopRight.js" type="text/javascript" defer></script>
    <script src="js/addEventProdutoInfoToModel.js" type="text/javascript" defer></script>
    <script src="js/addEventIncDecQuantidadeProduto.js" type="text/javascript" defer></script>
    <script src="js/addEventAddProdutoToCart.js" type="text/javascript" defer></script>
    <script src="js/refreshCountCarrinho.js" type="text/javascript" defer></script>
    <script src="js/addEventFilterProdutoByCategoria.js" type="text/javascript" defer></script>
    <script src="js/addPaginationToProdutos.js" type="text/javascript" defer></script>
    <script src="js/refreshProductList.js" type="text/javascript" defer></script>
    <script src="js/addEventRemoveProdutoFromCart.js" type="text/javascript" defer></script>
    <script src="js/addEventRechargeHistorico.js" type="text/javascript" defer></script>
    <script src="js/refreshCarouselView.js" type="text/javascript" defer></script>

    <title>WasabiApp</title>
</head>
<body>

<jsp:include page="components/header/index.jsp">
    <jsp:param name="nome" value="<%= cliente.getNome() %>"/>
    <jsp:param name="endereco" value="<%= cliente.getEndereco() %>"/>
</jsp:include>

<div class="home-content">
    <div class="products-content">
        <jsp:include page="components/modal/index.jsp"/>

        <div class="products-bestsellers-title">
            <h1 class="fw-bold">Best<img id="best-seller-img"
                                         src="https://img.icons8.com/flat-round/96/uefa-euro-trophy.png"
                                         alt="Icone de produtos mais vendidos">Sellers</h1>
        </div>

        <class id="carousel-view">
            <jsp:include page="components/carouselview/index.jsp"/>
        </class>

        <div class="divider"></div>

        <div class="categoria-content">
            <jsp:include page="components/categoryitem/index.jsp">
                <jsp:param name="nome" value="Todos"/>
                <jsp:param name="image" value="https://img.icons8.com/ios/48/infinity.png"/>
                <jsp:param name="id" value="-1"/>
            </jsp:include>

            <c:forEach var="categoria" items="${categorialist}">
                <jsp:include page="components/categoryitem/index.jsp">
                    <jsp:param name="nome" value="${categoria.getNome()}"/>
                    <jsp:param name="image" value="${categoria.getImage()}"/>
                    <jsp:param name="id" value="${categoria.getId()}"/>
                </jsp:include>
            </c:forEach>
        </div>

        <div class="divider"></div>

        <div id="product-list">
            <c:forEach var="produto" items="${produtolistfiltered}">
                <jsp:include page="components/card/index.jsp">
                    <jsp:param name="nome" value="${produto.getNome()}"/>
                    <jsp:param name="descricao" value="${produto.getDescricao()}"/>
                    <jsp:param name="image" value="${produto.getImage()}"/>
                    <jsp:param name="preco" value="${produto.getPreco()}"/>
                    <jsp:param name="id" value="${produto.getId()}"/>
                    <jsp:param name="quantidadeProduto" value="${produto.getQuantidade()}"/>
                    <jsp:param name="quantidade" value="${produto.getQuantidadeSelected()}"/>
                    <jsp:param name="selected" value="${produto.isSelected()}"/>
                </jsp:include>
            </c:forEach>
        </div>

        <jsp:include page="components/pagination/index.jsp"/>

    </div>
</div>

<input type="hidden" id="pedido-url" value="${pageContext.request.contextPath}/ClientePedidoController">
<input type="hidden" id="produto-url" value="${pageContext.request.contextPath}/ClienteProdutoController"/>

<input type="hidden" id="historic-redirect-url" value="${pageContext.request.contextPath}/<%=RouteUtil.HISTORICVIEW%>">

<input type="hidden" id="produto-categoria-atual" value="-1"/>
<input type="hidden" id="pedido-event-getallpedido" value="<%=ClientePedidoEvent.FINDALLPEDIDO%>">
<input type="hidden" id="pedido-event-getsizecarrinho" value="<%=ClientePedidoEvent.GETSIZECARRINHO%>">
<input type="hidden" id="pedido-event-addprodutotocarrinho" value="<%=ClientePedidoEvent.ADDPRODUTOTOCARRINHO%>">
<input type="hidden" id="pedido-event-removeprodutofromcarrinho" value="<%=ClientePedidoEvent.REMOVEPRODUTOFROMCARRINHO%>">
<input type="hidden" id="produto-event-filterbycategoria" value="<%=ClienteProdutoEvent.FILTERBYCATEGORIA%>">
<input type="hidden" id="produto-carousel-view-url" value="./components/carouselview/index.jsp"/>
<input type="hidden" id="produto-pagination-url" value="./components/pagination/index.jsp">

</body>
</html>