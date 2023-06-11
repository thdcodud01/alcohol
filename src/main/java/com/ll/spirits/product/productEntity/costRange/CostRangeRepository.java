package com.ll.spirits.product.productEntity.costRange;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CostRangeRepository extends JpaRepository<CostRange, Integer> {

}
