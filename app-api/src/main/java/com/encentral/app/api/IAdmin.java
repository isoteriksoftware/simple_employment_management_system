package com.encentral.app.api;

import com.encentral.app.model.Admin;

import java.util.Optional;

public interface IAdmin {
    Admin addAdmin(Admin admin);

    Optional<Admin> getAdmin(String email);
}
