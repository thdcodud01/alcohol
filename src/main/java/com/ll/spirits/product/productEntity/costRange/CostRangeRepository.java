package com.ll.spirits.product.productEntity.costRange;

import com.ll.spirits.product.productEntity.mainCategory.MainCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CostRangeRepository extends JpaRepository<CostRange, Integer> {
    Optional<CostRange> findByCostRange(String costRange);
}
