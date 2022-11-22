<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.netbiis.wassabiapp_jsp.core.utils.RouteUtil" %>
<%@ page import="com.netbiis.wassabiapp_jsp.controller.events.cliente.ClientePedidoEvent" %>
<%@ page contentType="text/html;charset=UTF-8" %>

<jsp:useBean id="cliente" scope="session" class="com.netbiis.wassabiapp_jsp.model.entities.ClienteEntity"/>
<jsp:useBean id="pedidolist" scope="session" type="java.util.List"/>
<c:set var="size" value="${pedidolist.size()}"/>

<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
            crossorigin="anonymous"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>

    <link href="components/cartitem/index.css" rel="stylesheet">
    <link href="index.css" rel="stylesheet">
    <link href="../../../css/global.css" rel="stylesheet">
    <link href="components/modal/index.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/favicon.ico" rel="icon" />
    <script src="../../../js/adpterVhCss.js" type="text/javascript"></script>
    <script src="../../../js/sweetalert2.all.js" type="text/javascript" defer></script>
    <script src="../../../js/toastAlertTopRight.js" type="text/javascript" defer></script>
    <script src="js/addEventIncDecToModal.js" type="text/javascript" defer></script>
    <script src="js/addEventRemoveToModal.js" type="text/javascript" defer></script>
    <script src="js/addEventIsFreteCheckBox.js" type="text/javascript" defer></script>
    <script src="js/refreshInfoPagamento.js" type="text/javascript" defer></script>
    <script src="js/addEventCancelarPedido.js" type="text/javascript" defer></script>
    <script src="js/addEventFinalizarPedido.js" type="text/javascript" defer></script>
    <script src="js/renderFrameToNoProdutosSelected.js" type="text/javascript" defer></script>
    <script src="js/addEventProdutoToModal.js" type="text/javascript" defer></script>
    <script src="js/refreshProdutosSelectedList.js" type="text/javascript" defer></script>

    <title>Finalizar compra</title>
</head>
<body>
<div class="cart-frame">
    <jsp:include page="components/modal/index.jsp"/>

    <a id="cart-button-leave"
       href="${pageContext.request.contextPath}/<%=RouteUtil.HOMEVIEW%>"
    ><img src="${pageContext.request.contextPath}/imgs/icon-voltar.png" alt="Icone de voltar"></a>

    <a id="logo_content">
        <h3 class="text-light">Wassabi</h3>
        <img src="../../../imgs/icon_sushi_login.png" alt="Icone de Login [Sushi]"/>
        <h3 class="text-light">App</h3>
    </a>

    <div id="cart-produtos-selected" class="list-group-flush">
        <jsp:include page="components/cartlist/index.jsp"/>
    </div>


    <div class="pedido-content card">
        <div class="info-pedido">
            <div class="info-pedido-start">
                <span class="info-nome">Cliente: <%=cliente.getNome()%></span>
                <c:if test="${size > 0}">
                    <div id="cart-info-frete">
                        <input class="form-check-input" type="checkbox" id="cart-check-frete"/>
                        <label class="form-check-label" for="cart-check-frete">Receber no endereço:</label>
                    </div>
                </c:if>
                <span class="info-endereco">Endereço: <%=cliente.getEndereco()%></span>
                <span class="info-cartao">Cartão: <%=cliente.getCartao()%></span>
            </div>

            <div class="info-pedido-divider"></div>

            <div class="info-pedido-end">
                <div class="conta-content">
                    <div class="conta-item">
                        <a>Produtos:</a>
                        <a id="cart-produtos-total">$ 0.00</a>
                    </div>
                    <div class="conta-item">
                        <a>Frete:</a>
                        <a id="cart-frete">R$ 0.00</a>
                    </div>
                    <div class="conta-item">
                        <a>Total:</a>
                        <a id="cart-total">R$ 0.00</a>
                    </div>
                </div>
                <c:if test="${size > 0}">
                    <div class="buttons">
                        <a class="btn" id="cart-btn-cancelar-pedido"> Cancelar </a>
                        <a class="btn btn-danger" id="cart-btn-finalizar-pedido"> Finalizar </a>
                    </div>
                </c:if>
            </div>
        </div>
    </div>
</div>

<div class="bg-content"></div>

<input type="hidden" id="cart-frete-value" value="0">
<input type="hidden" id="cart-pedido-url" value="${pageContext.request.contextPath}/ClientePedidoController">
<input type="hidden" id="cart-list-component-url"
       value="${pageContext.request.contextPath}/pages/cliente/cart/components/cartlist/index.jsp"/>
<input type="hidden" id="cart-pedido-event-inc" value="<%=ClientePedidoEvent.INCREMENTPRODUTO%>">
<input type="hidden" id="cart-pedido-event-dec" value="<%=ClientePedidoEvent.DECREMENTPRODUTO%>">
<input type="hidden" id="cart-pedido-event-cancelar" value="<%=ClientePedidoEvent.CANCELARPEDIDO%>">
<input type="hidden" id="cart-pedido-event-finalizar" value="<%=ClientePedidoEvent.FINALIZARPEDIDO%>">
<input type="hidden" id="cart-pedido-event-remove-produto-carrinho" value="<%=ClientePedidoEvent.REMOVEPRODUTOFROMCARRINHO%>">
</body>
</html>
