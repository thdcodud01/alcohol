package com.ll.spirits.product.productEntity.subCategory;

import com.ll.spirits.DataNotFoundException;
import com.ll.spirits.product.Product;
import com.ll.spirits.product.productEntity.mainCategory.MainCategory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SubCategoryService {

    private final SubCategoryRepository subCategoryRepository;

    public List<SubCategory> getAllSubCategories() {
        return subCategoryRepository.findAll();
    }

    public SubCategory getSubCategory(String subCategory) {
        Optional<SubCategory> subCategory1 = this.subCategoryRepository.findBySubCategory(subCategory);
        if (subCategory1.isPresent()) {
            return subCategory1.get();
        } else {
            throw new DataNotFoundException("subCategory not found");
        }
    }
    public List<SubCategory> getSubCategoriesByMainCategoryId(Integer mainCategoryId) {
        return subCategoryRepository.findByMainCategoryId(mainCategoryId);
    }
}
