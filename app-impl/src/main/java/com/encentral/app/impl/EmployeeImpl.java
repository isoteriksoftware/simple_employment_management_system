package com.encentral.app.impl;

import com.encentral.app.api.IEmployee;
import com.encentral.app.model.Employee;
import com.encentral.app.model.EmployeeMapper;
import com.encentral.entities.JpaEmployee;
import com.google.inject.Inject;
import play.db.jpa.JPAApi;

import java.util.Optional;

public class EmployeeImpl implements IEmployee {
    private final JPAApi jpaApi;

    @Inject
    public EmployeeImpl(JPAApi jpaApi) {
        this.jpaApi = jpaApi;
    }

    @Override
    public Employee addEmployee(Employee employee) {
        JpaEmployee jpaEmployee = EmployeeMapper.employeeToJpaEmployee(employee);
        jpaApi.em().persist(jpaEmployee);

        return EmployeeMapper.jpaEmployeeToEmployee(jpaEmployee);
    }

    @Override
    public Optional<Employee> getEmployee(String email) {
        JpaEmployee jpaEmployee = jpaApi.withTransaction(em ->
                em.createQuery("Select e From JpaEmployee e where email=" + email, JpaEmployee.class).getSingleResult());

        return Optional.ofNullable(jpaEmployee).map(EmployeeMapper::jpaEmployeeToEmployee);
    }
}