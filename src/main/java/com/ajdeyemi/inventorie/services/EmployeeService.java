package com.ajdeyemi.inventorie.services;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.ajdeyemi.inventorie.config.JwtService;
import com.ajdeyemi.inventorie.models.AuthenticationRequest;
import com.ajdeyemi.inventorie.models.AuthenticationResponse;
import com.ajdeyemi.inventorie.models.Employee;
import com.ajdeyemi.inventorie.models.Role;
import com.ajdeyemi.inventorie.repositories.EmployeeRepository;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository empRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private JwtService jwtService;
    @Autowired
    private AuthenticationManager authenticationManager;

    public Iterable<Employee> getAllEmployees() {
        return empRepository.findAll();
    }

    public Employee addEmployee(String empName, String empDesignation, String empPhone,
            String empAddress, String password)
            throws Exception {
        int m = (int) Math.pow(5, 4);
        int randomNumber = m + new Random().nextInt(4 * m);
        String id = "SWAYBID" + randomNumber;
        var employee = empRepository.findById(id);
        if (!(employee.isEmpty())) {
            throw new Exception("Error adding this employee,Let's try that again");
        } else {
            Employee employeeToSave = new Employee(id, empName, empDesignation,
                    empPhone, empAddress, passwordEncoder.encode(password), Role.Employee);
            empRepository.save(employeeToSave);
            return employeeToSave;
        }
    }

    public Employee updateEmployee(String id, String empName, String empDesignation, String empPhone,
            String empAddress)
            throws Exception {
        var employee = empRepository.findById(id);
        if (!(employee.isEmpty())) {
            Employee employeeDetails = new Employee(id, empName, empDesignation, empPhone, empAddress,
                    employee.get().getRole());
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

    public AuthenticationResponse authenticate(AuthenticationRequest request) throws Exception {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));
        var user = empRepository.findById(request.getEmail()).orElseThrow();
        var jwtToken = jwtService.generateToken(user);
        return AuthenticationResponse.builder().employeeId(user.getEmployeeId())
                .name(user.getEmpName())
                .name(user.getEmpName()).role(user.getRole()).token(jwtToken).build();
    }
}
