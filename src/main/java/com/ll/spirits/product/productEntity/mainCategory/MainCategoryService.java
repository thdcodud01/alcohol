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
    public MainCategory getMainCategoryId(Integer id) {// Integer 로 타입이 들어오면 null 값도 허용해줄 수 있음
        Optional<MainCategory> mainCategoryId = this.mainCategoryRepository.findById(id);
        if (mainCategoryId.isPresent()) {
            return mainCategoryId.get();
        } else {
            throw new DataNotFoundException("mainCategoryId not found"); // 예외처리로 에러(DataNotFoundException)를 표시
        }
    }
}
