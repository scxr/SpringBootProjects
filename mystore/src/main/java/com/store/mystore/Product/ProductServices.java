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
    public static String addProduct(Product product) {
        try {
            products.add(product);
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

    }


}
