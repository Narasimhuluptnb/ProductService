package com.product.productservice.repository;

import com.product.productservice.Models.Product;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
//    List<Product> findPriceisGreaterThan(Product product);
//
//    List<Product> findProductByTitleLike(String title);
//    List<Product> findProductByDescriptionLike(String description);
//    List<Product> findTop10ByOrderByProductIdDesc();
//    List<Product> findTop10ByOrderByProductIdAsc();
//    List<Product> findProductByTitleContainsAndDescriptionContains(String title, String description);
    Optional<Product> findById(Long id);


}
