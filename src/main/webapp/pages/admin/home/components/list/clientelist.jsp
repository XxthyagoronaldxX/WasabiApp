<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<jsp:useBean id="clienteinfolist" scope="session" type="java.util.List"/>

<ul id="list-cliente">

    <c:forEach var="clienteinfo" items="${clienteinfolist}">
        <li class="item-list-cliente">
            <c:set var="cliente" value="${clienteinfo.getCliente()}"/>
            <c:set var="pagamentoslist" value="${clienteinfo.getHistorico()}"/>
            <c:set var="pagamentoslistsize" value="${pagamentoslist.size()}"/>


            <jsp:include page="../clienteitemlist/index.jsp">
                <jsp:param name="nome" value="${cliente.getNome()}"/>
                <jsp:param name="cpf" value="${cliente.getCpf()}"/>
                <jsp:param name="telefone" value="${cliente.getTelefone()}"/>
                <jsp:param name="endereco" value="${cliente.getEndereco()}"/>
                <jsp:param name="quantidadePagamentos" value="${clienteinfo.totalOfOrders()}"/>
                <jsp:param name="totalGasto" value="${clienteinfo.totalOfMoneySpended()}"/>
            </jsp:include>

            <c:if test="${pagamentoslistsize > 0}">
                <div class="collapse" id="item-pagamentos-collapse">
                    <c:forEach var="historico" items="${pagamentoslist}">
                        <a class="item-pedido" data-bs-toggle="collapse" role="button" aria-expanded="false"
                           aria-controls="item-produtos-collapse">
                            <jsp:include page="../itempedido/index.jsp">
                                <jsp:param name="total" value="${historico.getTotal()}"/>
                                <jsp:param name="data" value="${historico.getDate().toString()}"/>
                                <jsp:param name="nome" value="${historico.getProdutos()}"/>
                            </jsp:include>

                            <div class="collapse" id="item-produtos-collapse">
                                <c:forEach var="produto" items="${historico.getProdutos()}">
                                    <jsp:include page="../itemproduto/index.jsp">
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
            </c:if>

            <c:choose>
                <c:when test="${pagamentoslistsize > 0}">
                    <div class="item-did-pagamentos"></div>
                </c:when>
                <c:otherwise>
                    <div class="item-no-pagamentos"></div>
                </c:otherwise>
            </c:choose>
        </li>
    </c:forEach>


</ul>
