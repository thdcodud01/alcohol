package com.ll.spirits.product.productEntity.subCategory;

import com.ll.spirits.product.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SubCategoryRepository extends JpaRepository<SubCategory, Integer> {
    List<SubCategory> getSubCategoryById(Integer subCategoryId);
}
