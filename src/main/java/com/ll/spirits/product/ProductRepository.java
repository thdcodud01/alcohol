package com.ll.spirits.product;

import com.ll.spirits.review.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Integer> {

    Optional<Product> findById(Integer id);
    List<Product> findByMainCategoryId(Integer mainCategoryId);
    //List<Product> findAllByMainCategory_IdAndSubCategory_Id(Integer mainCategoryId, Integer subCategoryId);
    List<Product> findBySubCategoryId(Integer subCategoryId);
    List<Product> findBySubCategory(Integer subCategoryId);
    List<Product> getProductsByMainCategoryIdAndSubCategoryId(Integer mainCategoryId, Integer subCategoryId);
    List<Product> getProductsByMainCategoryAndSubCategory(Integer mainCategoryId, Integer subCategoryId);

}
