package com.ll.spirits.product;

import com.ll.spirits.review.Review;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Integer> {
    List<Product> findAllById(Integer id);
}
