package com.product.productservice.Services;

import com.product.productservice.Models.Category;
import com.product.productservice.Models.Product;
import com.product.productservice.dtos.FakeStoreProductDto;
import com.product.productservice.exceptions.ProductNotFoundException;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpMessageConverterExtractor;
import org.springframework.web.client.RequestCallback;
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
    public Product getSingleProduct(long id) throws ProductNotFoundException{
        FakeStoreProductDto fakeStoreProductDto = restTemplate.getForObject(
                "https://fakestoreapi.com/products/" + id , FakeStoreProductDto.class
        );
        if(fakeStoreProductDto == null){
            throw new ProductNotFoundException("Product Not Found "+id+"With this id");
        }
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

    @Override
    public Product updateProduct(Product product,long id) {
        RequestCallback requestCallback = restTemplate.httpEntityCallback(product, FakeStoreProductDto.class);
        HttpMessageConverterExtractor<FakeStoreProductDto> responseExtractor = new HttpMessageConverterExtractor<>(FakeStoreProductDto.class,
                restTemplate.getMessageConverters());
        FakeStoreProductDto fakeStoreProductDto = restTemplate.execute("https://fakestoreapi.com/products/"+id, HttpMethod.PATCH,requestCallback,responseExtractor);
        return ConvetDTOtoProduct(fakeStoreProductDto);
    }

    @Override
    public Product replaceProduct(Product product,long id) {

        return null;
    }

    @Override
    public void deleteProduct(long id) {

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
