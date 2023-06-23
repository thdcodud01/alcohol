package com.ll.spirits.product;

import com.ll.spirits.product.productEntity.abvRange.ABVrange;
import com.ll.spirits.product.productEntity.cask.Cask;
import com.ll.spirits.product.productEntity.costRange.CostRange;
import com.ll.spirits.product.productEntity.mainCategory.MainCategory;
import com.ll.spirits.product.productEntity.nation.Nation;
import com.ll.spirits.product.productEntity.netWeight.NetWeight;
import com.ll.spirits.product.productEntity.pairing.Pairing;
import com.ll.spirits.product.productEntity.subCategory.SubCategory;
import com.ll.spirits.review.Review;
import com.ll.spirits.user.SiteUser;
import jakarta.persistence.criteria.Join;
import jakarta.persistence.criteria.JoinType;
import org.springframework.data.jpa.domain.Specification;
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

    List<Product> findByVoter(SiteUser voter);

    List<Product> findByWish(SiteUser wish);

    @Query("SELECT p FROM Product p " +
            "LEFT JOIN p.casks cask " +
            "LEFT JOIN p.pairings pairing " +
            "WHERE (:subCategory is null or p.subCategory.id = :subCategory) and " +
            "(:costRange is null or p.costRange.id = :costRange) and " +
            "(:abvRange is null or p.abvRange.id = :abvRange) and " +
            "(:netWeight is null or p.netWeight.id = :netWeight) and " +
            "(:nation is null or p.nation.id = :nation) and " +
            "(:kw is null or p.name like %:kw%) and " +
            "(:cask is null or cask.id = :cask) and " +
            "(:pairing is null or pairing.id = :pairing)")
    List<Product> findProductBySubCategoryIdAndCostRangeIdAndAbvRangeIdAndNetWeightIdAndNationIdAndKwAndCaskAndPairing(
            @Param("subCategory") Integer subCategoryId,
            @Param("costRange") Integer costRangeId,
            @Param("abvRange") Integer abvRangeId,
            @Param("netWeight") Integer netWeightId,
            @Param("nation") Integer nationId,
            @Param("kw") String kw,
            @Param("cask") Integer caskId,
            @Param("pairing") Integer pairingId);




    @Modifying
    @Query("UPDATE Product p SET p.views = p.views + 1 WHERE p.id = :productId")
    void incrementProductHits(@Param("productId") Integer productId);

    @Query("SELECT DISTINCT p " +
            "FROM Product p " +
            "LEFT JOIN p.author u " +
            "LEFT JOIN p.abvRange ar " +
            "LEFT JOIN p.costRange cr " +
            "LEFT JOIN p.mainCategory mc " +
            "LEFT JOIN p.nation n " +
            "LEFT JOIN p.netWeight nw " +
            "LEFT JOIN p.subCategory sub " +
            "LEFT JOIN p.casks c " +
            "LEFT JOIN p.pairings pa " +
            "WHERE p.name LIKE %:kw% " +
            "OR p.info LIKE %:kw% " +
            "OR u.username LIKE %:kw% " +
            "OR ar.abvRange LIKE %:kw% " +
            "OR cr.costRange LIKE %:kw% " +
            "OR mc.mainCategory LIKE %:kw% " +
            "OR n.nation LIKE %:kw% " +
            "OR nw.netWeight LIKE %:kw% " +
            "OR sub.subCategory LIKE %:kw% " +
            "OR c.cask LIKE %:kw% " +
            "OR pa.pairing LIKE %:kw% ")
    List<Product> findAllByKeyword(@Param("kw") String kw);
    @Query("SELECT r FROM Review r JOIN FETCH r.author WHERE r.content LIKE %:kw% OR r.author.username LIKE %:kw%")
    List<Review> findAllByKeywordInReview(@Param("kw") String kw);

    @Query("SELECT u FROM SiteUser u WHERE u.username LIKE %:kw% OR u.nickname LIKE %:kw%")
    List<SiteUser> findAllByKeywordInSiteUser(@Param("kw") String kw);




    // 통합 검색을 위한 메서드

//    List<Product> findAllByNameContainingOrInfoContainingOrAuthor_UsernameContainingOrReview_Author_UsernameContainingOrSubjectContainingOrReview_ContentContainingOrAbvRange_AbvRangeContainingOrCostRange_CostRangeContainingOrMainCategory_MainCategoryContainingOrNation_NationContainingOrNetWeight_NetWeightContainingOrSubCategory_SubCategoryContainingOrCasks_CaskContainingOrPairings_PairingContaining(String name, String info, String authorUsername, String reviewAuthorUsername, String subject, String reviewContent, String abvRange, String costRange, String mainCategory, String nation, String netWeight, String subCategory, String cask, String pairing);

}
