package com.store.mystore.Product;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    @Modifying
    @Query("UPDATE Product p SET p.productPrice=?1 WHERE p.id = ?2")
    void updateProductById(Double productPrice, long id);

    @Query("SELECT p FROM Product p WHERE p.productOwner=?1")
    List<Product> getUserProducts(String user);
}
