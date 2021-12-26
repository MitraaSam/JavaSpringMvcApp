package com.mystore.dao;

import com.mystore.model.Product;

import java.util.List;
public interface ProductDao {
    void addProduct(Product product);
    void editProduct(Product product);
    Product getProductById(int id);
    List<Product> getAllProduct();
    void deleteProduct(int id);
}
