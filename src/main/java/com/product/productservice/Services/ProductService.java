package com.product.productservice.Services;

import com.product.productservice.Models.Product;

import java.util.List;

public interface ProductService {

    Product getSingleProduct(long id);
    List<Product> getAllProducts();
    Product updateProduct(Product product,long id);
    Product replaceProduct(Product product,long id);
    void deleteProduct(long id);
}
