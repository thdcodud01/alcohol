package com.ll.spirits.product.productEntity.pairing;

import com.ll.spirits.product.Product;
import com.ll.spirits.product.productEntity.cask.Cask;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PairingRepository extends JpaRepository<Pairing, Integer> {


}
