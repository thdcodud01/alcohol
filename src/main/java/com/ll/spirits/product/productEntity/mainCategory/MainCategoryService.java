package com.ll.spirits.product.productEntity.mainCategory;

import com.ll.spirits.DataNotFoundException;
import com.ll.spirits.product.Product;
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
}
