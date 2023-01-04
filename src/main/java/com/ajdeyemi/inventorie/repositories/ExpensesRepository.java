package com.ajdeyemi.inventorie.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ajdeyemi.inventorie.models.Expenses;

public interface ExpensesRepository extends JpaRepository<Expenses, Integer> {

}
