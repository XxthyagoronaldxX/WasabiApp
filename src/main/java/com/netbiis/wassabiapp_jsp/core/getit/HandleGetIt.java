package com.netbiis.wassabiapp_jsp.core.getit;

import com.netbiis.wassabiapp_jsp.controller.handles.admin.LoginAdminHandle;
import com.netbiis.wassabiapp_jsp.controller.handles.admin.LogoutAdminHandle;
import com.netbiis.wassabiapp_jsp.controller.handles.admin.categoria.CreateCategoriaHandle;
import com.netbiis.wassabiapp_jsp.controller.handles.admin.categoria.FindAllCategoriaHandle;
import com.netbiis.wassabiapp_jsp.controller.handles.admin.categoria.RemoveCategoriaHandle;
import com.netbiis.wassabiapp_jsp.controller.handles.admin.categoria.UpdateCategoriaHandle;
import com.netbiis.wassabiapp_jsp.controller.handles.admin.cliente.FindAllClienteInfoHandle;
import com.netbiis.wassabiapp_jsp.controller.handles.admin.produto.CreateProdutoHandle;
import com.netbiis.wassabiapp_jsp.controller.handles.admin.produto.FindAllProdutoHandle;
import com.netbiis.wassabiapp_jsp.controller.handles.admin.produto.RemoveProdutoHandle;
import com.netbiis.wassabiapp_jsp.controller.handles.admin.produto.UpdateProdutoHandle;
import com.netbiis.wassabiapp_jsp.controller.handles.cliente.EditClienteHandle;
import com.netbiis.wassabiapp_jsp.controller.handles.cliente.LoginClienteHandle;
import com.netbiis.wassabiapp_jsp.controller.handles.cliente.LogoutClienteHandle;
import com.netbiis.wassabiapp_jsp.controller.handles.cliente.RegisterClienteHandle;
import com.netbiis.wassabiapp_jsp.controller.handles.cliente.categoria.InitCategoriaHandle;
import com.netbiis.wassabiapp_jsp.controller.handles.cliente.pedido.*;
import com.netbiis.wassabiapp_jsp.controller.handles.cliente.produto.FilterByCategoriaProdutoHandle;
import com.netbiis.wassabiapp_jsp.controller.handles.cliente.produto.InitProdutoHandle;

public class HandleGetIt extends UsecasesGetIt {
    public static final LoginClienteHandle loginClienteHandle = new LoginClienteHandle(loginClienteUsecase);

    public static final LogoutClienteHandle logoutClienteHandle = new LogoutClienteHandle();

    public static final RegisterClienteHandle registerClienteHandle = new RegisterClienteHandle(createClienteUsecase);

    public static final EditClienteHandle editClienteHandle = new EditClienteHandle(updateClienteUsecase);

    public static final FindAllClienteInfoHandle findAllClienteInfoHandle = new FindAllClienteInfoHandle(findAllClienteUsecase, findAllPedidoFromClienteUsecase);

    public static final FilterByCategoriaProdutoHandle filterByCategoriaProdutoHandle = new FilterByCategoriaProdutoHandle();

    public static final InitProdutoHandle initProdutoHandle = new InitProdutoHandle(indexProdutoUsecase);

    public static final InitCategoriaHandle initCategoriaHandle = new InitCategoriaHandle(initCategoriaUsecase);

    public static final InitCarrinhoHandle initCarrinhoHandle = new InitCarrinhoHandle();

    public static final AddProdutoToCarrinhoHandle addProdutoToCarrinhoHandle = new AddProdutoToCarrinhoHandle();

    public static final GetSizeCarrinhoHandle getSizeCarrinhoHandle = new GetSizeCarrinhoHandle();

    public static final IncrementProdutoHandle incrementProdutoHandle = new IncrementProdutoHandle();

    public static final DecrementProdutoHandle decrementProdutoHandle = new DecrementProdutoHandle();

    public static final FinalizarPedidoHandle finalizarPedidoHandle = new FinalizarPedidoHandle(createPedidoUsecase);

    public static final RemoveProdutoFromCarrinhoHandle removeProdutoFromCarrinhoHandle = new RemoveProdutoFromCarrinhoHandle();

    public static final CancelarPedidoHandle cancelarPedidoHandle = new CancelarPedidoHandle();

    public static final FindAllPedidoFromClienteHandle findAllPedidoFromClienteHandle = new FindAllPedidoFromClienteHandle(findAllPedidoFromClienteUsecase);

    public static final FindAllPedidoHandle findAllPedidoHandle = new FindAllPedidoHandle(indexPedidoUsecase);

    public static final LoginAdminHandle loginAdminHandle = new LoginAdminHandle(loginAdminUsecase);

    public static final LogoutAdminHandle logoutAdminHandle = new LogoutAdminHandle();

    public static final FindAllProdutoHandle findAllProdutoHandle = new FindAllProdutoHandle(indexProdutoUsecase);

    public static final FindAllCategoriaHandle findAllCategoriaHandle = new FindAllCategoriaHandle(indexCategoriaUsecase);

    public static final CreateProdutoHandle createProdutoHandle = new CreateProdutoHandle(createProdutoUsecase);

    public static final UpdateProdutoHandle updateProdutoHandle = new UpdateProdutoHandle(updateProdutoUsecase);

    public static final RemoveProdutoHandle removeProdutoHandle = new RemoveProdutoHandle(removeProdutoUsecase);

    public static final CreateCategoriaHandle createCategoriaHandle = new CreateCategoriaHandle(createCategoriaUsecase);

    public static final RemoveCategoriaHandle removeCategoriaHandle = new RemoveCategoriaHandle(removeCategoriaUsecase);

    public static final UpdateCategoriaHandle updateCategoriaHandle = new UpdateCategoriaHandle(updateCategoriaUsecase);

    public static void init() {
        entityManager.clear();
    }
}
