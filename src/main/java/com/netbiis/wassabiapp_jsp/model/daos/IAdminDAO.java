package com.netbiis.wassabiapp_jsp.model.daos;

import com.netbiis.wassabiapp_jsp.model.entities.AdminEntity;

import java.util.Optional;

public interface IAdminDAO {
    Optional<AdminEntity> findByUsername(String username);
}
