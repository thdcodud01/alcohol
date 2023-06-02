package com.ll.spirits.product.productEntity.mainCategory;

import com.ll.spirits.product.Product;
import com.sun.tools.javac.Main;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface MainCategoryRepository extends JpaRepository<MainCategory, Integer> {
    /*
    Optional<MainCategory> findById(Integer id);

     */
    @Query("SELECT mc.id FROM MainCategory mc WHERE mc.mainCategory = :mainCategory")
    Integer getMainCategoryIdBymainCategory(@Param("mainCategory") String mainCategory);
}
