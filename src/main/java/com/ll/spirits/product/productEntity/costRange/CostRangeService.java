package com.ll.spirits.product.productEntity.costRange;

import com.ll.spirits.DataNotFoundException;
import com.ll.spirits.product.productEntity.mainCategory.MainCategory;
import com.ll.spirits.product.productEntity.subCategory.SubCategory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CostRangeService {

    private final CostRangeRepository costRangeRepository;

    public List<CostRange> getAllCostRange() {
        return costRangeRepository.findAll();
    }

    public CostRange getCostRangeById(Integer costRangeId) {
        return costRangeRepository.findById(costRangeId).orElse(null);
    }
    public CostRange getCostRange(String costRange) {
        Optional<CostRange> costRange1 = this.costRangeRepository.findByCostRange(costRange);
        if (costRange1.isPresent()) {
            return costRange1.get();
        } else {
            throw new DataNotFoundException("costRange not found");
        }
    }
}
