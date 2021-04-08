package com.store.mystore.Product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;

import java.util.Map;

@RestController
@RequestMapping(path="product/")
@Controller
public class ProductController {
    private final ProductServices productServices;

    @Autowired
    public ProductController(ProductServices productServices) {
        this.productServices = productServices;
    }



    @PostMapping(path = "add_product")
    public String addProduct(@RequestBody Map<String, Object> obj) {
        System.out.println(obj.get("productName"));

        return this.productServices.addProduct(new Product((String) obj.get("productName"), (Double) obj.get("productPrice")));
    }

    @DeleteMapping(path="delete_product/{id}")
    public String deleteProduct(@PathVariable long id) {
        return this.productServices.deleteProduct(id);
    }

    @PutMapping(path="edit_product/{id}")
    @Transactional
    public String editProduct(@PathVariable long id, @RequestBody Map<String, Object> reqBody) {
        return this.productServices.updatePrice(id, (Double) reqBody.get("productPrice"));
    }
}
