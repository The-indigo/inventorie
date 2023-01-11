package com.ajdeyemi.inventorie.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ajdeyemi.inventorie.models.AuthenticationRequest;
import com.ajdeyemi.inventorie.models.AuthenticationResponse;
import com.ajdeyemi.inventorie.models.Employee;
import com.ajdeyemi.inventorie.services.EmployeeService;

@RestController()
public class EmployeeController {

    @Autowired
    private EmployeeService empService;

    @GetMapping("/employee/get")
    public Iterable<Employee> getAllEmployees() {
        return empService.getAllEmployees();
    }

    @PostMapping("/addemployee")
    public Employee addEmployee(@RequestBody Employee employee) throws Exception {
        return empService.addEmployee(employee.getEmpName(), employee.getEmpDesignation(),
                employee.getEmpPhone(), employee.getEmpAddress(), employee.getPassword());
    }

    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponse> authenticate(@RequestBody AuthenticationRequest request)
            throws Exception {
        return ResponseEntity.ok(empService.authenticate(request));
    }

    @PostMapping("/employee/{id}/update")
    public Employee updatEmployee(@PathVariable("id") String id, @RequestBody Employee employee) throws Exception {
        if (employee.getRole().equals("Admin")) {
            return empService.updateEmployee(id, employee.getEmpName(), employee.getEmpDesignation(),
                    employee.getEmpPhone(), employee.getEmpAddress());
        } else {
            return empService.updateEmployee(id, employee.getEmpName(), employee.getEmpDesignation(),
                    employee.getEmpPhone(), employee.getEmpAddress());
        }
    }

    @DeleteMapping("employee/{id}/delete")
    public void deleteEmployee(@PathVariable("id") String id) throws Exception {
        empService.deleteEmployee(id);
    }

}
