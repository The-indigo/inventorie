package com.ajdeyemi.inventorie.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ajdeyemi.inventorie.repositories.ExpensesRepository;

@Service
public class ExpenseService {
    @Autowired
    ExpensesRepository expensesRepository;

}
