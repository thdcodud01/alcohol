package com.ll.spirits.product.productEntity.mainCategory;

import com.ll.spirits.product.Product;
import com.sun.tools.javac.Main;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface MainCategoryRepository extends JpaRepository<MainCategory, Integer> {
    Optional<MainCategory> findById(Integer id);
}
