package com.store.mystore.Product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.persistence.criteria.CriteriaBuilder;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(path="products/") // prefix all urls with `products/`
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

    @GetMapping("register_product")
    public String registerProductGet(Model model) {
        Product product = new Product();
        model.addAttribute("product", product);
        return "productRegister";
    }

    @PostMapping("register_product")
    public String registerProduct(Model model, @ModelAttribute("product") Product product){
        try {
            this.productServices.addProduct(product);
            return getProducts(model);
        } catch (Exception e) {
            model.addAttribute("error", e);
            return "fail";
        }
    }
    @GetMapping("edit_product")
    public String editProductGet(Model model) {
        Product tmp = new Product();
        model.addAttribute("product", tmp);
        return "editProduct";
    }

    @PostMapping("edit_product")
    @Transactional
    public String editProduct(@ModelAttribute("productPrice") Double newPrice, @ModelAttribute("id") long id, Model model) {

        String r = this.productServices.updatePrice(id, newPrice);

        return getProducts(model);
    }

    @GetMapping("delete_product")
    public String deleteProductGet(Model model) {
        model.addAttribute("product", new Product());
        return "deleteProduct";
    }

    @PostMapping("delete_product")
    public String deleteProduct(@ModelAttribute("id") long id, Model model) {
        this.productServices.deleteProduct(id);
        return getProducts(model);
    }
}
