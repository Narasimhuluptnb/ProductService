package com.product.productservice.exceptions;

public class ProductNotFoundException extends Exception {
    // constructor ==> super can be used in constructor only
    public ProductNotFoundException(String message) {
        super(message);
    }
}
