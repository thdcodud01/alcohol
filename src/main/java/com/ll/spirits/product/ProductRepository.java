package com.ll.spirits.product;

import com.ll.spirits.product.dto.ProductDTO;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
    List<Product> findByMainCategoryId(Integer mainCategoryId);
    //List<Product> findAllByMainCategory_IdAndSubCategory_Id(Integer mainCategoryId, Integer subCategoryId);
    List<Product> findBySubCategoryId(Integer subCategoryId);
    List<Product> findByCostRangeId(Integer costRangeId);
    List<Product> findByABVrangeId(Integer abvRangeId);
    List<Product> findByNetWeightId(Integer netWeightRangeId);
    List<Product> findByPairingsIdIn(List<Integer> pairingIds);
    List<Product> findByCasksIdIn(List<Integer> caskIds);
    List<Product> findByNationId(Integer nationId);
    List<Product> findByMainCategoryIdAndSubCategoryId(Integer mainCategoryId, Integer subCategoryId);
    List<Product> findByMainCategoryAndSubCategory(Integer mainCategoryId, Integer subCategoryId);
    List<Product> findByIdIn(List<Integer> ids); // 추가된 메서드
    List<Product> findBySubCategoryIdAndIdIn(Integer subCategoryId, List<Integer> ids);
    List<Product> findByCostRangeIdAndIdIn(Integer costRangeId, List<Integer> ids);
    List<Product> findByABVrangeIdAndIdIn(Integer abvRangeId, List<Integer> ids);
    List<Product> findByNetWeightIdAndIdIn(Integer netWeightRangeId, List<Integer> ids);
    List<Product> findByPairingsIdInAndIdIn(List<Integer> pairingIds, List<Integer> ids);
    List<Product> findByCasksIdInAndIdIn(List<Integer> caskIds, List<Integer> ids);
    List<Product> findByNationIdAndIdIn(Integer nationId, List<Integer> ids);

//    List<Product> getProductsByMainCategoryIdAndSubCategoryId(Integer mainCategoryId, Integer subCategoryId);
//    List<Product> getProductsByMainCategoryAndSubCategory(String mainCategory, String subCategory);
//    List<Product> getProductsBySubCategoryId(Integer subCategoryId);
//    List<Product> getProductsByCostRangeId(Integer costRangeId);
//    List<Product> getProductsByABVrangeId(Integer abvRangeId);
//    List<Product> getProductsByNetWeightId(Integer netWeightRangeId);
//    List<Product> getProductsByPairingsIdIn(List<Integer> pairingIds);
//    List<Product> getProductsByCasksIdIn(List<Integer> caskIds);
//    List<Product> getProductsByNationId(Integer nationId);
//    List<Product> getFilteredProductsByMainCategory(ProductDTO productDTO, Integer mainCategoryId);
//    // getFilteredProductsByMainCategory 메서드를 ProductRepository 인터페이스에 추가했지만,
//    // 구현 클래스에서 해당 메서드를 정의하고 있지 않기 때문
//    // 이렇게 되면 스프링은 해당 메서드를 실행할 수 있는 구현을 찾지 못하고 의존성 주입을 실패하게 됨
//

}
