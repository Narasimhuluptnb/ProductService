package com.product.productservice.Models;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class BaseModel {

    private long id;
    private Date created_at;
    private Date updated_at;
}
