package com.netbiis.wassabiapp_jsp.core.getit;

import com.netbiis.wassabiapp_jsp.model.usecases.admin.ILoginAdminUsecase;
import com.netbiis.wassabiapp_jsp.model.usecases.admin.implementations.LoginAdminUsecase;
import com.netbiis.wassabiapp_jsp.model.usecases.categoria.*;
import com.netbiis.wassabiapp_jsp.model.usecases.categoria.implementations.*;
import com.netbiis.wassabiapp_jsp.model.usecases.cliente.ICreateClienteUsecase;
import com.netbiis.wassabiapp_jsp.model.usecases.cliente.IFindAllClienteUsecase;
import com.netbiis.wassabiapp_jsp.model.usecases.cliente.ILoginClienteUsecase;
import com.netbiis.wassabiapp_jsp.model.usecases.cliente.IUpdateClienteUsecase;
import com.netbiis.wassabiapp_jsp.model.usecases.cliente.implementations.CreateClienteUsecase;
import com.netbiis.wassabiapp_jsp.model.usecases.cliente.implementations.FindAllClienteUsecase;
import com.netbiis.wassabiapp_jsp.model.usecases.cliente.implementations.LoginClienteUsecase;
import com.netbiis.wassabiapp_jsp.model.usecases.cliente.implementations.UpdateClienteUsecase;
import com.netbiis.wassabiapp_jsp.model.usecases.pedido.ICreatePedidoUsecase;
import com.netbiis.wassabiapp_jsp.model.usecases.pedido.IFindAllPedidoFromClienteUsecase;
import com.netbiis.wassabiapp_jsp.model.usecases.pedido.IIndexPedidoUsecase;
import com.netbiis.wassabiapp_jsp.model.usecases.pedido.implementations.CreatePedidoUsecase;
import com.netbiis.wassabiapp_jsp.model.usecases.pedido.implementations.FindAllPedidoFromClienteUsecase;
import com.netbiis.wassabiapp_jsp.model.usecases.pedido.implementations.IndexPedidoUsecase;
import com.netbiis.wassabiapp_jsp.model.usecases.produto.ICreateProdutoUsecase;
import com.netbiis.wassabiapp_jsp.model.usecases.produto.IIndexProdutoUsecase;
import com.netbiis.wassabiapp_jsp.model.usecases.produto.IRemoveProdutoUsecase;
import com.netbiis.wassabiapp_jsp.model.usecases.produto.IUpdateProdutoUsecase;
import com.netbiis.wassabiapp_jsp.model.usecases.produto.implementations.CreateProdutoUsecase;
import com.netbiis.wassabiapp_jsp.model.usecases.produto.implementations.IndexProdutoUsecase;
import com.netbiis.wassabiapp_jsp.model.usecases.produto.implementations.RemoveProdutoUsecase;
import com.netbiis.wassabiapp_jsp.model.usecases.produto.implementations.UpdateProdutoUsecase;

public class UsecasesGetIt extends DaoGetIt {
    protected static final ILoginClienteUsecase loginClienteUsecase = new LoginClienteUsecase(clienteDAO);

    protected static final ICreateClienteUsecase createClienteUsecase = new CreateClienteUsecase(clienteDAO);

    protected static final IFindAllClienteUsecase findAllClienteUsecase = new FindAllClienteUsecase(clienteDAO);

    protected static final IFindAllCategoriaUsecase indexCategoriaUsecase = new FindAllCategoriaUsecase(categoriaDAO);

    protected static final ICreateCategoriaUsecase createCategoriaUsecase = new CreateCategoriaUsecase(categoriaDAO);

    protected static final IUpdateCategoriaUsecase updateCategoriaUsecase = new UpdateCategoriaUsecase(categoriaDAO);

    protected static final IRemoveCategoriaUsecase removeCategoriaUsecase = new RemoveCategoriaUsecase(categoriaDAO);

    protected static final IInitCategoriaUsecase initCategoriaUsecase = new InitCategoriaUsecase(categoriaDAO);

    protected static final IIndexProdutoUsecase indexProdutoUsecase = new IndexProdutoUsecase(produtoDAO);

    protected static final ICreateProdutoUsecase createProdutoUsecase = new CreateProdutoUsecase(produtoDAO);

    protected static final IUpdateProdutoUsecase updateProdutoUsecase = new UpdateProdutoUsecase(produtoDAO);

    protected static final IRemoveProdutoUsecase removeProdutoUsecase = new RemoveProdutoUsecase(produtoDAO);

    protected static final IUpdateClienteUsecase updateClienteUsecase = new UpdateClienteUsecase(clienteDAO);

    protected static final ICreatePedidoUsecase createPedidoUsecase = new CreatePedidoUsecase(pedidoDAO);

    protected static final IIndexPedidoUsecase indexPedidoUsecase = new IndexPedidoUsecase(pedidoDAO);

    protected static final IFindAllPedidoFromClienteUsecase findAllPedidoFromClienteUsecase = new FindAllPedidoFromClienteUsecase(pedidoDAO);

    protected static final ILoginAdminUsecase loginAdminUsecase = new LoginAdminUsecase(adminDAO);
}
