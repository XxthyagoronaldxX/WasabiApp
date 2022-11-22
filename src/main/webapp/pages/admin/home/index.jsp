<%@ page import="com.netbiis.wassabiapp_jsp.controller.events.admin.AdminProdutoEvent" %>
<%@ page import="com.netbiis.wassabiapp_jsp.controller.events.admin.AdminCategoriaEvent" %>
<%@ page import="com.netbiis.wassabiapp_jsp.controller.events.admin.AdminClienteEvent" %>
<%@ page import="com.netbiis.wassabiapp_jsp.controller.events.admin.AdminEvent" %>
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
    <link href="components/header/index.css" rel="stylesheet"/>
    <link href="components/filter/index.css" rel="stylesheet"/>
    <link href="components/produtoitemlist/index.css" rel="stylesheet"/>
    <link href="components/modal/index.css" rel="stylesheet"/>
    <link href="../../../css/global.css" rel="stylesheet"/>
    <link href="components/itemproduto/index.css" rel="stylesheet" />
    <link href="components/itempedido/index.css" rel="stylesheet" />
    <link href="components/categoriaitemlist/index.css" rel="stylesheet" />
    <link href="components/clienteitemlist/index.css" rel="stylesheet" />
    <link href="components/list/index.css" rel="stylesheet" />
    <link href="${pageContext.request.contextPath}/favicon.ico" rel="icon" />
    <script src="../../../js/jquery-3.6.0.js" type="text/javascript"></script>
    <script src="../../../js/sweetalert2.all.js" type="text/javascript" defer></script>
    <script src="../../../js/toastAlertTopRight.js" type="text/javascript" defer></script>
    <script src="../../../js/adpterVhCss.js" type="text/javascript"></script>
    <script src="js/produto/refreshProdutoList.js" type="text/javascript" defer></script>
    <script src="js/produto/addEventCreateProduto.js" type="text/javascript" defer></script>
    <script src="js/produto/addEventProdutoToModal.js" type="text/javascript" defer></script>
    <script src="js/removeFormDefaultAction.js" type="text/javascript" defer></script>
    <script src="js/produto/addEventUpdateProduto.js" type="text/javascript" defer></script>
    <script src="js/produto/addEventRemoveProduto.js" type="text/javascript" defer></script>
    <script src="js/categoria/addEventCreateCategoria.js" type="text/javascript" defer></script>
    <script src="js/categoria/refreshCategoriaList.js" type="text/javascript" defer></script>
    <script src="js/categoria/addEventCategoriaToModal.js" type="text/javascript" defer></script>
    <script src="js/addEventAdicionarFilter.js" type="text/javascript" defer></script>
    <script src="js/switchButtons.js" type="text/javascript" defer></script>
    <script src="js/refreshModal.js" type="text/javascript" defer></script>
    <script src="js/categoria/addEventUpdateCategoria.js" type="text/javascript" defer></script>
    <script src="js/categoria/addEventRemoveCategoria.js" type="text/javascript" defer></script>
    <script src="js/cliente/refreshClienteList.js" type="text/javascript" defer></script>
    <script src="js/cliente/addEventShowPagamentos.js" type="text/javascript" defer></script>
    <script src="js/cliente/addEventShowProdutos.js" type="text/javascript" defer></script>
    <script src="js/produto/addEventFilterToProduto.js" type="text/javascript" defer></script>

    <title>Admin Home</title>
</head>
<body id="home-page">
<jsp:include page="components/modal/index.jsp"/>

<jsp:include page="components/header/index.jsp"/>

<main class="main-container">
    <jsp:include page="components/filter/index.jsp"/>

    <jsp:include page="components/list/index.jsp" />

    <!-- LIST URL -->
    <input type="hidden" id="list-component-url"
           value="${pageContext.request.contextPath}/pages/admin/home/components/list/index.jsp"/>

    <!-- PRODUTO EVENTS -->
    <input type="hidden" id="produto-controller-url"
           value="${pageContext.request.contextPath}/AdminProdutoController">
    <input type="hidden" id="produto-findall-event" value="<%=AdminProdutoEvent.FINDALLPRODUTO%>"/>
    <input type="hidden" id="produto-create-event" value="<%=AdminProdutoEvent.CREATEPRODUTO%>"/>
    <input type="hidden" id="produto-update-event" value="<%=AdminProdutoEvent.UPDATEPRODUTO%>"/>
    <input type="hidden" id="produto-remove-event" value="<%=AdminProdutoEvent.REMOVEPRODUTO%>"/>
    <input type="hidden" id="modal-produto-input"
           value="${pageContext.request.contextPath}/pages/admin/home/components/modal/produtoinput.jsp">
    <input type="hidden" id="list-produto-component-url"
           value="${pageContext.request.contextPath}/pages/admin/home/components/list/produtolist.jsp"/>

    <!-- CATEGORIA EVENTS -->
    <input type="hidden" id="categoria-controller-url"
           value="${pageContext.request.contextPath}/AdminCategoriaController"/>
    <input type="hidden" id="categoria-create-event" value="<%=AdminCategoriaEvent.CREATECATEGORIA%>"/>
    <input type="hidden" id="categoria-findall-event" value="<%=AdminCategoriaEvent.FINDALLCATEGORIA%>"/>
    <input type="hidden" id="categoria-remove-event" value="<%=AdminCategoriaEvent.REMOVECATEGORIA%>"/>
    <input type="hidden" id="categoria-update-event" value="<%=AdminCategoriaEvent.UPDATECATEGORIA%>"/>
    <input type="hidden" id="modal-categoria-input"
           value="${pageContext.request.contextPath}/pages/admin/home/components/modal/categoriainput.jsp">
    <input type="hidden" id="list-categoria-component-url"
           value="${pageContext.request.contextPath}/pages/admin/home/components/list/categorialist.jsp"/>

    <!-- CLIENTE EVENTS -->
    <input type="hidden" id="cliente-controller-url" value="${pageContext.request.contextPath}/AdminClienteController"/>
    <input type="hidden" id="cliente-findall-event" value="<%=AdminClienteEvent.FINDALLCLIENTEINFO%>"/>
    <input type="hidden" id="list-cliente-component-url" value="${pageContext.request.contextPath}/pages/admin/home/components/list/clientelist.jsp" />
</main>
</body>
</html>
