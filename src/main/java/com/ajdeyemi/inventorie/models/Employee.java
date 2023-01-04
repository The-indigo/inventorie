package com.ajdeyemi.inventorie.models;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Entity;

@Entity
@Table(name = "Employee")
public class Employee {
    @Id
    @Column(name = "employeeid")
    private String employeeId;
    @Column(name = "empname")
    private String empName;
    @Column(name = "empdesignation")
    private String empDesignation;
    @Column(name = "isadmin")
    private boolean isAdmin;
    @Column(name = "empphone")
    private String empPhone;
    @Column(name = "empaddress")
    private String empAddress;

    public Employee() {
    }

    public Employee(String empName, String empDesignation, boolean isAdmin, String empPhone, String empAddress) {
        this.empName = empName;
        this.empDesignation = empDesignation;
        this.isAdmin = isAdmin;
        this.empPhone = empPhone;
        this.empAddress = empAddress;
    }

    public Employee(String employeeId, String empName, String empDesignation, boolean isAdmin, String empPhone,
            String empAddress) {
        this.employeeId = employeeId;
        this.empName = empName;
        this.empDesignation = empDesignation;
        this.isAdmin = isAdmin;
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

    public boolean isIsAdmin() {
        return this.isAdmin;
    }

    public boolean getIsAdmin() {
        return this.isAdmin;
    }

    public void setIsAdmin(boolean isAdmin) {
        this.isAdmin = isAdmin;
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

}