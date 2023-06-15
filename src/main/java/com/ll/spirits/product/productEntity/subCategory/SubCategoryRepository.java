package com.ll.spirits.product.productEntity.subCategory;

import com.ll.spirits.product.productEntity.mainCategory.MainCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface SubCategoryRepository extends JpaRepository<SubCategory, Integer> {
    Optional<SubCategory> findBySubCategory(String subCategory);
    List<SubCategory> findByMainCategoryId(Integer mainCategoryId);
}
