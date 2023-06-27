package com.ll.spirits.product;

import com.ll.spirits.product.productEntity.abvRange.ABVrange;
import com.ll.spirits.product.productEntity.abvRange.ABVrangeService;
import com.ll.spirits.product.productEntity.cask.Cask;
import com.ll.spirits.product.productEntity.cask.CaskService;
import com.ll.spirits.product.productEntity.costRange.CostRange;
import com.ll.spirits.product.productEntity.costRange.CostRangeService;
import com.ll.spirits.product.productEntity.mainCategory.MainCategory;
import com.ll.spirits.product.productEntity.mainCategory.MainCategoryRepository;
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
import jakarta.servlet.http.HttpServletRequest;
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
import org.springframework.web.servlet.ModelAndView;
import org.thymeleaf.model.IModel;

import java.security.Principal;
import java.text.DecimalFormat;
import java.util.*;
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
    private final ProductRepository productRepository;
    private final MainCategoryRepository mainCategoryRepository;

    @GetMapping("/list")
    public String listProductsByMainCategory(@RequestParam(value = "mainCategory", required = false) Integer mainCategory,
                                             @RequestParam(value = "kw", defaultValue = "") String kw,
                                             Model model) {
        // 대분류에 맞는 제품들을 조회하는 로직을 구현해야 합니다.
        List<Product> productList = productService.getProductsByMainCategory(mainCategory, kw);
        MainCategory mainCategoryName = mainCategoryService.getMainCategoryBymainCategoryId(mainCategory);

        // 기타 필요한 데이터를 조회하거나 처리하는 로직
        List<Cask> caskList = caskService.getAllCask();
        List<Nation> nationList = nationService.getAllNation();
        List<Pairing> pairingList = pairingService.getAllPairing();
        List<ABVrange> abVrangeList = abVrangeService.getAllABVrange();
        List<CostRange> costRangeList = costRangeService.getAllCostRange();
        List<NetWeight> netWeightList = netWeightService.getAllNetWeight();
        List<SubCategory> subCategoryList = subCategoryService.getAllSubCategories();
        List<MainCategory> mainCategoryList = mainCategoryService.getAllMainCategories();

        // 모델에 데이터를 추가합니다.
        model.addAttribute("caskList", caskList);
        model.addAttribute("nationList", nationList);
        model.addAttribute("pairingList", pairingList);
        model.addAttribute("productList", productList);
        model.addAttribute("abVrangeList", abVrangeList);
        model.addAttribute("netWeightList", netWeightList);
        model.addAttribute("costRangeList", costRangeList);
        model.addAttribute("mainCategoryList", mainCategoryList);
        model.addAttribute("subCategoryList", subCategoryList);
        model.addAttribute("searchKeyword", kw);
        model.addAttribute("mainCategory", mainCategoryName);
        model.addAttribute("mainCategoryId", mainCategory);

        return "product_list";
    }


    @GetMapping("/list/category")
    @ResponseBody
    public List<Product> getFilterProductList(@RequestParam(value = "subCategory", required = false) Integer subCategoryId,
                                              @RequestParam(value = "costRange", required = false) Integer costRangeId,
                                              @RequestParam(value = "abvRange", required = false) Integer abvRangeId,
                                              @RequestParam(value = "netWeight", required = false) Integer netWeightId,
                                              @RequestParam(value = "pairing", required = false) Integer pairingId,
                                              @RequestParam(value = "cask", required = false) Integer caskId,
                                              @RequestParam(value = "nation", required = false) Integer nationId,
                                              @RequestParam(value = "kw", required = false) String kw,
                                              Model model) {

        return productService.getFilteredProducts(
                subCategoryId,
                costRangeId,
                abvRangeId,
                netWeightId,
                pairingId,
                caskId,
                nationId,
                kw);
    }


    @GetMapping("/detail/{id}") // 제품 상세보기
    @Transactional
    public String getProductDetail(@PathVariable Integer id, ReviewForm reviewForm, Model model, Principal principal, HttpServletRequest request) {
        Product product = this.productService.getProduct(id);
        List<MainCategory> mainCategoryList = mainCategoryService.getAllMainCategories();
        model.addAttribute("mainCategoryList", mainCategoryList);

        // product.cost 값을 변수로 할당
        long cost = product.getCost();

        // 천 단위 구분 기호가 있는 형식으로 변환
        DecimalFormat decimalFormat = new DecimalFormat("###,###");
        String formattedCost = decimalFormat.format(cost);

        List<Cask> casks = product.getCasks(); // Product 엔티티에서 casks 필드를 가져옴
        List<Pairing> pairings = product.getPairings(); // Product 엔티티에서 pairings 필드를 가져옴

        // 캐스크값이 있는지 확인
        boolean hasCask = !casks.isEmpty();

        // cask_id 값을 추출하여 리스트에 저장
        List<Integer> caskIds = casks.stream().map(cask -> cask.getId()) // Cask 엔티티에서 cask_id 대신 id 필드를 사용
                .collect(Collectors.toList());

        List<Review> reviews = this.productService.getReviewsByProduct(product);
        if (principal != null) {
            SiteUser siteUser = this.userService.getUser(principal.getName());
            model.addAttribute("siteUser", siteUser);
        }
        model.addAttribute("product", product);
        model.addAttribute("reviews", reviews); // List로 불러온 리뷰들
        model.addAttribute("casks", casks);
        model.addAttribute("pairings", pairings);
        model.addAttribute("caskIds", caskIds);
        model.addAttribute("hasCask", hasCask); // 캐스크값의 존재 여부를 모델에 추가
        model.addAttribute("formattedCost", formattedCost); // 변환된 가격을 모델에 추가

        // 조회수 증가 처리(새로고침시 조회수 증가 X)
        String viewedProductId = (String) request.getSession().getAttribute("viewedProductId");
        if (viewedProductId == null || !viewedProductId.equals(String.valueOf(product.getId()))) {
            // 조회한 상품과 세션에 저장된 상품 ID가 다를 경우에만 조회수 증가
            product.setViews(product.getViews() + 1);
            this.productService.countingViews(product);
            request.getSession().setAttribute("viewedProductId", String.valueOf(product.getId()));
        }
        return "product_detail"; // 템플릿 이름 또는 뷰의 경로를 반환
    }



    @PreAuthorize("isAuthenticated()")
    @GetMapping("/wish/{id}") // 제품 찜하기
    public String productWish(Principal principal, @PathVariable("id") Integer id) {
        Product product = this.productService.getProduct(id);
        SiteUser siteUser = this.userService.getUser(principal.getName());
        boolean hasWished = product.getWish().contains(siteUser);
        if (hasWished) {
            this.productService.cancelWish(product, siteUser); // 찜 취소 기능
        } else {
            this.productService.wish(product, siteUser); // 찜 기능
        }
        return String.format("redirect:/product/detail/%s", id);
    }

    @PreAuthorize("isAuthenticated()")
    @GetMapping("/vote/{id}") // 제품 추천
    public String productVote(Principal principal, @PathVariable("id") Integer id) {
        Product product = this.productService.getProduct(id);
        SiteUser siteUser = this.userService.getUser(principal.getName());
        boolean hasVoted = product.getVoter().contains(siteUser);
        if (hasVoted) {
            this.productService.cancelVote(product, siteUser); // 추천 취소 기능
        } else {
            this.productService.vote(product, siteUser); // 추천 기능
        }
        return String.format("redirect:/product/detail/%s", id);
    }

}