package com.netbiis.wassabiapp_jsp.model.daos.implementations;

import com.netbiis.wassabiapp_jsp.model.daos.IProdutoDAO;
import com.netbiis.wassabiapp_jsp.model.entities.ProdutoEntity;
import com.netbiis.wassabiapp_jsp.model.entities.ProdutoHasCategoriaEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.List;

public class ProdutoDAO implements IProdutoDAO {

	private static final Log log = LogFactory.getLog(ProdutoDAO.class);

	private final EntityManager em;

	public ProdutoDAO(EntityManager em) {
		super();
		this.em = em;
	}
	
	@Override
	public List<ProdutoEntity> findAll() {
		log.debug("FindAll Produto Started");
		try {
			String queryString = "select p from ProdutoEntity p";
			TypedQuery<ProdutoEntity> queryObject = em.createQuery(queryString, ProdutoEntity.class);

			log.debug("FindAll Produto Success");
			return queryObject.getResultList();
		} catch (Exception error) {
			log.error("FindAll Produto Error: " + error.getMessage());
			throw error;
		}
	}



	@Override
	public void create(ProdutoEntity produto) {
		log.debug("Create Produto Started");
		EntityTransaction tx = em.getTransaction();

		try {
			List<ProdutoHasCategoriaEntity> phasc = (List<ProdutoHasCategoriaEntity>) produto.getProdutoHasCategoriasById();

			tx.begin();
			em.persist(produto);
			phasc.forEach(em::persist);
		} catch (Exception error) {
			tx.rollback();
			log.error("Create Produto Error: " + error.getMessage());
			throw error;
		} finally {
			tx.commit();
			log.debug("Create Produto Success");
		}
	}

	@Override
	public void update(ProdutoEntity produto) {
		log.debug("Update Produto Started");
		try {
			EntityTransaction tx = em.getTransaction();

			tx.begin();
			em.merge(produto);
			tx.commit();

			log.debug("Update Produto Success");
		} catch (Exception error) {
			log.error("Update Produto Error: " + error.getMessage());
			throw error;
		}
	}

	@Override
	public void remove(ProdutoEntity produto) {
		log.debug("Remove Produto Started");
		try {
			EntityTransaction tx = em.getTransaction();

			tx.begin();
			em.remove(produto);
			tx.commit();

			log.debug("Remove Produto Success");
		} catch (Exception error) {
			log.error("Remove Produto Error: " + error.getMessage());
			throw error;
		}
	}

}
