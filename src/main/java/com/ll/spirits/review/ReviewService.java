package com.ll.spirits.review;

import com.ll.spirits.DataNotFoundException;
import com.ll.spirits.product.Product;
import com.ll.spirits.user.SiteUser;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class ReviewService {
    private final ReviewRepository reviewRepository;

    public List<Review> getList () {
        return this.reviewRepository.findAll();
    }
    public Review create(Product product, String flavor, String aroma, String content, SiteUser author) {
        Review review = new Review();
        review.setFlavor(flavor);
        review.setAroma(aroma);
        review.setContent(content);
        review.setCreateDate(LocalDateTime.now());
        review.setProduct(product);
        review.setAuthor(author);
        this.reviewRepository.save(review);
        return review;
    }

    public Review getReview(Long id) {// Integer 로 타입이 들어오면 null 값도 허용해줄 수 있음
        Optional<Review> review = this.reviewRepository.findById(id);
        if (review.isPresent()) {
            return review.get();
        } else {
            throw new DataNotFoundException("review not found"); // 예외처리로 에러(DataNotFoundException)를 표시
        }
    }

    public void modify(Review review, String flavor, String aroma, String content) {
        review.setFlavor(flavor);
        review.setAroma(aroma);
        review.setContent(content);
        review.setModifyDate(LocalDateTime.now());
        this.reviewRepository.save(review);
    }

    public void delete(Review review) {
        this.reviewRepository.delete(review);
    }

}
