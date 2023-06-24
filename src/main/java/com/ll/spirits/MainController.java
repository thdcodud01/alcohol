package com.ll.spirits;


import com.ll.spirits.product.Product;
import com.ll.spirits.product.ProductService;
import com.ll.spirits.review.Review;
import com.ll.spirits.review.ReviewService;
import com.ll.spirits.user.SiteUser;
import com.ll.spirits.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.security.Principal;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class MainController {
    private final ProductService productService;


    @GetMapping("/")
    public String root () {
        return "redirect:/main"; // ROOT로 접근했을 때 페이지가 해당 주소로 리다이렉트 되게끔 리턴.
    }
    @GetMapping("/main")
    public String mainPage(Model model) {
        List<Product> voterProducts = productService.getTopVotedProducts(5); // 좋아요 수가 가장 많은 상위 5개 제품 가져오기
        model.addAttribute("voterProducts", voterProducts);

        return "main_page";
    }

}
