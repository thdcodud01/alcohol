package com.ll.spirits.product;

import com.ll.spirits.DataNotFoundException;
import com.ll.spirits.review.Review;
import com.ll.spirits.review.ReviewRepository;
import com.ll.spirits.user.SiteUser;
import jakarta.persistence.criteria.*;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class ProductService {
    private final ProductRepository productRepository;
    private final ReviewRepository reviewRepository;

    private Specification<Product> search(String kw) {
        return new Specification<>() {
            private static final long serialVersionUID = 1L;
            @Override
            public Predicate toPredicate(Root<Product> p, CriteriaQuery<?> query, CriteriaBuilder cb) {
                query.distinct(true);  // 중복을 제거
                Join<Product, Review> r = p.join("reviewList", JoinType.LEFT);
                Join<Review, SiteUser> u = r.join("author", JoinType.LEFT);
                return cb.or(cb.like(p.get("name"), "%" + kw + "%"), // 술이름
                        cb.like(p.get("content"), "%" + kw + "%"),      // 내용
                        cb.like(r.get("content"), "%" + kw + "%"),      // 리뷰 내용
                        cb.like(u.get("username"), "%" + kw + "%"));   // 리뷰 작성자
            }
        };
    }

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

    public List<Review> getReviewsByProduct(Product product) { // 리뷰부분 제대로 작동하지 않을 시 최우선으로 삭제 고려할 것
        return reviewRepository.findByProduct(product);
    }

    public void create(String Name, Double abv, String aroma, String flavor, String info, Integer cost,
                       SiteUser user) {
        Product product = new Product();
        product.setName(Name);
        product.setAbv(abv);
        product.setAroma(aroma);
        product.setFlavor(flavor);
        product.setInfo(info);
        product.setCost(cost);
//        product.setMainCategory(mainCategory);
//        product.setSubCategory(subCategory);
//        product.setCostRange(costRange);
//        product.setAbvRange(abvRange);
//        product.setNetWeight(netWeight);
//        product.setNation(nation);
        product.setAuthor(user);
        this.productRepository.save(product);
    }

//    public void createProduct(ProductForm productForm) {
//        Product product = convertToProduct(productForm);
//        productRepository.save(product);
//    }
//    private Product convertToProduct(ProductForm productForm) {
//        Product product = new Product();
//        // ProductForm에서 필요한 데이터 추출하여 Product 엔티티에 설정
//        product.setName(productForm.getProductName());
//        product.setAbv(productForm.getAbv());
//        product.setAroma(productForm.getAroma());
//        product.setFlavor(productForm.getFlavor());
//        product.setCost(productForm.getCost());
//        product.setInfo(productForm.getInfo());
//        product.setMainCategory(new MainCategory(productForm.getMainCategoryId()));
//        product.setSubCategory(new SubCategory(productForm.getSubCategoryId()));
//        product.setAbvRange(new ABVrange(productForm.getAbvRangeId()));
//        product.setNetWeight(new NetWeight(productForm.getNetWeightId()));
//        product.setPairings(productForm.getPairingIds());
//        product.setNation(new Nation(productForm.getNationId()));
//        product.setCasks(productForm.getCaskIds());
//
//        return product;
//    }

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