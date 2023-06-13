package com.ll.spirits.product.productEntity.pairing;

import com.ll.spirits.product.Product;
import com.ll.spirits.product.productEntity.cask.Cask;
import com.ll.spirits.product.productEntity.mainCategory.MainCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PairingRepository extends JpaRepository<Pairing, Integer> {
    Optional<Pairing> findByPairing(String pairing);

}
