package com.ajdeyemi.inventorie.services;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ajdeyemi.inventorie.models.Employee;
import com.ajdeyemi.inventorie.repositories.EmployeeRepository;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository empRepository;

    public Iterable<Employee> getAllEmployees() {
        return empRepository.findAll();
    }

    public Employee addEmployee(String empName, String empDesignation, boolean isAdmin, String empPhone,
            String empAddress)
            throws Exception {
        int m = (int) Math.pow(5, 4);
        int randomNumber = m + new Random().nextInt(4 * m);
        String id = "SWAYBID" + randomNumber;
        System.out.println(id);
        var employee = empRepository.findById(id);
        if (!(employee.isEmpty())) {
            throw new Exception("Error adding this employee,Let's try that again");
        } else {
            Employee employeeToSave = new Employee(id, empName, empDesignation, isAdmin,
                    empPhone, empAddress);
            empRepository.save(employeeToSave);
            return employeeToSave;
        }
    }

    public Employee updateEmployee(String id, String empName, String empDesignation, boolean isAdmin, String empPhone,
            String empAddress)
            throws Exception {
        var employee = empRepository.findById(id);
        if (!(employee.isEmpty())) {
            Employee employeeDetails = new Employee(id, empName, empDesignation, isAdmin, empPhone, empAddress);
            empRepository.save(employeeDetails);
            return employeeDetails;
        } else {
            throw new Exception("Employee not found");
        }
    }

    public void deleteEmployee(String id) throws Exception {
        var employee = empRepository.findById(id);
        if (!(employee.isEmpty())) {
            empRepository.deleteById(id);
        } else {
            throw new Exception("Employee not found");

        }

    }
}
