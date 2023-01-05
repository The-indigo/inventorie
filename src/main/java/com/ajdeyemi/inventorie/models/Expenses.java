package com.ajdeyemi.inventorie.models;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import jakarta.persistence.Entity;

@Entity
@Table(name = "Expenses")
public class Expenses {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "expenseid")
    private int expenseid;
    @Column(name = "expenseinfo")
    private String expenseInfo;
    @Column(name = "expenseamount")
    private double expenseAmount;
    @Column(name = "employeeid")
    private String employeeId;
    @Column(name = "expensestatus")
    private String expensetatus;
    @Column(name = "datecreated")
    private Date dateCreated;

    public Expenses() {
    }

    public Expenses(String expenseInfo, double expenseAmount, String employeeId, String expensetatus,
            Date dateCreated) {
        this.expenseInfo = expenseInfo;
        this.expenseAmount = expenseAmount;
        this.employeeId = employeeId;
        this.expensetatus = expensetatus;
        this.dateCreated = dateCreated;
    }

    public Expenses(int expenseid, String expenseInfo, double expenseAmount, String employeeId, String expensetatus,
            Date dateCreated) {
        this.expenseid = expenseid;
        this.expenseInfo = expenseInfo;
        this.expenseAmount = expenseAmount;
        this.employeeId = employeeId;
        this.expensetatus = expensetatus;
        this.dateCreated = dateCreated;
    }

    public int getExpenseid() {
        return this.expenseid;
    }

    public void setExpenseid(int expenseid) {
        this.expenseid = expenseid;
    }

    public String getExpenseInfo() {
        return this.expenseInfo;
    }

    public void setExpenseInfo(String expenseInfo) {
        this.expenseInfo = expenseInfo;
    }

    public double getExpenseAmount() {
        return this.expenseAmount;
    }

    public void setExpenseAmount(double expenseAmount) {
        this.expenseAmount = expenseAmount;
    }

    public String getEmployeeId() {
        return this.employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getExpensetatus() {
        return this.expensetatus;
    }

    public void setExpensetatus(String expensetatus) {
        this.expensetatus = expensetatus;
    }

    public Date getDateCreated() {
        return this.dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }
}