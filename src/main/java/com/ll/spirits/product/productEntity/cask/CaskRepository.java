package com.ll.spirits.product.productEntity.cask;

import com.ll.spirits.product.Product;
import com.ll.spirits.product.productEntity.mainCategory.MainCategory;
import com.ll.spirits.user.SiteUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CaskRepository extends JpaRepository<Cask, Integer> {
    Optional<Cask> findByCask(String cask);
}
