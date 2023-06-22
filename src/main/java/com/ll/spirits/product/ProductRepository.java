package com.ll.spirits.product;

import com.ll.spirits.product.productEntity.cask.Cask;
import com.ll.spirits.product.productEntity.pairing.Pairing;
import com.ll.spirits.review.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
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

    //    @Query("SELECT p FROM Product p " +
//            "WHERE (:subCategoryId IS NULL OR p.subCategory.id = :subCategoryId) " +
//            "AND (:costRangeId IS NULL OR p.costRange.id = :costRangeId) " +
//            "AND (:abvRangeId IS NULL OR p.abvRange.id = :abvRangeId) " +
//            "AND (:netWeightId IS NULL OR p.netWeight.id = :netWeightId) " +
//            "AND (:pairingId IS NULL OR EXISTS (SELECT 1 FROM p.pairings pr WHERE pr.id = :pairingId)) " +
//            "AND (:caskId IS NULL OR EXISTS (SELECT 1 FROM p.casks c WHERE c.id = :caskId)) " +
//            "AND (:nationId IS NULL OR p.nation.id = :nationId)")
//    List<Product> findFilteredProducts(@Param("subCategoryId") Integer subCategoryId,
//                                       @Param("costRangeId") Integer costRangeId,
//                                       @Param("abvRangeId") Integer abvRangeId,
//                                       @Param("netWeightId") Integer netWeightId,
//                                       @Param("pairingId") Integer pairingId,
//                                       @Param("caskId") Integer caskId,
//                                       @Param("nationId") Integer nationId);
    List<Product> findBySubCategory_IdOrCostRange_IdOrAbvRange_IdOrNetWeight_IdOrPairings_IdOrCasks_IdOrNation_Id(
            Integer subCategoryId, Integer costRangeId, Integer abvRangeId, Integer netWeightId, Integer pairingId, Integer caskId, Integer nationId);

    @Modifying
    @Query("UPDATE Product p SET p.views = p.views + 1 WHERE p.id = :productId")
    void incrementProductHits(@Param("productId") Integer productId);
}
