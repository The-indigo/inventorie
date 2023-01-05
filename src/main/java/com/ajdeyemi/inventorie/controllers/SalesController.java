package com.ajdeyemi.inventorie.controllers;

import java.sql.Date;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ajdeyemi.inventorie.models.AddSale;
import com.ajdeyemi.inventorie.models.Sales;
import com.ajdeyemi.inventorie.repositories.ProductsRepository;
import com.ajdeyemi.inventorie.services.SalesService;

@RestController
public class SalesController {
    @Autowired
    SalesService salesService;

    @Autowired
    ProductsRepository productsRepository;

    @GetMapping("/sales/get")
    public Iterable<Sales> getAllSales() {
        return salesService.getAllSales();
    }

    // Using the AddSale model for the request body
    // could have used an hashmap/map instead of creating a seperate class
    @PostMapping("/sales/add")
    public Sales addSales(@RequestBody AddSale sale) throws Exception {
        var productItem = productsRepository.findByProductName(sale.getProductName());
        if (productItem != null) {
            // string date format should be yy-mm-dd
            Date saleDate = Date.valueOf(sale.getSaleDate());
            return salesService.addSale(productItem.getProductId(), sale.getQuantity(),
                    saleDate);
        } else {
            throw new Exception("This product not yet in record");
        }
    }

    @GetMapping("/sales/getmonth")
    public Iterable<Sales> getSalesByMonth(@RequestBody Map<String, String> date) {
        String monthString = date.get("month");
        String yearString = date.get("year");

        int month = Integer.valueOf(monthString);
        int year = Integer.valueOf(yearString);
        return salesService.getSalesByMonth(month, year);
    }

    @GetMapping("/sales/getyear")
    public Iterable<Sales> getSalesByYear(@RequestBody Map<String, String> date) {
        String yearString = date.get("year");
        int year = Integer.valueOf(yearString);
        return salesService.getSalesByYear(year);
    }
}
