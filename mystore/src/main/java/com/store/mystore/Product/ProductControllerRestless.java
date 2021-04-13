package com.store.mystore.Product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;
import java.io.IOException;
import java.util.List;

import com.store.mystore.security.*;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@RequestMapping(path="products/") // prefix all urls with `products/`
public class ProductControllerRestless {
    private final ProductServices productServices;

    @Autowired
    public ProductControllerRestless(ProductServices productServices) {
        this.productServices=productServices;
    }
    @RequestMapping("all_products")
    public Object getProducts(Model model, HttpServletRequest request) throws IOException {
        if (!Protection.isValidSignin(request.getCookies(), jwt_key.getJwtKey())) {
            return new RedirectView("/users/login");
        }
        String user = Protection.returnUser(request.getCookies(), jwt_key.getJwtKey());

        List<Product> products = this.productServices.getProducts();
        System.out.println(products);

        model.addAttribute("products", products);
        model.addAttribute("userRequesting", user);
        return "productListing";
    }

    @GetMapping("register_product")
    public Object registerProductGet(Model model, HttpServletRequest request) throws IOException {
        if (!Protection.isValidSignin(request.getCookies(), jwt_key.getJwtKey())) {
            return new RedirectView("/users/login");
        }
        Product product = new Product();
        model.addAttribute("product", product);
        return "productRegister";
    }

    @PostMapping("register_product")
    public Object registerProduct(Model model, @ModelAttribute("product") Product product, HttpServletRequest request) throws IOException {
        if (!Protection.isValidSignin(request.getCookies(), jwt_key.getJwtKey())) {
            return new RedirectView("/users/login");
        }
        String owner = Protection.returnUser(request.getCookies(), jwt_key.getJwtKey());
        try {
            this.productServices.addProduct(product, owner);
            return new RedirectView("/products/all_products");
        } catch (Exception e) {
            model.addAttribute("error", e);
            return "fail";
        }
    }

    @GetMapping("my_products")
    public Object myProductsGet(Model model, HttpServletRequest request) throws IOException {
        if (!Protection.isValidSignin(request.getCookies(), jwt_key.getJwtKey())) {
            return new RedirectView("/users/login");
        }
        String user = Protection.returnUser(request.getCookies(), jwt_key.getJwtKey());
        model.addAttribute("products", this.productServices.fetchUserProducts(user));
        return "usersProducts";
    }

    @GetMapping("edit_product")
    public Object editProductGet(Model model, HttpServletRequest request) throws IOException {
        if (!Protection.isValidSignin(request.getCookies(), jwt_key.getJwtKey())) {
            return new RedirectView("/users/login");
        }
        String user = Protection.returnUser(request.getCookies(), jwt_key.getJwtKey());
        List<Product> userProducts = this.productServices.fetchUserProducts(user);
        model.addAttribute("product", new Product());
        model.addAttribute("products", userProducts);
        return "editProduct";
    }

    @PostMapping("edit_product")
    @Transactional
    public Object editProduct(@ModelAttribute("productPrice") Double newPrice, @ModelAttribute("id") long id, Model model
                                , HttpServletRequest request) throws IOException {
        if (!Protection.isValidSignin(request.getCookies(), jwt_key.getJwtKey())) {
            return new RedirectView("/users/login");
        }
        String user = Protection.returnUser(request.getCookies(), jwt_key.getJwtKey());

        String r = this.productServices.updatePrice(id, newPrice, user);
        if (!r.equals("Updated")) {
            model.addAttribute("error", r);
            return "fail";
        }
        return getProducts(model, request);
    }

    @GetMapping("delete_product")
    public String deleteProductGet(Model model) {
        model.addAttribute("product", new Product());
        return "deleteProduct";
    }

    @PostMapping("delete_product")
    public Object deleteProduct(@ModelAttribute("id") long id, Model model, HttpServletRequest request) throws IOException {
        if (!Protection.isValidSignin(request.getCookies(), jwt_key.getJwtKey())) {
            return new RedirectView("/users/login");
        }
        this.productServices.deleteProduct(id);
        return getProducts(model, request);
    }
}
