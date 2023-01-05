package com.ajdeyemi.inventorie.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ajdeyemi.inventorie.models.Products;
import com.ajdeyemi.inventorie.services.ProductsService;

@RestController
public class ProductsController {

    @Autowired
    ProductsService productsService;

    @GetMapping("/products/get")
    public Iterable<Products> getAllProducts() {
        return productsService.getAllProducts();
    }

    @PostMapping("/products/add")
    public Products addProduct(@RequestBody Products product) throws Exception {
        return productsService.addProduct(product.getProductName(), product.getProductQuantity(),
                product.getProductAmount());
    }

    // To increase the number of the product quantity
    @PutMapping("/products/{id}/quantity")
    public Products addQuantity(@PathVariable("id") int id, @RequestBody Products product) throws Exception {
        return productsService.addProductQuantity(id, product.getProductQuantity());
    }

    @PutMapping("/products/{id}/update")
    public Products updateProduct(@PathVariable("id") int id, @RequestBody Products product) throws Exception {
        return productsService.updateProduct(id, product.getProductName(), product.getProductQuantity(),
                product.getProductAmount());
    }

    @GetMapping("/products/total")
    public int getTotalAllProducts() {
        return productsService.getTotalAllProducts();
    }

    @DeleteMapping("/products/{id}/delete")
    public void deleteProduct(@PathVariable("id") int id) throws Exception {
        productsService.deleteProduct(id);
    }

}
