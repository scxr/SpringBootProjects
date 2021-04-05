package com.store.mystore.Product;


import org.apache.tomcat.jni.Local;

import java.time.LocalDate;
import java.util.Random;

public class Product {
    private String productName = null;
    private double productPrice = 0;
    private LocalDate creationDate;
    private long id;
    Random rand = new Random();

    public Product(String productName, double productPrice) {
        this.id = rand.nextInt(1000000);
        this.creationDate = LocalDate.now();
        this.productName = productName;
        this.productPrice = productPrice;
    }

    public Product(String productName, double productPrice, long id) {

        this.productPrice = productPrice;
        this.productName = productName;
        this.id = id;
        this.creationDate = LocalDate.now();
    }
    public Product(){}

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "product{" +
                "productName='" + productName + '\'' +
                ", productPrice=" + productPrice +
                ", creationDate=" + creationDate +
                '}';
    }
}
