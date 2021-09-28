package com.wcm.webcustomermanager.dao.product;

import com.wcm.webcustomermanager.entity.Product;

import java.util.List;

public interface ProductDAO {

    Product getProduct(int id);

    List<Product> getProducts();

    void saveProduct(Product product);

    void deleteProduct(int id);
}
