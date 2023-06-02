package com.ll.spirits.product.productEntity.subCategory;

import com.ll.spirits.product.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SubCategoryService {

    private final SubCategoryRepository subCategoryRepository;

    public List<SubCategory> getAllSubCategories() {
        return subCategoryRepository.findAll();
    }

    public List<SubCategory> getSubCategoryById(Integer subCategoryId) {
        return subCategoryRepository.getSubCategoryById(subCategoryId);
    }
}
