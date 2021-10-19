package com.encentral.app.model;

import com.encentral.entities.JpaEmployee;

public class EmployeeMapper {
    public static JpaEmployee employeeToJpaEmployee(Employee employee) {
        JpaEmployee jpaEmployee = new JpaEmployee();
        jpaEmployee.setId(employee.getId());
        jpaEmployee.setPassword(employee.getPassword());
        jpaEmployee.setEmail(employee.getEmail());
        jpaEmployee.setToken(employee.getToken());
        return jpaEmployee;
    }

    public static Employee jpaEmployeeToEmployee(JpaEmployee jpaEmployee) {
        Employee employee = new Employee();
        employee.setEmail(jpaEmployee.getEmail());
        employee.setPassword(jpaEmployee.getPassword());
        employee.setId(jpaEmployee.getId());
        employee.setToken(jpaEmployee.getToken());
        return employee;
    }
}
