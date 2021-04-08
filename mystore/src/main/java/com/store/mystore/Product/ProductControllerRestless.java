package com.store.mystore.Product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class ProductControllerRestless {
    private final ProductServices productServices;

    @Autowired
    public ProductControllerRestless(ProductServices productServices) {
        this.productServices=productServices;
    }
    @RequestMapping("all_products")
    public String getProducts(Model model) {
        List<Product> products = this.productServices.getProducts();
        System.out.println(products);

        model.addAttribute("products", products);
        return "productListing";
    }
}
