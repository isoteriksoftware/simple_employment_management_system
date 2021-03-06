package com.encentral.scaffold.binder;

import com.encentral.app.api.IAdmin;
import com.encentral.app.model.Admin;
import play.db.jpa.JPAApi;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class AppStart {
    @Inject
    public AppStart(JPAApi api, IAdmin iAdmin) {
        api.withTransaction(() -> {
            // Create a default admin if it doesn't exist yet
            if (iAdmin.getAdmin("admin@encentral.com").isPresent())
                return;

            Admin admin =  new Admin();
            admin.setEmail("admin@encentral.com");
            admin.setPassword("admin");
            iAdmin.addAdmin(admin);
        });
    }
}

