package com.ll.spirits.review;

import com.ll.spirits.product.Product;
import com.ll.spirits.user.SiteUser;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

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

}
