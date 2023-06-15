package com.ll.spirits.product.productEntity.netWeight;

import com.ll.spirits.product.productEntity.mainCategory.MainCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface NetWeightRepository extends JpaRepository<NetWeight, Integer> {
    Optional<NetWeight> findByNetWeight(String netWeight);
}
