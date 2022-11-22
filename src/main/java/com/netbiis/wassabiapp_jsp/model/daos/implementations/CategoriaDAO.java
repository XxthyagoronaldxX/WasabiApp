package com.netbiis.wassabiapp_jsp.model.daos.implementations;

import com.netbiis.wassabiapp_jsp.model.daos.ICategoriaDAO;
import com.netbiis.wassabiapp_jsp.model.entities.CategoriaEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.List;

public class CategoriaDAO implements ICategoriaDAO {
    private static final Log log = LogFactory.getLog(CategoriaDAO.class);

    private final EntityManager em;

    public CategoriaDAO(EntityManager em) {
        this.em = em;
    }

    @Override
    public List<CategoriaEntity> findAll() {
        log.debug("FindAll Categoria Started");
        try {
            String query = "select c from CategoriaEntity c";
            TypedQuery<CategoriaEntity> typedQuery = em.createQuery(query, CategoriaEntity.class);

            log.debug("FindAll Categoria Success");
            return typedQuery.getResultList();
        } catch (Exception error) {
            log.error("FindAll Categoria Error: " + error.getMessage());
            throw error;
        }
    }

    public void create(CategoriaEntity data) {
        log.debug("Create CategoriaEntity Started");
        try {
            EntityTransaction tx = em.getTransaction();

            tx.begin();
            em.persist(data);
            tx.commit();

            log.debug("Create CategoriaEntity Success");
        } catch (Exception error) {
            log.error("Create CategoriaEntity Error: " + error.getMessage());
            throw error;
        }
    }

    public void update(CategoriaEntity data) {
        log.debug("Update CategoriaEntity Started");
        try {
            EntityTransaction tx = em.getTransaction();

            tx.begin();
            em.merge(data);
            tx.commit();

            log.debug("Update CategoriaEntity Success");
        } catch (Exception error) {
            log.error("Update CategoriaEntity Error: " + error.getMessage());
            throw error;
        }
    }

    public void delete(CategoriaEntity data) {
        log.debug("Delete CategoriaEntity Started");

        try {
            EntityTransaction tx = em.getTransaction();

            tx.begin();
            em.remove(data);
            tx.commit();

            log.debug("Delete CategoriaEntity Success");
        } catch (Exception error) {
            log.error("Delete CategoriaEntity Error: " + error.getMessage());
            throw error;
        }
    }
}

