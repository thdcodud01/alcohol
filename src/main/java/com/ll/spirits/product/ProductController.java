package com.ll.spirits.product;

import com.ll.spirits.review.Review;
import com.ll.spirits.review.ReviewForm;
import com.ll.spirits.user.SiteUser;
import com.ll.spirits.user.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/product")
public class ProductController {
    private final ProductService productService;
    private final UserService userService;


    @GetMapping("/list")
    public String list(Model model, @RequestParam(value="page", defaultValue="1") int page, @RequestParam(value = "kw", defaultValue = "") String kw) { // url에 page내용이 없을땐 0값을 기본값으로 설정해라.
        List<Product> productList = this.productService.getList(); // 컨트롤러에서 바로 QuestionRepository 로 가던 구조를 중간에 Service 를 만들어서 거쳐가게끔 만듬.
        model.addAttribute("productList", productList);
        return "product_list"; // resources 예하 templates 예하 question_list HTML 파일로 인식해서 브라우저에 띄워줌
    }


    @PreAuthorize("isAuthenticated()")
    @GetMapping("/create")
    public String productCreate(ProductForm productForm) {
        return "product_form";
    }

    @PreAuthorize("isAuthenticated()")
    @PostMapping("/create") // post == 보내다
    public String productCreate(@Valid ProductForm productForm, BindingResult bindingResult, Principal principal) {
        // TODO 질문을 저장한다.
        // (주석으로 "TODO" 를 달아놓으면 인텔리제이에서 인지해서 만약 계획된 TODO 에 관련된 로직이 작성이 안되면 커밋할때 한 번더 물어봐준다)
        if (bindingResult.hasErrors()) {
            return "product_form";
        }
        SiteUser siteUser = this.userService.getUser(principal.getName());
        this.productService.create(productForm.getProductName(), productForm.getAbv(), productForm.getAroma(), productForm.getFlavor(), productForm.getInfo(), productForm.getCost(), siteUser);
        // 사진을 띄워야 하는데 여기 create 로직에서 처리할지 HTML 템플릿에서 처리할지 고민해봐야 함
        // create(이 안에 get으로 가져오는 것들이 리스트 상에서 띄울 제품정보);
        return "redirect:/product/list"; // 제품 저장후 제품목록으로 이동
    }

    @GetMapping("/detail/{id}")
    public String getProductDetail(@PathVariable Integer id, ReviewForm reviewForm, Model model, Principal principal) {
        Product product = this.productService.getProduct(id);
        List<Review> reviews = this.productService.getReviewsByProduct(product); // 리뷰부분 제대로 작동하지 않을 시 최우선으로 삭제 고려할 것
//        SiteUser siteUser = this.userService.getUser(principal.getName());
        model.addAttribute("product", product);
        model.addAttribute("reviews", reviews); // List로 불러온 리뷰들
//        model.addAttribute("siteUser", siteUser);

        return "product_detail"; // 템플릿 이름 또는 뷰의 경로를 반환
    }
}
