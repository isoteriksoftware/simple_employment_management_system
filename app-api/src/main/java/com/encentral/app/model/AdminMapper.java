package com.encentral.app.model;

import com.encentral.entities.JpaAdmin;

public class AdminMapper {
    public static JpaAdmin adminToJpaAdmin(Admin admin) {
        JpaAdmin jpaAdmin = new JpaAdmin();
        jpaAdmin.setId(admin.getId());
        jpaAdmin.setEmail(admin.getEmail());
        jpaAdmin.setPassword(admin.getPassword());
        jpaAdmin.setToken(admin.getToken());
        return jpaAdmin;
    }

    public static Admin jpaAdminToAdmin(JpaAdmin jpaAdmin) {
        Admin admin = new Admin();
        admin.setId(jpaAdmin.getId());
        admin.setPassword(jpaAdmin.getPassword());
        admin.setEmail(jpaAdmin.getEmail());
        admin.setToken(jpaAdmin.getToken());
        return admin;
    }
}
