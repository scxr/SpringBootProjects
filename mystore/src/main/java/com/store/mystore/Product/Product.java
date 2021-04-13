package com.store.mystore.Product;


import org.apache.tomcat.jni.Local;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Random;


@Entity
@Table
public class Product {

    @Id
    @SequenceGenerator(
            name="product_sequence",
            sequenceName = "product_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "product_sequence"
    )
    private Long id;
    private String  productOwner=null;
    private String productName = null;
    private double productPrice = 0;
    private LocalDate creationDate;

    Random rand = new Random();

    public Product(String productName, double productPrice, String productOwner) {
        this.creationDate = LocalDate.now();
        this.productName = productName;
        this.productPrice = productPrice;
        this.productOwner = productOwner;
    }

    public Product(Long id, String productName, double productPrice) {

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

    public long getProductId(){return id;}

    public void setId(Long id) {
        this.id = id;
    }

    public String getProductOwner() {
        return productOwner;
    }

    public void setProductOwner(String productOwner) {
        this.productOwner = productOwner;
    }

    @Override
    public String toString() {
        return "product{" +
                "productName='" + productName + '\'' +
                ", productPrice=" + productPrice +
                ", creationDate=" + creationDate +
                '}';
    }


    public Long getId() {
        return id;
    }
}
