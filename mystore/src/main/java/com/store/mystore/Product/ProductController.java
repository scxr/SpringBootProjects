package com.store.mystore.Product;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="product/")
public class ProductController {
    @GetMapping
    public List<Product> getProducts() {
        return ProductServices.getProducts();
    }

    @PostMapping(path = "add_product")
    public String addProduct(Product product) {
        return ProductServices.addProduct(product);
    }

    @DeleteMapping(path="delete_product/{id}")
    public String deleteProduct(@PathVariable long id) {
        return ProductServices.deleteProduct(id);
    }

}
