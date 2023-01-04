package com.ajdeyemi.inventorie.services;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ajdeyemi.inventorie.models.Products;
import com.ajdeyemi.inventorie.models.Sales;
import com.ajdeyemi.inventorie.repositories.ProductsRepository;
import com.ajdeyemi.inventorie.repositories.SalesRepository;

@Service
public class SalesService {

    @Autowired
    SalesRepository salesRepository;

    @Autowired
    ProductsRepository productsRepository;

    public Iterable<Sales> getAllSales() {
        return salesRepository.findAll();
    }

    public Sales addSale(int productid, int quantity, double amount, Date saleDate) throws Exception {
        var item = productsRepository.findById(productid);
        int itemQuantity = item.get().getProductQuantity();
        if (item.isEmpty()) {
            throw new Exception("This product does not exist");
        }
        if (quantity > itemQuantity) {
            int newQuantity = itemQuantity - quantity;
            Sales sale = new Sales(productid, quantity, amount, saleDate);
            salesRepository.save(sale);
            Products product = new Products(item.get().getProductId(), item.get().getProductName(),
                    newQuantity, item.get().getProductamount());

            productsRepository.save(product);
            return sale;
        } else {
            throw new Exception("Quantity currently not in stock");
        }

    }

    public Iterable<Sales> getSalesByMonth(int month, int year) {
        var items = salesRepository.findBySaleDate(month, year);
        return items;
    }

    public Iterable<Sales> getSalesByYear(int year) {
        var items = salesRepository.findBySaleDate(year);
        return items;
    }

}
