package com.product.productservice.Controller;

import com.product.productservice.Models.Product;
import com.product.productservice.Services.ProductService;
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
    public Product getProductById(@PathVariable("id") Long id){
        return productService.getSingleProduct(id);
    }

    @GetMapping()
    public List<Product> getAllProducts(){
        return productService.getAllProducts();
    }
    @PatchMapping("/{id}")
    public Product updateProduct(@RequestBody Product product,@PathVariable long id){

        return new Product();
    }
    @PutMapping("/{id}")
    public Product replaceProduct(@RequestBody Product product,@PathVariable long id){

        return new Product();
    }
    public void deleteProduct(Long id){
        return;
    }

//    @GetMapping("/sayHello/{name}")
//    public String sayHello(@PathVariable("name") String name){
//        return "Hello "+name;
//    }
}
