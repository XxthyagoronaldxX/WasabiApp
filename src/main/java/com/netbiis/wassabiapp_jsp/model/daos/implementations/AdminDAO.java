package com.netbiis.wassabiapp_jsp.model.daos.implementations;

import com.netbiis.wassabiapp_jsp.model.daos.IAdminDAO;
import com.netbiis.wassabiapp_jsp.model.entities.AdminEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.ParameterExpression;
import jakarta.persistence.criteria.Root;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.List;
import java.util.Optional;

public class AdminDAO implements IAdminDAO {
    private static final Log log = LogFactory.getLog(AdminDAO.class);
    private final EntityManager entityManager;

    public AdminDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public Optional<AdminEntity> findByUsername(String username) {
        log.debug("FindByUsername Admin Started");

        try {
            CriteriaBuilder builder = entityManager.getCriteriaBuilder();
            CriteriaQuery<AdminEntity> criteriaQuery = builder.createQuery(AdminEntity.class);
            Root<AdminEntity> root = criteriaQuery.from(AdminEntity.class);
            ParameterExpression<String> usernameParameter = builder.parameter(String.class);
            criteriaQuery.where(builder.equal(root.get("username"), usernameParameter));
            TypedQuery<AdminEntity> typedQuery = entityManager.createQuery(criteriaQuery);

            typedQuery.setParameter(usernameParameter, username);

            List<AdminEntity> adminEntityList = typedQuery.getResultList();

            if (adminEntityList.isEmpty()) {
                log.debug("FindByUsername Admin NotFound");
                return Optional.empty();
            } else {
                log.debug("FindByUsername Admin Success");
                return Optional.of(adminEntityList.get(0));
            }
        } catch (Exception error) {
            log.error("FindByUsername Admin Error: " + error.getMessage());
            throw error;
        }
    }
}
