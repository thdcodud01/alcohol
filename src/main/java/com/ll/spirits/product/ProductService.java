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

    public List<Product> findByMainCategoryAndSubCategory(Integer mainCategoryId, Integer subCategoryId) { // 메인카테고리와 서브카테고리 같이 찾는 로직
        return this.productRepository.findByMainCategoryAndSubCategory(mainCategoryId, subCategoryId);
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

    public List<Product> getFilteredProductsByMainCategory(ProductDTO productDTO, Integer mainCategoryId) {
        List<Product> productList = findByMainCategoryId(mainCategoryId);

        if (productDTO.getSubCategory() != null) {
            List<Integer> productIds = productList.stream()
                    .map(Product::getId)
                    .collect(Collectors.toList());
            productList = productRepository.findBySubCategoryIdAndIdIn(productDTO.getSubCategory().getId(), productIds);
        }
        if (productDTO.getCostRange() != null) {
            List<Integer> productIds = productList.stream()
                    .map(Product::getId)
                    .collect(Collectors.toList());
            productList = productRepository.findByCostRangeIdAndIdIn(productDTO.getCostRange().getId(), productIds);
        }
        if (productDTO.getAbvRange() != null) {
            List<Integer> productIds = productList.stream()
                    .map(Product::getId)
                    .collect(Collectors.toList());
            productList = productRepository.findByABVrangeIdAndIdIn(productDTO.getAbvRange().getId(), productIds);
        }
        if (productDTO.getNetWeight() != null) {
            List<Integer> productIds = productList.stream()
                    .map(Product::getId)
                    .collect(Collectors.toList());
            productList = productRepository.findByNetWeightIdAndIdIn(productDTO.getNetWeight().getId(), productIds);
        }
        if (productDTO.getPairings() != null && !productDTO.getPairings().isEmpty()) {
            List<Integer> productIds = productList.stream()
                    .map(Product::getId)
                    .collect(Collectors.toList());
            List<Integer> pairingIds = productDTO.getPairings().stream()
                    .map(Pairing::getId)
                    .collect(Collectors.toList());
            productList = productRepository.findByPairingsIdInAndIdIn(pairingIds, productIds);
        }
        if (productDTO.getCasks() != null && !productDTO.getCasks().isEmpty()) {
            List<Integer> productIds = productList.stream()
                    .map(Product::getId)
                    .collect(Collectors.toList());
            List<Integer> caskIds = productDTO.getCasks().stream()
                    .map(Cask::getId)
                    .collect(Collectors.toList());
            productList = productRepository.findByCasksIdInAndIdIn(caskIds, productIds);
        }
        if (productDTO.getNation() != null) {
            List<Integer> productIds = productList.stream()
                    .map(Product::getId)
                    .collect(Collectors.toList());
            productList = productRepository.findByNationIdAndIdIn(productDTO.getNation().getId(), productIds);
        }

        return productList;

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