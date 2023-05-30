package com.ll.spirits.product;

import com.ll.spirits.DataNotFoundException;
import com.ll.spirits.product.productEntity.mainCategory.MainCategory;
import com.ll.spirits.product.productEntity.mainCategory.MainCategoryRepository;
import com.ll.spirits.review.Review;
import com.ll.spirits.review.ReviewRepository;
import com.ll.spirits.user.SiteUser;
import com.sun.tools.javac.Main;
import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class ProductService {
    private final ProductRepository productRepository;
    private final ReviewRepository reviewRepository;


    public List<Product> getList() {
        return this.productRepository.findAll();
    }



    public List<Product> getWhiskeyList() { // 대분류 위스키 1번
        return productRepository.findByMainCategory(1);
    }

    public List<Product> getVodkaList() { // 대분류 2번
        return productRepository.findByMainCategory(2);
    }

    public List<Product> getTequilaList() { // 대분류 3번
        return productRepository.findByMainCategory(3);
    }

    public List<Product> getGinList() { // 대분류 4번
        return productRepository.findByMainCategory(4);
    }

    public List<Product> getRumList() { // 대분류 5번
        return productRepository.findByMainCategory(5);
    }

    public List<Product> getBrandyList() { // 대분류 6번
        return productRepository.findByMainCategory(6);
    }

    public List<Product> getBeerList() { // 대분류 7
        return productRepository.findByMainCategory(7);
    }
    public List<Product> getProductsByCategory(Integer mainCategoryId, Integer subCategoryId) { // 메인카테고리와 서브카테고리 같이 찾는 로직
        return this.productRepository.getProductsByMainCategoryAndSubCategory(mainCategoryId, subCategoryId);
    }
    public List<Product> getProductsBySubCategoryId(Integer subCategoryId) {
        // subCategoryId에 따른 상품 목록을 가져오는 로직
        List<Product> productList;

        // subCategoryId에 따라 상품 목록을 가져오는 로직
        if (subCategoryId == 1) {
            productList = productRepository.findBySubCategory(1);
        } else if (subCategoryId == 2) {
            productList = productRepository.findBySubCategory(2);
        } else if (subCategoryId == 3) {
            productList = productRepository.findBySubCategory(3);
        } else if (subCategoryId == 4) {
            productList = productRepository.findBySubCategory(4);
        } else if (subCategoryId == 5) {
            productList = productRepository.findBySubCategory(5);
        } else if (subCategoryId == 6) {
            productList = productRepository.findBySubCategory(6);
        } else if (subCategoryId == 7) {
            productList = productRepository.findBySubCategory(7);
        } else if (subCategoryId == 8) {
            productList = productRepository.findBySubCategory(8);
        } else if (subCategoryId == 9) {
            productList = productRepository.findBySubCategory(9);
        } else if (subCategoryId == 10) {
            productList = productRepository.findBySubCategory(10);
        } else if (subCategoryId == 11) {
            productList = productRepository.findBySubCategory(11);
        } else if (subCategoryId == 12) {
            productList = productRepository.findBySubCategory(12);
        } else if (subCategoryId == 13) {
            productList = productRepository.findBySubCategory(13);
        } else if (subCategoryId == 14) {
            productList = productRepository.findBySubCategory(14);
        } else if (subCategoryId == 15) {
            productList = productRepository.findBySubCategory(15);
        } else if (subCategoryId == 16) {
            productList = productRepository.findBySubCategory(16);
        } else if (subCategoryId == 17) {
            productList = productRepository.findBySubCategory(17);
        } else if (subCategoryId == 18) {
            productList = productRepository.findBySubCategory(18);
        } else if (subCategoryId == 19) {
            productList = productRepository.findBySubCategory(19);
        } else if (subCategoryId == 20) {
            productList = productRepository.findBySubCategory(20);
        } else if (subCategoryId == 21) {
            productList = productRepository.findBySubCategory(21);
        } else if (subCategoryId == 22) {
            productList = productRepository.findBySubCategory(22);
        } else if (subCategoryId == 23) {
            productList = productRepository.findBySubCategory(23);
        } else if (subCategoryId == 24) {
            productList = productRepository.findBySubCategory(24);
        } else if (subCategoryId == 25) {
            productList = productRepository.findBySubCategory(25);
        } else if (subCategoryId == 26) {
            productList = productRepository.findBySubCategory(26);
        } else if (subCategoryId == 27) {
            productList = productRepository.findBySubCategory(27);
        } else if (subCategoryId == 28) {
            productList = productRepository.findBySubCategory(28);
        } else if (subCategoryId == 29) {
            productList = productRepository.findBySubCategory(29);
        } else if (subCategoryId == 30) {
            productList = productRepository.findBySubCategory(30);
        } else if (subCategoryId == 31) {
            productList = productRepository.findBySubCategory(31);
        } else if (subCategoryId == 32) {
            productList = productRepository.findBySubCategory(32);
        } else if (subCategoryId == 33) {
            productList = productRepository.findBySubCategory(33);
        } else if (subCategoryId == 34) {
            productList = productRepository.findBySubCategory(34);
        } else if (subCategoryId == 35) {
            productList = productRepository.findBySubCategory(35);
        } else if (subCategoryId == 36) {
            productList = productRepository.findBySubCategory(36);
        } else {
            throw new DataNotFoundException("Invalid subCategoryId: " + subCategoryId);
        }

        return productList;

//        for (int i = 1; i <= 36; i++) {
//            if (subCategoryId == i) {
//                productList = productRepository.findBySubCategory(i);
//                break;
//            }
//        }
//
//        if (productList == null) {
//            throw new DataNotFoundException("Invalid subCategoryId: " + subCategoryId);
//        }
//
//        return productList;
    }

    public Product getProduct(Integer id) {
        Optional<Product> product = this.productRepository.findById(id);
        if (product.isPresent()){
            return product.get();
        } else {
            throw new DataNotFoundException("product not found"); // 예외처리로 에러(DataNotFoundException)를 표시
        }
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