package com.ll.spirits.product;

import com.ll.spirits.DataNotFoundException;
import com.ll.spirits.product.dto.ProductDTO;
import com.ll.spirits.product.mapper.ProductMapper;
import com.ll.spirits.product.productEntity.cask.Cask;
import com.ll.spirits.product.productEntity.pairing.Pairing;
import com.ll.spirits.review.Review;
import com.ll.spirits.review.ReviewRepository;
import com.ll.spirits.user.SiteUser;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class ProductService {
    private final ProductMapper productMapper;
    private final ProductRepository productRepository;
    private final ReviewRepository reviewRepository;

    public List<Product> getList() {
        return this.productRepository.findAll();
    }

    public Product getProduct(Integer id) {
        Optional<Product> product = this.productRepository.findById(id);
        if (product.isPresent()){
            return product.get();
        } else {
            throw new DataNotFoundException("product not found"); // 예외처리로 에러(DataNotFoundException)를 표시
        }
    }

    public List<Product> getProductsByMainCategoryId(Integer mainCategory) {
        // ProductRepository를 사용하여 mainCategory에 해당하는 제품 리스트를 조회합니다.
        return productRepository.findByMainCategoryId(mainCategory);
    }
    public List<Product> getProductsBySubCategoryId(Integer subCategoryId) {
        return productRepository.findBySubCategoryId(subCategoryId);
    }

    public List<Product> getProductsByMainCategoryIdAndSubCategoryId(Integer mainCategoryId, Integer subCategoryId) {
        // ProductRepository를 사용하여 mainCategory에 해당하는 제품 리스트를 조회합니다.
        return productRepository.getProductsByMainCategoryIdAndSubCategoryId(mainCategoryId, subCategoryId);
    }

    public List<Product> getProductsByCategory(String mainCategoryId, String subCategoryId) { // 메인카테고리와 서브카테고리 같이 찾는 로직
        return this.productRepository.getProductsByMainCategoryAndSubCategory(mainCategoryId, subCategoryId);
    }

    public List<Product> findByMainCategoryId(Integer mainCategory) {
        // ProductRepository를 사용하여 mainCategory에 해당하는 제품 리스트를 조회합니다.
        return productRepository.findByMainCategoryId(mainCategory);
    }

    public List<Product> findBySubCategoryId(Integer subCategoryId) {
        return productRepository.findBySubCategoryId(subCategoryId);
    }

    public List<Product> findByMainCategoryIdAndSubCategoryId(Integer mainCategoryId, Integer subCategoryId) {
        // ProductRepository를 사용하여 mainCategory에 해당하는 제품 리스트를 조회합니다.
        return productRepository.findByMainCategoryIdAndSubCategoryId(mainCategoryId, subCategoryId);
    }

    public List<Product> findByCostRangeId(Integer costRangeId) {
        return productRepository.findByCostRangeId(costRangeId);
    }

    public List<Product> findByABVrangeId(Integer abvRangeId) {
        return productRepository.findByABVrangeId(abvRangeId);
    }

    public List<Product> findByNetWeightId(Integer netWeightRangeId) {
        return productRepository.findByNetWeightId(netWeightRangeId);
    }

    public List<Product> findByPairingsIdIn(List<Integer> pairingIds) {
        return productRepository.findByPairingsIdIn(pairingIds);
    }

    public List<Product> findByCasksIdIn(List<Integer> caskIds) {
        return productRepository.findByCasksIdIn(caskIds);
    }

    public List<Product> findByNationId(Integer nationId) {
        return productRepository.findByNationId(nationId);
    }
//    public List<Product> findBySubCategoryIdAndIdIn(Integer subCategoryId, List<Integer> ids) {
//        return productRepository.findBySubCategoryIdAndIdIn(subCategoryId, ids);
//    }
//
//    public List<Product> findByCostRangeIdAndIdIn(Integer costRangeId, List<Integer> ids) {
//        return productRepository.findByCostRangeIdAndIdIn(costRangeId, ids);
//    }
//
//    public List<Product> findByABVrangeIdAndIdIn(Integer abvRangeId, List<Integer> ids) {
//        return productRepository.findByABVrangeIdAndIdIn(abvRangeId, ids);
//    }
//
//    public List<Product> findByNetWeightIdAndIdIn(Integer netWeightRangeId, List<Integer> ids) {
//        return productRepository.findByNetWeightIdAndIdIn(netWeightRangeId, ids);
//    }
//
//    public List<Product> findByPairingsIdInAndIdIn(List<Integer> pairingIds, List<Integer> ids) {
//        return productRepository.findByPairingsIdInAndIdIn(pairingIds, ids);
//    }
//
//    public List<Product> findByCasksIdInAndIdIn(List<Integer> caskIds, List<Integer> ids) {
//        return productRepository.findByCasksIdInAndIdIn(caskIds, ids);
//    }
//
//    public List<Product> findByNationIdAndIdIn(Integer nationId, List<Integer> ids) {
//        return productRepository.findByNationIdAndIdIn(nationId, ids);
//    }


    public List<Product> getFilteredProducts(ProductFilter filter) {
        List<Product> allProducts = productRepository.findAll();

        // 필터링 조건에 따라 상품들을 필터링
        List<Product> filteredProducts = allProducts.stream()
                .filter(product -> {
                    // 메인 카테고리 일치 여부 확인
                    if (!product.getMainCategory().equals(filter.getMainCategoryId())) {
                        return false;
                    }

                    // 서브 카테고리 일치 여부 확인
                    if (filter.getSubCategoryId() != null && !product.getSubCategory().getId().equals(filter.getSubCategoryId())) {
                        return false;
                    }


                    // 가격 범위 일치 여부 확인
                    if (filter.getCostRangeId() != null && !product.getCostRange().equals(filter.getCostRangeId())) {
                        return false;
                    }

                    // 도수 범위 일치 여부 확인
                    if (filter.getAbvRangeId() != null && !product.getAbvRange().equals(filter.getAbvRangeId())) {
                        return false;
                    }

                    // 용량 범위 일치 여부 확인
                    if (filter.getNetWeightRangeId() != null && !product.getNetWeight().equals(filter.getNetWeightRangeId())) {
                        return false;
                    }

                    // 안주 범위 일치 여부 확인
                    if (filter.getPairingIds() != null && !product.getPairings().containsAll(filter.getPairingIds())) {
                        return false;
                    }

                    // 캐스크 범위 일치 여부 확인
                    if (filter.getCaskIds() != null && !product.getCasks().containsAll(filter.getCaskIds())) {
                        return false;
                    }

                    // 국가 범위 일치 여부 확인
                    if (filter.getNationId() != null && !product.getNation().equals(filter.getNationId())) {
                        return false;
                    }

                    return true;
                })
                .collect(Collectors.toList());

        return filteredProducts;
    }


    public List<Review> getReviewsByProduct(Product product) { // 리뷰부분 제대로 작동하지 않을 시 최우선으로 삭제 고려할 것
        return reviewRepository.findByProduct(product);
    }

    public void create(String productName, Double abv,  String aroma, String flavor, String info, Integer cost, SiteUser user) {
        Product product = new Product();
        product.setName(productName);
        product.setAbv(abv);
        product.setAroma(aroma);
        product.setFlavor(flavor);
        product.setInfo(info);
        product.setCost(cost);
        product.setAuthor(user);
        this.productRepository.save(product);
    }

    public void vote(Product product, SiteUser siteUser) { // 추천 메서드
        product.getVoter().add(siteUser);
        this.productRepository.save(product);
    }

    public void cancelVote(Product product, SiteUser siteUser) { // 추천 취소 메서드
        product.getVoter().remove(siteUser);
        this.productRepository.save(product);
    }

    public void wish(Product product, SiteUser siteUser) { // 찜 메서드
        product.getVoter().add(siteUser);
        this.productRepository.save(product);
    }

    public void cancleWish(Product product, SiteUser siteUser) { // 찜 취소 메서드
        product.getVoter().remove(siteUser);
        this.productRepository.save(product);
    }

    public void delete(Product product) { // 삭제 메서드
        this.productRepository.delete(product);
    }

}