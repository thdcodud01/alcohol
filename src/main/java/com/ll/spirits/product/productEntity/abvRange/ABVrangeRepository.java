package com.ll.spirits.product.productEntity.abvRange;

import com.ll.spirits.product.productEntity.mainCategory.MainCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ABVrangeRepository extends JpaRepository<ABVrange, Integer> {
//    Optional<ABVrange> findByABVrange(String abvRange);
}
