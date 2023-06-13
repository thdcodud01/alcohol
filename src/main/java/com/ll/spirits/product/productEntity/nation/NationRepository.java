package com.ll.spirits.product.productEntity.nation;

import com.ll.spirits.product.productEntity.mainCategory.MainCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface NationRepository extends JpaRepository<Nation, Integer> {
    Optional<Nation> findByNation(String nation);
}
