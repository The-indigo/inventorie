package com.ajdeyemi.inventorie.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ajdeyemi.inventorie.models.Sales;

public interface SalesRepository extends JpaRepository<Sales, Integer> {
    @Query("SELECT s FROM Sales s WHERE MONTH(s.saleDate)=?1 AND YEAR(s.saleDate)=?2")
    public Iterable<Sales> findBySaleDate(int month, int year);

    @Query("SELECT s FROM Sales s WHERE YEAR(s.saleDate)=?1")
    public Iterable<Sales> findBySaleDate(int year);
}
