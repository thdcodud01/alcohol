package com.ll.spirits.product;

import com.ll.spirits.DataNotFoundException;
import com.ll.spirits.review.Review;
import com.ll.spirits.review.ReviewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class ProductService {
    private final ProductRepository productRepository;
    private final ReviewRepository reviewRepository;

    public Product getProduct(Long id) {
        Optional<Product> product = productRepository.findById(id);
        if (product.isPresent()){
            return product.get();
        } else {
            throw new DataNotFoundException("product not found"); // 예외처리로 에러(DataNotFoundException)를 표시
        }
    }

    public List<Review> getReviewsByProduct(Product product) {
        return reviewRepository.findByProduct(product);
    }

}
