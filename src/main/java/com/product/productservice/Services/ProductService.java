package com.product.productservice.Services;

import com.product.productservice.Models.Product;

import java.util.List;

public interface ProductService {

    Product getSingleProduct(long id);
    List<Product> getAllProducts();
    Product updateProduct(Product product);
    Product replaceProduct(Product product);
    void deleteProduct(long id);
}
