package com.ajdeyemi.inventorie.services;

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
                    item.get().getExpenseAmount(), item.get().getEmployeeId(), item.get().getExpensetatus());
            return expense;
        }
    }
}
