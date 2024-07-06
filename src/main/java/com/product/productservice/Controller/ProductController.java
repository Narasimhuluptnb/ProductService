package com.product.productservice.Controller;

import com.product.productservice.Models.Product;
import com.product.productservice.Services.ProductService;
import com.product.productservice.exceptions.ProductNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    private ProductService productService;
    // this is used to create object of the service classes that are implementing the interface.
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable("id") Long id) throws ProductNotFoundException {
        ResponseEntity<Product> responseEntity = new ResponseEntity<>(productService.getSingleProduct(id), HttpStatus.OK);
        //throw new ArithmeticException();
        //throw  new NullPointerException();

       return responseEntity;
    }

    @GetMapping()
    public List<Product> getAllProducts(){
        return productService.getAllProducts();
    }
    @PatchMapping("/{id}")
    // Here only a few attributes will get updated and the others have their old values.
    public Product updateProduct(@RequestBody Product product,@PathVariable long id){
        return productService.updateProduct(product,id);
    }

    @PutMapping("/{id}")
    // here completely replacing new values for all the attributes, if we failled to to give value to any attribute it will have it's default value
    public Product replaceProduct(@RequestBody Product product,@PathVariable long id){
        return productService.replaceProduct(product,id);
    }
    public void deleteProduct(Long id){
        return;
    }

}
