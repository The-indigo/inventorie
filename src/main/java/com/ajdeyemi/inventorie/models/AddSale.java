package com.ajdeyemi.inventorie.models;

public class AddSale {
    private String productName;
    private int quantity;
    private double amount;
    private String saleDate;

    public AddSale() {
    }

    public AddSale(String productName, int quantity, double amount, String saleDate) {
        this.productName = productName;
        this.quantity = quantity;
        this.amount = amount;
        this.saleDate = saleDate;
    }

    public String getProductName() {
        return this.productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getQuantity() {
        return this.quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getAmount() {
        return this.amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getSaleDate() {
        return this.saleDate;
    }

    public void setSaleDate(String saleDate) {
        this.saleDate = saleDate;
    }

}
