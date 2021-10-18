package com.encentral.app.impl;

import com.encentral.app.api.IAdmin;
import com.encentral.app.model.Admin;
import com.encentral.app.model.AdminMapper;
import com.encentral.entities.JpaAdmin;
import com.google.inject.Inject;
import play.db.jpa.JPAApi;

import java.util.Optional;

public class AdminImpl implements IAdmin {
    private final JPAApi jpaApi;

    @Inject
    public AdminImpl(JPAApi jpaApi) {
        this.jpaApi = jpaApi;
    }

    @Override
    public Admin addAdmin(Admin admin) {
        JpaAdmin jpaAdmin = AdminMapper.adminToJpaAdmin(admin);
        jpaApi.em().persist(jpaAdmin);

        return AdminMapper.jpaAdminToAdmin(jpaAdmin);
    }

    @Override
    public Optional<Admin> getAdmin(String email) {
        JpaAdmin jpaAdmin = jpaApi.withTransaction(em ->
                em.createQuery("Select a From JpaAdmin a where a.email=" + email, JpaAdmin.class).getSingleResult());

        return Optional.ofNullable(jpaAdmin).map(AdminMapper::jpaAdminToAdmin);
    }
}
