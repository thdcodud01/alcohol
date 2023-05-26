package com.ll.spirits.product;

import com.ll.spirits.review.Review;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/product")
public class ProductController {
    private final ProductService productService;
    //private final UserService userService;

    @PreAuthorize("isAuthenticated()")
    @GetMapping("/create")
    public String productCreate(ProductForm productForm) {
        return "product_form";
    }

    @GetMapping("/detail/{productId}")
    public String getProductDetail(@PathVariable Long productId, Model model) {
        Product product = productService.getProductById(productId);
        List<Review> reviews = productService.getReviewsByProduct(product);

        model.addAttribute("product", product);
        model.addAttribute("reviews", reviews); // List로 불러온 리뷰들

        return "product_detail"; // 템플릿 이름 또는 뷰의 경로를 반환
    }


}
