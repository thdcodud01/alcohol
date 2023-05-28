package com.ll.spirits.product;

import com.ll.spirits.review.Review;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Integer> {
    List<Product> findAllByCategory(Integer id);
    //List<Product> findAllByMainCategory_IdAndSubCategory_Id(Integer mainCategoryId, Integer subCategoryId);
    List<Product> findBySubCategory(Integer id);
    List<Product> getProductsByCategory(Integer mainCategoryId, Integer subCategoryId);
}
