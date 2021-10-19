package com.encentral.app.api;

import com.encentral.app.model.Employee;

import java.util.List;
import java.util.Optional;

public interface IEmployee {
    Employee addEmployee(Employee employee);

    Optional<Employee> getEmployee(String email);

    Optional<Employee> getEmployee(int id);

    Optional<List<Employee>> getEmployees();
}
