package com.netbiis.wassabiapp_jsp.model.usecases.admin;

import com.netbiis.wassabiapp_jsp.model.entities.AdminEntity;

public interface ILoginAdminUsecase {
    AdminEntity execute(String username, String senha);
}
