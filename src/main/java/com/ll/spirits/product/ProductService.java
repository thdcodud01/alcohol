package com.ll.spirits.product;

import com.ll.spirits.DataNotFoundException;
import com.ll.spirits.review.Review;
import com.ll.spirits.review.ReviewRepository;
import com.ll.spirits.user.SiteUser;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class ProductService {
    private final ProductRepository productRepository;
    private final ReviewRepository reviewRepository;

    public List<Product> getList () {
        return this.productRepository.findAll();
    }

    public List<Product> getWhiskeyList() {
        return productRepository.findAllById(1);
    }

    public List<Product> getVodcaList() {
        return productRepository.findAllById(2);
    }

    public List<Product> getTequilaList() {
        return productRepository.findAllById(3);
    }

    public List<Product> getGinList() {
        return productRepository.findAllById(4);
    }

    public List<Product> getRumList() {
        return productRepository.findAllById(5);
    }

    public List<Product> getBrandyList() {
        return productRepository.findAllById(6);
    }

    public List<Product> getBeerList() {
        return productRepository.findAllById(7);
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
