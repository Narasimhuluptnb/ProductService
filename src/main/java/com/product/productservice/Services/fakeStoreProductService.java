package com.product.productservice.Services;

import com.product.productservice.Models.Category;
import com.product.productservice.Models.Product;
import com.product.productservice.dtos.FakeStoreProductDto;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class fakeStoreProductService implements ProductService{

    private RestTemplate restTemplate;
    public fakeStoreProductService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }
    @Override
    public Product getSingleProduct(long id) {
        FakeStoreProductDto fakeStoreProductDto = restTemplate.getForObject(
                "https://fakestoreapi.com/products/" + id , FakeStoreProductDto.class
        );

        return ConvetDTOtoProduct(fakeStoreProductDto);
    }
    @Override
    public List<Product> getAllProducts() {
        FakeStoreProductDto[] fakeStoreProductDtos = restTemplate.getForObject("https://fakestoreapi.com/products", FakeStoreProductDto[].class);
        List<Product> products = new ArrayList<>();
        for (FakeStoreProductDto fakeStoreProductDto : fakeStoreProductDtos) {
            products.add(ConvetDTOtoProduct(fakeStoreProductDto));
        }
        return products;
    }
    private Product ConvetDTOtoProduct(FakeStoreProductDto fakeStoreProductDto) {
        Product product = new Product();
        Category category = new Category();
        product.setId(fakeStoreProductDto.getId());
        product.setPrice(fakeStoreProductDto.getPrice());
        product.setTitle(fakeStoreProductDto.getTitle());
        category.setDescription(fakeStoreProductDto.getDescription());
        product.setCategory(category);

        return product;
    }


}
