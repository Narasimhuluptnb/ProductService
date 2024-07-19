package com.product.productservice.Services;

import com.product.productservice.Models.Product;
import com.product.productservice.exceptions.ProductNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class SelfProductService implements ProductService{

    private ProductService productService;
    public SelfProductService(ProductService productService){
        this.productService = productService;
    }

    @Override
    public Product getSingleProduct(long id) throws ProductNotFoundException {
        // make call to database to fetch product with given id

        return null;
    }

    @Override
    public List<Product> getAllProducts() {
        return List.of();
    }

    @Override
    public Product updateProduct(Product product, long id) {
        return null;
    }

    @Override
    public Product replaceProduct(Product product, long id) {
        return null;
    }

    @Override
    public void deleteProduct(long id) {

    }
}
