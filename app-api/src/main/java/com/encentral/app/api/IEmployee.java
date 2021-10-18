package com.encentral.app.api;

import com.encentral.app.model.Employee;

import java.util.Optional;

public interface IEmployee {
    Employee addEmployee(Employee employee);

    Optional<Employee> getEmployee(String email);
}
