package com.netbiis.wassabiapp_jsp.model.daos.implementations;

import com.netbiis.wassabiapp_jsp.model.daos.IClienteDAO;
import com.netbiis.wassabiapp_jsp.model.entities.ClienteEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.ParameterExpression;
import jakarta.persistence.criteria.Root;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.List;
import java.util.Optional;

public class ClienteDAO implements IClienteDAO {
	private static final Log log = LogFactory.getLog(ClienteDAO.class);

	private final EntityManager em;

	public ClienteDAO(EntityManager em) {
		super();
		this.em = em;
	}

	@Override
	public void create(ClienteEntity data) {
		log.debug("Create Cliente Started");
		try {
			EntityTransaction tx = em.getTransaction();

			tx.begin();
			em.persist(data);
			em.detach(data);
			tx.commit();

			log.debug("Create Cliente Success");
		} catch (Exception error) {
			log.error("Create Cliente Error: " + error.getMessage());
			throw error;
		}

	}

	@Override
	public List<ClienteEntity> findAll() {
		log.debug("FindAll Cliente Started");
		try {
			String query = "select c from ClienteEntity c";
			TypedQuery<ClienteEntity> typedQuery = em.createQuery(query, ClienteEntity.class);

			log.debug("FindAll Cliente Success");
			return typedQuery.getResultList();
		} catch (Exception error) {
			log.error("FindAll Cliente Error: " + error.getMessage());
			throw error;
		}
	}

	@Override
	public void update(ClienteEntity data) {
		log.debug("Update Cliente Started");

		try {
			EntityTransaction tx = em.getTransaction();

			tx.begin();
			em.merge(data);
			tx.commit();

			log.debug("Update Cliente Success");
		} catch (Exception error) {
			log.error("Update Cliente Error: " + error.getMessage());
			throw error;
		}
	}

	@Override
	public Optional<ClienteEntity> findByCpf(String cpf) {
		log.debug("FindByCpf Cliente Started");

		try {
			CriteriaBuilder builder = em.getCriteriaBuilder();
			CriteriaQuery<ClienteEntity> criteriaQuery = builder.createQuery(ClienteEntity.class);
			Root<ClienteEntity> clienteRoot = criteriaQuery.from(ClienteEntity.class);
			ParameterExpression<String> cpfParameter = builder.parameter(String.class);
			criteriaQuery.where(builder.equal(clienteRoot.get("cpf"), cpfParameter));
			TypedQuery<ClienteEntity> typedQuery = em.createQuery(criteriaQuery);

			typedQuery.setParameter(cpfParameter, cpf);

			List<ClienteEntity> clienteEntityList = typedQuery.getResultList();

			if (clienteEntityList.isEmpty()) {
				log.debug("FindByCpf Cliente NotFound");
				return Optional.empty();
			} else {
				log.debug("FindByCpf Cliente Success");
				return Optional.of(clienteEntityList.get(0));
			}
		} catch (Exception error) {
			log.error("FindByCpf Cliente Error: " + error.getMessage());
			throw error;
		}
	}

}
