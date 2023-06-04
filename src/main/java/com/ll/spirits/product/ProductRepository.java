package com.ll.spirits.product;

import com.ll.spirits.review.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
    List<Product> findByMainCategoryId(Integer mainCategoryId);
    //List<Product> findAllByMainCategory_IdAndSubCategory_Id(Integer mainCategoryId, Integer subCategoryId);
    List<Product> findBySubCategoryId(Integer subCategoryId);
    List<Product> getProductsByMainCategoryIdAndSubCategoryId(Integer mainCategoryId, Integer subCategoryId);
    List<Product> getProductsByMainCategoryAndSubCategory(String mainCategory, String subCategory);
    List<Product> getProductsByCostRangeId(Integer costRangeId);
    List<Product> getProductsByAbvRangeId(Integer abvRangeId);
    List<Product> getProductsByNetWeightId(Integer netWeightRangeId);
    List<Product> getProductsByPairingId(Integer pairingId);
    List<Product> getProductsByCaskId(Integer caskId);
    List<Product> getProductsByNationId(Integer nationId);

}
