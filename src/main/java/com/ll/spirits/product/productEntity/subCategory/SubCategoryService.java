package com.ll.spirits.product.productEntity.subCategory;

import com.ll.spirits.DataNotFoundException;
import com.ll.spirits.product.Product;
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

    public SubCategory getSubCategory(Integer subCategoryId) {
        // subCategoryId를 사용하여 SubCategory를 조회하는 로직을 구현
        // 구현 예시:
        return subCategoryRepository.findById(subCategoryId).orElse(null);
    }
}
