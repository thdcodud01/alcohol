package com.ll.spirits.product.productEntity.mainCategory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface MainCategoryRepository extends JpaRepository<MainCategory, Integer> {
    /*
    Optional<MainCategory> findById(Integer id);
     */
    @Query("SELECT mc.id FROM MainCategory mc WHERE mc.mainCategory = :mainCategory")
    Integer getMainCategoryIdBymainCategory(@Param("mainCategory") String mainCategory);

    @Query("SELECT mc FROM MainCategory mc WHERE mc.id = :mainCategoryId")
    MainCategory getMainCategoryById(@Param("mainCategoryId") Integer mainCategoryId);


    Optional<MainCategory> findByMainCategory(String mainCategory);

    Optional<MainCategory> findById(Integer mainCategoryId);
}
