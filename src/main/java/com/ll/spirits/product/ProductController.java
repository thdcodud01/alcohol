package com.ll.spirits.product;

import com.ll.spirits.product.productEntity.abvRange.ABVrange;
import com.ll.spirits.product.productEntity.abvRange.ABVrangeService;
import com.ll.spirits.product.productEntity.cask.Cask;
import com.ll.spirits.product.productEntity.cask.CaskService;
import com.ll.spirits.product.productEntity.costRange.CostRange;
import com.ll.spirits.product.productEntity.costRange.CostRangeService;
import com.ll.spirits.product.productEntity.mainCategory.MainCategory;
import com.ll.spirits.product.productEntity.mainCategory.MainCategoryService;
import com.ll.spirits.product.productEntity.nation.Nation;
import com.ll.spirits.product.productEntity.nation.NationService;
import com.ll.spirits.product.productEntity.netWeight.NetWeight;
import com.ll.spirits.product.productEntity.netWeight.NetWeightService;
import com.ll.spirits.product.productEntity.pairing.Pairing;
import com.ll.spirits.product.productEntity.pairing.PairingService;
import com.ll.spirits.product.productEntity.subCategory.SubCategory;
import com.ll.spirits.product.productEntity.subCategory.SubCategoryService;
import com.ll.spirits.review.Review;
import com.ll.spirits.review.ReviewForm;
import com.ll.spirits.review.ReviewService;
import com.ll.spirits.user.SiteUser;
import com.ll.spirits.user.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.thymeleaf.model.IModel;

import java.security.Principal;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Controller
@RequiredArgsConstructor
@RequestMapping("/product")
public class ProductController {
    private final ProductService productService;
    private final UserService userService;
    private final MainCategoryService mainCategoryService;
    private final SubCategoryService subCategoryService;
    private final CostRangeService costRangeService;
    private final ABVrangeService abVrangeService;
    private final CaskService caskService;
    private final NationService nationService;
    private final NetWeightService netWeightService;
    private final PairingService pairingService;
    private final ReviewService reviewService;

    @GetMapping("/list/{mainCategory}")
    public String listProductsByMainCategory(@PathVariable("mainCategory") String mainCategory,
                                             @RequestParam(value = "subCategoryId", required = false) Integer subCategoryId,
                                             Model model) {

        List<Cask> caskList = caskService.getAllCask();
        List<Nation> nationList = nationService.getAllNation();
        List<Pairing> pairingList = pairingService.getAllPairing();
        List<ABVrange> abVrangeList = abVrangeService.getAllABVrange();
        List<CostRange> costRangeList = costRangeService.getAllCostRange();
        List<NetWeight> netWeightList = netWeightService.getAllNetWeight();
        List<SubCategory> subCategoryList = subCategoryService.getAllSubCategories();

        Integer mainCategoryId = mainCategoryService.getMainCategoryIdBymainCategory(mainCategory);

        List<Product> productList;
        // 서브카테고리가 null이거나 0인 경우
        if (subCategoryId == null) {
            // 서브카테고리가 지정되지 않은 경우, 대분류에 해당하는 모든 제품을 가져옴
            productList = productService.getProductsByMainCategoryId(mainCategoryId);
        } else {
            // 서브카테고리가 지정된 경우, 대분류와 중분류에 해당하는 제품을 가져옴
            productList = productService.getProductsByMainCategoryIdAndSubCategoryId(mainCategoryId, subCategoryId);
        }
        model.addAttribute("caskList", caskList);
        model.addAttribute("nationList", nationList);
        model.addAttribute("pairingList", pairingList);
        model.addAttribute("productList", productList);
        model.addAttribute("abVrangeList", abVrangeList);
        model.addAttribute("netWeightList", netWeightList);
        model.addAttribute("subCategoryId", subCategoryId);
        model.addAttribute("costRangeList", costRangeList);
        model.addAttribute("mainCategoryId", mainCategoryId);
        model.addAttribute("subCategoryList", subCategoryList);

        String templateName;
        switch (mainCategoryId) {
            case 1:
                templateName = "product_list_whiskey";
                break;
            case 2:
                templateName = "product_list_vodka";
                break;
            case 3:
                templateName = "product_list_tequila";
                break;
            case 4:
                templateName = "product_list_gin";
                break;
            case 5:
                templateName = "product_list_rum";
                break;
            case 6:
                templateName = "product_list_brandy";
                break;
            case 7:
                templateName = "product_list_beer";
                break;
            default:
                templateName = "error";
        }
        return templateName;
    }
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("/create")
    public String getProductCreateForm(@ModelAttribute("productForm") ProductForm productForm, Model model,
                                       Integer mainCategoryId, Integer subCategoryId) {
        List<Cask> caskList = caskService.getAllCask();
        List<Nation> nationList = nationService.getAllNation();
        List<Pairing> pairingList = pairingService.getAllPairing();
        List<ABVrange> abVrangeList = abVrangeService.getAllABVrange();
        List<CostRange> costRangeList = costRangeService.getAllCostRange();
        List<NetWeight> netWeightList = netWeightService.getAllNetWeight();
        List<SubCategory> subCategoryList = subCategoryService.getAllSubCategories();
        List<MainCategory> mainCategoryList = mainCategoryService.getAllMainCategories();

        List<Product> productList = productService.getProductsByMainCategoryIdAndSubCategoryId(mainCategoryId, subCategoryId);
        List<SubCategory> filteredSubCategoryList = subCategoryService.getSubCategoriesByMainCategoryId(mainCategoryId);

        model.addAttribute("caskList", caskList);
        model.addAttribute("nationList", nationList);
        model.addAttribute("pairingList", pairingList);
        model.addAttribute("abVrangeList", abVrangeList);
        model.addAttribute("costRangeList", costRangeList);
        model.addAttribute("netWeightList", netWeightList);
        model.addAttribute("subCategoryId", subCategoryId);
        model.addAttribute("mainCategoryId", mainCategoryId);
        model.addAttribute("mainCategoryList", mainCategoryList);
        model.addAttribute("subCategoryList", subCategoryList);
        model.addAttribute("productList", productList);
        model.addAttribute("filteredSubCategoryList", filteredSubCategoryList);

        return "product_form";
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PostMapping("/create")
    public String createProduct(@ModelAttribute("productForm") @Valid ProductForm productForm, BindingResult bindingResult, Principal principal) {
        System.out.println("제품 정보 확인:");
        System.out.println("이름: " + productForm.getName());
        System.out.println("대분류: " + productForm.getMainCategoryId());
        System.out.println("중분류: " + productForm.getSubCategoryId());
        System.out.println("가격범위: " + productForm.getCostRangeId());
        System.out.println("도수범위: " + productForm.getAbvRangeId());
        System.out.println("용량: " + productForm.getNetWeightId());
        System.out.println("안주: " + productForm.getPairings());
        System.out.println("캐스크: " + productForm.getCasks());
        System.out.println("생산국: " + productForm.getNationId());



        if (bindingResult.hasErrors()) {
            System.out.println("유효성 검사 오류 발생");
            return "product_form";
        }

        SiteUser siteUser = this.userService.getUser(principal.getName());
        productService.createProduct(productForm, siteUser);

        System.out.println("제품 등록 완료");

        return "redirect:/";
    }


    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("/admin")
    public String adminProductCreate(ProductForm productForm, Model model) {

        List<Product> productList = productService.getList();
        List<Review> reviewList = reviewService.getList();
        List<SiteUser> siteUserList = userService.getList();
        model.addAttribute("productList", productList);
        model.addAttribute("reviewList",reviewList);
        model.addAttribute("siteUserList", siteUserList);
        return "admin";
    }
    @PreAuthorize("hasRole('ROLE_ADMIN')") // 관리자만 접근 가능하도록 설정 // 제품 등록 Post
    @PostMapping("/admin") // post == 보내다
    public String adminProductCreate(@Valid ProductForm productForm, BindingResult bindingResult, Principal principal, Integer mainCategoryId, Integer subCategoryId, Model model) {

        List<Product> productList = productService.getProductsByMainCategoryIdAndSubCategoryId(mainCategoryId, subCategoryId);

        model.addAttribute("productList", productList);

        if (bindingResult.hasErrors()) {
            return "redirect:/product/admin";
        }
        SiteUser siteUser = this.userService.getUser(principal.getName());
        this.productService.createProduct(productForm, siteUser);
        // 사진을 띄워야 하는데 여기 create 로직에서 처리할지 HTML 템플릿에서 처리할지 고민해봐야 함
        // create(이 안에 get으로 가져오는 것들이 리스트 상에서 띄울 제품정보);
        return "redirect:/product/admin"; // 제품 저장후 제품목록으로 이동
    }


    @GetMapping("/detail/{id}") // 제품 상세보기
    @Transactional
    public String getProductDetail(@PathVariable Integer id, ReviewForm reviewForm, Model model, Principal principal) {
        Product product = this.productService.getProduct(id);
        List<Cask> casks = product.getCasks(); // Product 엔티티에서 casks 필드를 가져옴
        List<Pairing> pairings = product.getPairings(); // Product 엔티티에서 pairings 필드를 가져옴

        // cask_id 값을 추출하여 리스트에 저장
        List<Integer> caskIds = casks.stream()
                .map(cask -> cask.getId()) // Cask 엔티티에서 cask_id 대신 id 필드를 사용
                .collect(Collectors.toList());

        List<Review> reviews = this.productService.getReviewsByProduct(product); // 리뷰부분 제대로 작동하지 않을 시 최우선으로 삭제 고려할 것
        if (principal != null) {
            SiteUser siteUser = this.userService.getUser(principal.getName());
            model.addAttribute("siteUser", siteUser);
        }
        model.addAttribute("product", product);
        model.addAttribute("reviews", reviews); // List로 불러온 리뷰들
        model.addAttribute("casks", casks);
        model.addAttribute("pairings", pairings);
        model.addAttribute("caskIds", caskIds);
        return "product_detail"; // 템플릿 이름 또는 뷰의 경로를 반환
    }
    @PreAuthorize("isAuthenticated()")
    @GetMapping("/vote/{id}") // 제품 추천
    public String productVote(Principal principal, @PathVariable("id") Integer id) {
        Product product = this.productService.getProduct(id);
        SiteUser siteUser = this.userService.getUser(principal.getName());
        if (product.getVoter().contains(siteUser)) {
            this.productService.cancelVote(product, siteUser); // 추천 취소 기능
        } else {
            this.productService.vote(product, siteUser); // 추천 기능
        }
        return String.format("redirect:/product/detail/%s", id);
    }
    @PreAuthorize("isAuthenticated()")
    @GetMapping("/wish/{id}") // 제품 찜하기
    public String productWish(Principal principal, @PathVariable("id") Integer id) {
        Product product = this.productService.getProduct(id);
        SiteUser siteUser = this.userService.getUser(principal.getName());
        if (product.getVoter().contains(siteUser)) {
            this.productService.cancleWish(product, siteUser); // 찜 취소 기능
        } else {
            this.productService.wish(product, siteUser); // 찜 기능
        }
        return String.format("redirect:/product/detail/%s", id);
    }

//    @PreAuthorize("hasRole('ROLE_ADMIN')")
//    @GetMapping("/modify/{id}")
//    public String productModify(ProductForm productForm, @PathVariable("id") Integer id, Principal principal) {
//        Product product = this.productService.getProduct(id);
//        if(!product.getAuthor().getUsername().equals(principal.getName())) {
//            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "수정권한이 없습니다.");
//        }
//        productForm.setSubject(product.getSubject());
//        productForm.setContent(product.getContent());
//        return "question_form";
//    }
//
//    @PreAuthorize("hasRole('ROLE_ADMIN')")
//    @PostMapping("/modify/{id}")
//    public String productModify(@Valid QuestionForm questionForm, BindingResult bindingResult,
//                                 Principal principal, @PathVariable("id") Integer id) {
//        if (bindingResult.hasErrors()) {
//            return "question_form";
//        }
//        Question question = this.questionService.getQuestion(id);
//        if (!question.getAuthor().getUsername().equals(principal.getName())) {
//            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "수정권한이 없습니다.");
//        }
//        this.questionService.modify(question, questionForm.getSubject(), questionForm.getContent());
//        return String.format("redirect:/question/detail/%s", id);
//    }
}