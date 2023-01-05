package com.ajdeyemi.inventorie.services;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ajdeyemi.inventorie.models.Expenses;
import com.ajdeyemi.inventorie.repositories.ExpensesRepository;

@Service
public class ExpenseService {
    @Autowired
    ExpensesRepository expensesRepository;

    public Iterable<Expenses> getAllExpenses() {
        return expensesRepository.findAll();
    }

    public Expenses getExpense(int id) throws Exception {
        var item = expensesRepository.findById(id);
        if (item.isEmpty()) {
            throw new Exception("This expense cannot found");
        } else {
            Expenses expense = new Expenses(item.get().getExpenseid(), item.get().getExpenseInfo(),
                    item.get().getExpenseAmount(), item.get().getEmployeeId(), item.get().getExpensetatus(),
                    item.get().getDateCreated(), item.get().getApproveBy());
            return expense;
        }
    }

    public Expenses addExpense(String expenseInfo, double expenseAmount, String employeeId, String expensetatus) {
        Date date = new Date();
        Expenses expense = new Expenses(expenseInfo, expenseAmount, employeeId, expensetatus, date);
        expensesRepository.save(expense);
        return expense;
    }

    public Expenses changeExpenseStatus(int id, String status, String approvedBy) throws Exception {
        var item = expensesRepository.findById(id);
        if (item.isEmpty()) {
            throw new Exception("This expense cannot found");
        }
        if (approvedBy == null) {
            throw new Exception("Who is approving this?");
        } else {
            Expenses expense = new Expenses(item.get().getExpenseid(), item.get().getExpenseInfo(),
                    item.get().getExpenseAmount(), item.get().getEmployeeId(), status, item.get().getDateCreated(),
                    approvedBy);
            expensesRepository.save(expense);
            return expense;
        }
    }

}
