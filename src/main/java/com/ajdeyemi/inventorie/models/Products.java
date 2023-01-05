package com.ajdeyemi.inventorie.models;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import jakarta.persistence.Entity;

@Entity
@Table(name = "Products")
public class Products {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "productid")
    private int productId;
    @Column(name = "productname")
    private String productName;
    @Column(name = "productquantity")
    private int productQuantity;
    @Column(name = "productamount")
    private double productAmount;

    public Products() {
    }

    public Products(int productQuantity) {
        this.productQuantity = productQuantity;
    }

    public Products(String productName, int productQuantity, double productAmount) {
        this.productName = productName;
        this.productQuantity = productQuantity;
        this.productAmount = productAmount;
    }

    public Products(int productId, String productName, int productQuantity, double productAmount) {
        this.productId = productId;
        this.productName = productName;
        this.productQuantity = productQuantity;
        this.productAmount = productAmount;
    }

    public int getProductId() {
        return this.productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return this.productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getProductQuantity() {
        return this.productQuantity;
    }

    public void setProductQuantity(int productQuantity) {
        this.productQuantity = productQuantity;
    }

    public double getProductAmount() {
        return this.productAmount;
    }

    public void setProductAmount(double productAmount) {
        this.productAmount = productAmount;
    }

}