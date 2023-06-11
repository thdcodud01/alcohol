package com.ll.spirits.product.productEntity.netWeight;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NetWeightRepository extends JpaRepository<NetWeight, Integer> {
}
