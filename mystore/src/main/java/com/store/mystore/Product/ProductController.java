package com.store.mystore.Product;

import org.springframework.web.bind.annotation.*;

import java.util.List;
<<<<<<< HEAD
import java.util.Map;
=======
>>>>>>> 5e4a6d716f62ed259794db714c6dce2f98cce419

@RestController
@RequestMapping(path="product/")
public class ProductController {
    @GetMapping
    public List<Product> getProducts() {
        return ProductServices.getProducts();
    }

    @PostMapping(path = "add_product")
<<<<<<< HEAD
    public String addProduct(@RequestBody Map<String, Object> obj) {
        System.out.println(obj.get("productName"));

        return ProductServices.addProduct((String) obj.get("productName"), (Double) obj.get("productPrice"));
=======
    public String addProduct(Product product) {
        return ProductServices.addProduct(product);
>>>>>>> 5e4a6d716f62ed259794db714c6dce2f98cce419
    }

    @DeleteMapping(path="delete_product/{id}")
    public String deleteProduct(@PathVariable long id) {
        return ProductServices.deleteProduct(id);
    }

<<<<<<< HEAD
    @PutMapping(path="edit_product/{id}")
    public String editProduct(@PathVariable long id, @RequestBody Map<String, Object> reqBody) {
        return ProductServices.editProduct(id, reqBody);
    }

=======
>>>>>>> 5e4a6d716f62ed259794db714c6dce2f98cce419
}
