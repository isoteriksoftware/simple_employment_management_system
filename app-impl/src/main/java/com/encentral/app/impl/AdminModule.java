package com.encentral.app.impl;

import com.encentral.app.api.IAdmin;
import com.google.inject.AbstractModule;

public class AdminModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(IAdmin.class).to(AdminImpl.class);
    }
}
