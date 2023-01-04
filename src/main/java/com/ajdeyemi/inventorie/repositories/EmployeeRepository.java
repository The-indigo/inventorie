package com.ajdeyemi.inventorie.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ajdeyemi.inventorie.models.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, String> {
    public Employee findByEmpName(String name);
}
