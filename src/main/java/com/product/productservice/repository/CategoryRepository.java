package com.product.productservice.repository;

import com.product.productservice.Models.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Integer> {

    //Category save();
}
