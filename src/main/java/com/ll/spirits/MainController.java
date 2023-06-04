package com.ll.spirits;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
@Controller
public class MainController {
    @GetMapping("/")
    public String root () {
        return "redirect:/main"; // ROOT로 접근했을 때 페이지가 해당 주소로 리다이렉트 되게끔 리턴.
    }

    @GetMapping("/main")
    public String mainPage(Model model) {
        // 메인 페이지에 필요한 데이터를 가져와서 모델에 추가합니다.
        // 예를 들어, 인기 상품 목록, 최신 리뷰 등을 가져올 수 있습니다.
//        List<Product> popularProducts = productService.getPopularProducts();
//        List<Review> latestReviews = productService.getLatestReviews();
//
//        model.addAttribute("popularProducts", popularProducts);
//        model.addAttribute("latestReviews", latestReviews);
        return "main_page";
    }
}
