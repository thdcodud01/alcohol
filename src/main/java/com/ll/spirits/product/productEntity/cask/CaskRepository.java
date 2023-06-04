package com.ll.spirits.product.productEntity.cask;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CaskRepository extends JpaRepository<Cask, Integer> {

}
