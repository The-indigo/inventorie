package com.ajdeyemi.inventorie.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ajdeyemi.inventorie.models.Expenses;
import com.ajdeyemi.inventorie.services.ExpenseService;

@RestController
public class ExpenseController {

    @Autowired
    ExpenseService expenseService;

    @GetMapping("/expense/get")
    public Iterable<Expenses> getAllExpenses() {
        return expenseService.getAllExpenses();

    }

    @GetMapping("/expense/{id}")
    public Expenses getExpense(@PathVariable("id") int id) throws Exception {
        return expenseService.getExpense(id);
    }

    @PostMapping("/expense/add")
    public Expenses addExpense(@RequestBody Expenses expenses) throws Exception {
        return expenseService.addExpense(expenses.getExpenseInfo(), expenses.getExpenseAmount(),
                expenses.getEmployeeId(), "Pending");
    }

}
