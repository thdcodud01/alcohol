package com.ll.spirits.product.productEntity.costRange;

import com.ll.spirits.product.productEntity.subCategory.SubCategory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class CostRangeService {

    private final CostRangeRepository costRangeRepository;

    public List<CostRange> getAllCostRange() {
        return costRangeRepository.findAll();
    }

    public CostRange getCostRange(Integer costRangeId) {
        return costRangeRepository.findById(costRangeId).orElse(null);
    }
}
