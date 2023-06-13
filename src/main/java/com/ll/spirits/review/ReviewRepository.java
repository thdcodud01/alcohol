package com.ll.spirits.review;

import com.ll.spirits.product.Product;
import com.ll.spirits.product.productEntity.mainCategory.MainCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {
    List<Review> findByProduct(Product product); // 리뷰부분 제대로 작동하지 않을 시 최우선으로 삭제 고려할 것
}