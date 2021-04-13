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
    public String addProduct(Product product, String owner) {
        product.setProductOwner(owner);
        List<Product> userProducts = this.productRepository.getUserProducts(owner);
        for (Product productL: userProducts) {
            if (productL.getProductName().equals(product.getProductName())) {
                return "Already have product with this name";
            }
        }
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

    public String updatePrice(long id, Double productPrice,String user) {
        boolean isEditable = false;
        List<Product> userProducts = this.productRepository.getUserProducts(user);
        for (Product product: userProducts) {
            if(product.getId() == id) {
                isEditable = true;
                break;
            }
        }
        if (!isEditable) {
            return "Wrong user";
        }
        this.productRepository.updateProductById(productPrice, id);
        return "Updated";
    }

    public List<Product> fetchUserProducts(String user){
        return this.productRepository.getUserProducts(user);
    }


}
