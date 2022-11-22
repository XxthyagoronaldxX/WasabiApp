package com.netbiis.wassabiapp_jsp.model.usecases.admin.implementations;

import com.netbiis.wassabiapp_jsp.model.daos.IAdminDAO;
import com.netbiis.wassabiapp_jsp.model.entities.AdminEntity;
import com.netbiis.wassabiapp_jsp.model.usecases.admin.ILoginAdminUsecase;

import java.util.Optional;

public class LoginAdminUsecase implements ILoginAdminUsecase {
    private final IAdminDAO adminDAO;

    public LoginAdminUsecase(IAdminDAO adminDAO) {
        this.adminDAO = adminDAO;
    }

    @Override
    public AdminEntity execute(String username, String senha) throws IllegalArgumentException {
        Optional<AdminEntity> adminEntityOptional = adminDAO.findByUsername(username);

        if (!adminEntityOptional.isPresent()) {
            throw new IllegalArgumentException("USERNAME: Username não foi encontrado!");
        } else {
            AdminEntity adminEntity = adminEntityOptional.get();

            if (adminEntity.getSenha().equals(senha)) {
                return adminEntity;
            } else {
                throw new IllegalArgumentException("SENHA: Senha incorreta!");
            }
        }
    }
}
