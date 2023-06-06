package com.ll.spirits.product.productEntity.pairing;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface PairingRepository extends JpaRepository<Pairing, Integer> {
    List<Pairing> findByIdIn(List<Integer> pairingIds);
}
