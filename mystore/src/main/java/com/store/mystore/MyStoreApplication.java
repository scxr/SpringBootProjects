package com.store.mystore;

import com.store.mystore.Product.Product;
import com.store.mystore.Product.ProductRepository;
import com.store.mystore.Product.ProductServices;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MyStoreApplication {
    public static void main(String[] args) {
        SpringApplication.run(MyStoreApplication.class, args);
    }

}
