package com.wcm.webcustomermanager.service.product;

import com.wcm.webcustomermanager.entity.Product;

import java.util.List;

public interface ProductService {

    Product getProduct(int id);

    List<Product> getProducts();

    void saveProduct(Product product);

    void deleteProduct(int id);

    List<Product> searchProducts(String searchName);
}
