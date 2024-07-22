package com.product.productservice.Services;

import com.product.productservice.Models.Category;
import com.product.productservice.Models.Product;
import com.product.productservice.exceptions.ProductNotFoundException;
import com.product.productservice.repository.CategoryRepository;
import com.product.productservice.repository.ProductRepository;
//import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("selfProductService")
//@Primary
public class SelfProductService implements ProductService{

    private ProductRepository productRepository;
    private CategoryRepository categoryRepository;

    private ProductService productService;
    public SelfProductService(ProductRepository productRepository, CategoryRepository categoryRepository){
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Product getSingleProduct(long id) throws ProductNotFoundException {
        // make call to database to fetch product with given id
        Optional<Product> Oproduct = productRepository.findById(id);
        if(Oproduct.isEmpty()){
            throw new ProductNotFoundException("Product not found");
        }
        Product product = Oproduct.get();
        return product;
    }

    @Override
    public List<Product> getAllProducts() {
        return  productRepository.findAll();

    }

    @Override
    public Product updateProduct(Product product, long id) throws ProductNotFoundException{
        //Getting the product in DB
        Optional<Product> Oproduct = productRepository.findById(id);

        if(Oproduct.isEmpty()){
            throw new ProductNotFoundException("This Product is not found");
        }
        //Assining the product in optional to an product variable
        Product productinDB = Oproduct.get();
        if(product.getPrice() != 0.0){
            productinDB.setPrice(product.getPrice());
        }
        // Todo assign all the required fields like this...
        productRepository.save(productinDB);
        return productinDB;
    }

    @Override
    public Product replaceProduct(Product product, long id) {
        return null;
    }

    @Override
    public void deleteProduct(long id) {
        productRepository.deleteById(id);
    }

    @Override
    public void addNewProduct(Product product) {
        Category category = product.getCategory();

        if(category.getId() == null){
            category = categoryRepository.save(category);
            product.setCategory(category);
        }
        productRepository.save(product);
    }
}
