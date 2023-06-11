package com.ll.spirits.product.productEntity.subCategory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface SubCategoryRepository extends JpaRepository<SubCategory, Integer> {

}
