package com.netbiis.wassabiapp_jsp.model.daos.implementations;

import com.netbiis.wassabiapp_jsp.model.daos.IPedidoDAO;
import com.netbiis.wassabiapp_jsp.model.entities.PedidoEntity;
import com.netbiis.wassabiapp_jsp.model.entities.ProdutoEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.List;

public class PedidoDAO implements IPedidoDAO {
	private static final Log log = LogFactory.getLog(PedidoDAO.class);

	public EntityManager em;

	public PedidoDAO(EntityManager em) {
		super();
		this.em = em;
	}

	@Override
	public void create(PedidoEntity pedido) {
		log.debug("Create Pedido Started");
		EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();
			
			ProdutoEntity produto = pedido.getProdutoByProdutoId();
			produto.setQuantidade(produto.getQuantidade() - pedido.getQuantidade());

			em.merge(produto);
			em.persist(pedido);
		} catch (RuntimeException re) {
			tx.rollback();
			log.error("Create Pedido Error: " + re.getMessage());
			throw re;
		} finally {
			tx.commit();
			log.debug("Create Pedido Success");
		}
	}

	@Override
	public List<PedidoEntity> findAll() {
		log.debug("FindAll Pedido Started");
		try {
			String queryString = "select p from PedidoEntity p";
			TypedQuery<PedidoEntity> queryObject = em.createQuery(queryString, PedidoEntity.class);

			log.debug("FindAll Pedido Success");
			return queryObject.getResultList();
		} catch (Exception error) {
			log.error("FindAall Pedido Error: " + error.getMessage());
			throw error;
		}
	}

	@Override
	public List<PedidoEntity> findAllByClienteId(int clienteid) {
		log.debug("FindAllByClienteId Pedido Started");
		try {
			String queryString = "select p from PedidoEntity p where p.clienteByClienteId.id = :id";
			TypedQuery<PedidoEntity> queryObject = em.createQuery(queryString, PedidoEntity.class);
			queryObject.setParameter("id", clienteid);

			log.debug("FindAll Pedido Success");
			return queryObject.getResultList();
		} catch (Exception error) {
			log.error("FindAall Pedido Error: " + error.getMessage());
			throw error;
		}
	}
}
