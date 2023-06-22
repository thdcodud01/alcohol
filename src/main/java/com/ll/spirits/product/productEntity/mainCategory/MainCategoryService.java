package com.ll.spirits.product.productEntity.mainCategory;

import com.ll.spirits.DataNotFoundException;
import com.ll.spirits.product.Product;
import com.ll.spirits.product.productEntity.subCategory.SubCategory;
import com.ll.spirits.review.Review;
import com.ll.spirits.user.SiteUser;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
@RequiredArgsConstructor
@Service
public class MainCategoryService {

    private final MainCategoryRepository mainCategoryRepository;
    public Integer getMainCategoryIdBymainCategory(String mainCategory) {
        // ProductRepository를 사용하여 mainCategory에 해당하는 제품 리스트를 조회합니다.
        return mainCategoryRepository.getMainCategoryIdBymainCategory(mainCategory);
    }

    public List<MainCategory> getAllMainCategories() {
        return mainCategoryRepository.findAll();
    }
    public MainCategory getMainCategory(String mainCategory) {
        Optional<MainCategory> mainCategory1 = this.mainCategoryRepository.findByMainCategory(mainCategory);
        if (mainCategory1.isPresent()) {
            return mainCategory1.get();
        } else {
            throw new DataNotFoundException("mainCategory not found");
        }
    }
}
