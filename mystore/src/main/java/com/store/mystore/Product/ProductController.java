package com.store.mystore.Product;

import org.springframework.web.bind.annotation.*;

import java.util.List;

import java.util.Map;

@RestController
@RequestMapping(path="product/")
public class ProductController {
    @GetMapping
    public List<Product> getProducts() {
        return ProductServices.getProducts();
    }

    @PostMapping(path = "add_product")
    public String addProduct(@RequestBody Map<String, Object> obj) {
        System.out.println(obj.get("productName"));

        return ProductServices.addProduct((String) obj.get("productName"), (Double) obj.get("productPrice"));
    }

    @DeleteMapping(path="delete_product/{id}")
    public String deleteProduct(@PathVariable long id) {
        return ProductServices.deleteProduct(id);
    }

    @PutMapping(path="edit_product/{id}")
    public String editProduct(@PathVariable long id, @RequestBody Map<String, Object> reqBody) {
        return ProductServices.editProduct(id, reqBody);
    }
    }
