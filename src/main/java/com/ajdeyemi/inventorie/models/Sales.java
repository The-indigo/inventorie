package com.ajdeyemi.inventorie.models;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import jakarta.persistence.Entity;

@Entity
@Table(name = "Sales")
public class Sales {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "saleid")
    private int saleId;
    @Column(name = "productid")
    private int productId;
    @Column(name = "salequantity")
    private int saleQuantity;
    @Column(name = "saleamount")
    private double saleAmount;
    @Column(name = "saledate")
    private Date saleDate;
    @Column(name = "datecreated")
    private Date dateCreated;

    public Sales() {
    }

    public Sales(int productId, int saleQuantity, double saleAmount, Date saleDate, Date dateCreated) {
        this.productId = productId;
        this.saleQuantity = saleQuantity;
        this.saleAmount = saleAmount;
        this.saleDate = saleDate;
        this.dateCreated = dateCreated;
    }

    public Sales(int saleId, int productId, int saleQuantity, double saleAmount, Date saleDate, Date dateCreated) {
        this.saleId = saleId;
        this.productId = productId;
        this.saleQuantity = saleQuantity;
        this.saleAmount = saleAmount;
        this.saleDate = saleDate;
        this.dateCreated = dateCreated;

    }

    public int getSaleId() {
        return this.saleId;
    }

    public void setSaleId(int saleId) {
        this.saleId = saleId;
    }

    public int getProductId() {
        return this.productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getSaleQuantity() {
        return this.saleQuantity;
    }

    public void setSaleQuantity(int saleQuantity) {
        this.saleQuantity = saleQuantity;
    }

    public double getSaleAmount() {
        return this.saleAmount;
    }

    public void setSaleAmount(double saleAmount) {
        this.saleAmount = saleAmount;
    }

    public Date getSaleDate() {
        return this.saleDate;
    }

    public void setSaleDate(Date saleDate) {
        this.saleDate = saleDate;
    }

    public Date getDateCreated() {
        return this.dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

}