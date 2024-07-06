package com.product.productservice.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
// These are used to communicate with clients.
public class FakeStoreProductDto {
    private long id;
    private String title;
    private double price;
    private String description;
    private String category;
    private String image;
}
