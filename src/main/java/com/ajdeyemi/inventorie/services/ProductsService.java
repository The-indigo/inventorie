package com.ajdeyemi.inventorie.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ajdeyemi.inventorie.models.Products;
import com.ajdeyemi.inventorie.repositories.ProductsRepository;

@Service
public class ProductsService {

    @Autowired
    ProductsRepository productsRepository;

    public Iterable<Products> getAllProducts() {
        return productsRepository.findAll();
    }

    public Products addProduct(String name, int quantity, double amount) throws Exception {
        var product = productsRepository.findByProductName(name);
        if (product != null) {
            throw new Exception("There is already a record of this item");
        } else {
            Products newProduct = new Products(name, quantity, amount);
            productsRepository.save(newProduct);
            return newProduct;
        }
    }

    public Products addProductQuantity(int id, int quantity) throws Exception {
        var item = productsRepository.findById(id);
        if (item.isEmpty()) {
            throw new Exception("There is no record of this item");
        } else {
            int prevQuantity = item.get().getProductQuantity();
            int newQuantity = prevQuantity + quantity;
            Products product = new Products(id, item.get().getProductName(), newQuantity,
                    item.get().getProductamount());
            productsRepository.save(product);
            return product;
        }
    }

    public Products updateProduct(int id, String name, int quantity, double amount) throws Exception {
        var item = productsRepository.findById(id);
        if (item.isEmpty()) {
            throw new Exception("There is no record of this item");
        } else {
            Products product = new Products(id, name, quantity, amount);
            productsRepository.save(product);
            return product;
        }
    }

    public int getTotalAllProducts() {
        var allProducts = productsRepository.findAll();
        int total = 0;
        for (var item : allProducts) {
            total = total + item.getProductQuantity();
        }
        return total;
    }

    public void deleteProduct(int id) throws Exception {
        var item = productsRepository.findById(id);
        if (item.isEmpty()) {
            throw new Exception("There is no record of this item");
        } else {
            productsRepository.deleteById(id);

        }
    }

}
