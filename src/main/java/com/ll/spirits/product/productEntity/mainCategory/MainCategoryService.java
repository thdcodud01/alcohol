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

    private final MainCategoryRepository maincategoryRepository;

    public List<Product> getProductsByMainCategoryId(Integer id) { // 카테고리별로 제품 리스트업 (2023-05-30)
        MainCategory mainCategory = maincategoryRepository.findById(id)
                .orElseThrow(() -> new DataNotFoundException("MainCategory not found"));
        return mainCategory.getProducts();
    }

    public List<MainCategory> getList() {
        return this.maincategoryRepository.findAll();
    }

    public List<MainCategory> getMainCategoryList(Integer id) {
        Optional<MainCategory> mainCategory = this.maincategoryRepository.findById(id);
        if (mainCategory.isPresent()) {
            return Collections.singletonList(mainCategory.get());
        } else {
            throw new DataNotFoundException("mainCategory not found");
        }
    }
}
