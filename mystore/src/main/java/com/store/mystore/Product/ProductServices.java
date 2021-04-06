package com.store.mystore.Product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServices {
    private final ProductRepository productRepository;

    @Autowired
    public ProductServices (ProductRepository productRepository) {
        this.productRepository=productRepository;
    }
    private static final List<Product> products = new ArrayList<Product>();
    public List<Product> getProducts() {
        return this.productRepository.findAll();
    }
    public String addProduct(Product product) {

        this.productRepository.save(product);
        return "Added";
    }

    public String deleteProduct(long id){
        for (Product product : products) {
            if (product.getId() == id) {
                products.remove(product);
                return "Removed";
            }
        }
        for (Product product: this.productRepository.findAll()) {
            if (product.getId() == id) {
                this.productRepository.delete(product);
                return "Removed";
            }
        }

        return "Product not found";
    }


    public static String editProduct(long id, Object obj) {
        System.out.println(obj.getClass().getName());
        return "";
    }

    public String updatePrice(long id, Double productPrice) {
        this.productRepository.updateProductById(productPrice, id);
        return "Updated";
    }


}
