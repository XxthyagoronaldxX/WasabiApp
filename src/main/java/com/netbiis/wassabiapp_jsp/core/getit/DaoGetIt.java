package com.netbiis.wassabiapp_jsp.core.getit;

import com.netbiis.wassabiapp_jsp.model.daos.*;
import com.netbiis.wassabiapp_jsp.model.daos.implementations.*;
import com.netbiis.wassabiapp_jsp.model.helper.EntityManagerHelper;
import jakarta.persistence.EntityManager;

public class DaoGetIt {
    protected static final EntityManager entityManager = EntityManagerHelper.getEntityManager();

    protected static final IClienteDAO clienteDAO = new ClienteDAO(entityManager);

    protected static final IAdminDAO adminDAO = new AdminDAO(entityManager);

    protected static final IPedidoDAO pedidoDAO = new PedidoDAO(entityManager);

    protected static final IProdutoDAO produtoDAO = new ProdutoDAO(entityManager);

    protected static final ICategoriaDAO categoriaDAO = new CategoriaDAO(entityManager);
}
