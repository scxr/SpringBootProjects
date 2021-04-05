package com.store.mystore.Product;

import org.springframework.stereotype.Service;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServices {
    private static final List<Product> products = new ArrayList<Product>();
    public static List<Product> getProducts() {
        return products;
    }
<<<<<<< HEAD
    public static String addProduct(String productName, Double productPrice) {
        try {
            products.add(new Product(
                    productName,
                    productPrice
            ));
=======
    public static String addProduct(Product product) {
        try {
            products.add(product);
>>>>>>> 5e4a6d716f62ed259794db714c6dce2f98cce419
            return "product added";
        } catch (Exception e) {
            return "Something went wrong : " + e;
        }
    }
    public static String deleteProduct(long id) {
        for (Product product: products) {
            if (product.getId() == id) {
                products.remove(product);
                return "Removed";
            }
        }
        return "Product not found";
<<<<<<< HEAD
    }

    public static String editProduct(long id, Object obj) {
        System.out.println(obj.getClass().getName());
        return "";
    }

=======

    }


>>>>>>> 5e4a6d716f62ed259794db714c6dce2f98cce419
}
