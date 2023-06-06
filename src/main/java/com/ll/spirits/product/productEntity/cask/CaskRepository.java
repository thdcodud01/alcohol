package com.ll.spirits.product.productEntity.cask;

import com.ll.spirits.product.productEntity.pairing.Pairing;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CaskRepository extends JpaRepository<Cask, Integer> {
    List<Cask> findByIdIn(List<Integer> caskIds);
}
