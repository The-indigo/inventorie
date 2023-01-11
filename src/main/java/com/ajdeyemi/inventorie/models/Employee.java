package com.ajdeyemi.inventorie.models;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

@Entity
@Table(name = "Employee")
public class Employee implements UserDetails {
    @Id
    @Column(name = "employeeid")
    private String employeeId;
    @Column(name = "empname")

    private String empName;

    @Column(name = "empdesignation")
    private String empDesignation;
    // @Column(name = "isadmin")
    // private boolean isAdmin;
    @Column(name = "empphone")
    private String empPhone;
    @Column(name = "empaddress")
    private String empAddress;
    @Column(name = "password")
    private String password;
    @Column(name = "role")
    @Enumerated(EnumType.STRING)
    private Role role;

    public Employee() {
    }

    public Employee(String employeeId, String empName, String empDesignation, String empPhone,
            String empAddress,
            String password,
            Role role) {
        this.employeeId = employeeId;
        this.empName = empName;
        this.empDesignation = empDesignation;
        this.role = role;
        // this.isAdmin = isAdmin;
        this.empPhone = empPhone;
        this.empAddress = empAddress;
        this.password = password;
    }

    public Employee(String employeeId, String empName, String empDesignation, String empPhone,
            String empAddress, Role role) {
        this.employeeId = employeeId;
        this.empName = empName;
        this.empDesignation = empDesignation;
        this.role = role;

        // this.isAdmin = isAdmin;
        this.empPhone = empPhone;
        this.empAddress = empAddress;
    }

    public String getEmployeeId() {
        return this.employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmpName() {
        return this.empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getEmpDesignation() {
        return this.empDesignation;
    }

    public void setEmpDesignation(String empDesignation) {
        this.empDesignation = empDesignation;
    }

    public String getEmpPhone() {
        return this.empPhone;
    }

    public void setEmpPhone(String empPhone) {
        this.empPhone = empPhone;
    }

    public String getEmpAddress() {
        return this.empAddress;
    }

    public void setEmpAddress(String empAddress) {
        this.empAddress = empAddress;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return this.role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        // TODO Auto-generated method stub
        return List.of(new SimpleGrantedAuthority(role.name()));
    }

    @Override
    public String getUsername() {
        // TODO Auto-generated method stub
        return employeeId;
    }

    @Override
    public boolean isAccountNonExpired() {
        // TODO Auto-generated method stub
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        // TODO Auto-generated method stub
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean isEnabled() {
        // TODO Auto-generated method stub
        return true;
    }

}