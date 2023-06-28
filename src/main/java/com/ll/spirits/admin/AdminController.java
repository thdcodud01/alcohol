package com.ll.spirits.admin;

import com.ll.spirits.DataNotFoundException;
import com.ll.spirits.product.Product;
import com.ll.spirits.product.ProductForm;
import com.ll.spirits.product.ProductService;
import com.ll.spirits.product.productEntity.abvRange.ABVrange;
import com.ll.spirits.product.productEntity.abvRange.ABVrangeRepository;
import com.ll.spirits.product.productEntity.abvRange.ABVrangeService;
import com.ll.spirits.product.productEntity.cask.Cask;
import com.ll.spirits.product.productEntity.cask.CaskService;
import com.ll.spirits.product.productEntity.costRange.CostRange;
import com.ll.spirits.product.productEntity.costRange.CostRangeRepository;
import com.ll.spirits.product.productEntity.costRange.CostRangeService;
import com.ll.spirits.product.productEntity.mainCategory.MainCategory;
import com.ll.spirits.product.productEntity.mainCategory.MainCategoryRepository;
import com.ll.spirits.product.productEntity.mainCategory.MainCategoryService;
import com.ll.spirits.product.productEntity.nation.Nation;
import com.ll.spirits.product.productEntity.nation.NationRepository;
import com.ll.spirits.product.productEntity.nation.NationService;
import com.ll.spirits.product.productEntity.netWeight.NetWeight;
import com.ll.spirits.product.productEntity.netWeight.NetWeightRepository;
import com.ll.spirits.product.productEntity.netWeight.NetWeightService;
import com.ll.spirits.product.productEntity.pairing.Pairing;
import com.ll.spirits.product.productEntity.pairing.PairingService;
import com.ll.spirits.product.productEntity.subCategory.SubCategory;
import com.ll.spirits.product.productEntity.subCategory.SubCategoryRepository;
import com.ll.spirits.product.productEntity.subCategory.SubCategoryService;
import com.ll.spirits.review.Review;
import com.ll.spirits.review.ReviewService;
import com.ll.spirits.user.SiteUser;
import com.ll.spirits.user.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/admin")
public class AdminController {
    private final ProductService productService;
    private final ReviewService reviewService;
    private final UserService userService;
    private final MainCategoryService mainCategoryService;
    private final SubCategoryService subCategoryService;
    private final CostRangeService costRangeService;
    private final ABVrangeService abVrangeService;
    private final CaskService caskService;
    private final NationService nationService;
    private final NetWeightService netWeightService;
    private final PairingService pairingService;
    private final MainCategoryRepository mainCategoryRepository;
    private final SubCategoryRepository subCategoryRepository;
    private final CostRangeRepository costRangeRepository;
    private final ABVrangeRepository abvRangeRepository;
    private final NetWeightRepository netWeightRepository;
    private final NationRepository nationRepository;

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/page")
    public String adminProductCreate(ProductForm productForm, Model model) {

        List<Product> productList = productService.getList();
        List<Review> reviewList = reviewService.getList();
        List<SiteUser> siteUserList = userService.getList();
        model.addAttribute("productList", productList);
        model.addAttribute("reviewList",reviewList);
        model.addAttribute("siteUserList", siteUserList);
        return "admin";
    }

//    @PreAuthorize("hasRole('ROLE_ADMIN')") // 관리자만 접근 가능하도록 설정 // 제품 등록 Post
//    @PostMapping("/admin") // post == 보내다
//    public String adminProductCreate(@Valid ProductForm productForm, BindingResult bindingResult, Principal principal, Integer mainCategoryId, Integer subCategoryId, Model model) {
//
//        List<Product> productList = productService.getProductsByMainCategoryIdAndSubCategoryId(mainCategoryId, subCategoryId);
//
//        model.addAttribute("productList", productList);
//
//        if (bindingResult.hasErrors()) {
//            return "redirect:/product/admin";
//        }
//        SiteUser siteUser = this.userService.getUser(principal.getName());
//        this.productService.createProduct(productForm, siteUser);
//        // 사진을 띄워야 하는데 여기 create 로직에서 처리할지 HTML 템플릿에서 처리할지 고민해봐야 함
//        // create(이 안에 get으로 가져오는 것들이 리스트 상에서 띄울 제품정보);
//        return "redirect:/product/admin"; // 제품 저장후 제품목록으로 이동
//    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("/product/create")
    public String getProductCreateForm(@ModelAttribute("productForm") ProductForm productForm, Model model) {
        List<Cask> caskList = caskService.getAllCask();
        List<Nation> nationList = nationService.getAllNation();
        List<Pairing> pairingList = pairingService.getAllPairing();
        List<ABVrange> abVrangeList = abVrangeService.getAllABVrange();
        List<CostRange> costRangeList = costRangeService.getAllCostRange();
        List<NetWeight> netWeightList = netWeightService.getAllNetWeight();
        List<SubCategory> subCategoryList = subCategoryService.getAllSubCategories();
        List<MainCategory> mainCategoryList = mainCategoryService.getAllMainCategories();

        model.addAttribute("caskList", caskList);
        model.addAttribute("nationList", nationList);
        model.addAttribute("pairingList", pairingList);
        model.addAttribute("abVrangeList", abVrangeList);
        model.addAttribute("costRangeList", costRangeList);
        model.addAttribute("netWeightList", netWeightList);
        model.addAttribute("mainCategoryList", mainCategoryList);
        model.addAttribute("subCategoryList", subCategoryList);

        return "product_form";
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PostMapping("/product/create")
    public String createProduct(@ModelAttribute("productForm") @Valid ProductForm productForm,
                                BindingResult bindingResult,
                                Principal principal,
                                @RequestParam("file1") MultipartFile file1,
                                @RequestParam("file2") MultipartFile file2) throws Exception {
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
//        System.out.println("파일이름: " + productForm.getFilename());
//        System.out.println("파일경로: " + productForm.getFilepath());



        if (bindingResult.hasErrors()) {
            System.out.println("유효성 검사 오류 발생");
            return "product_form";
        }
        SiteUser siteUser = this.userService.getUser(principal.getName());
        productService.createProduct(productForm, siteUser, file1, file2);

        System.out.println("제품 등록 완료");

        return "redirect:/";
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("/product/modify/{id}")
    public String productModify(ProductForm productForm, @PathVariable("id") Integer id, Principal principal, Model model) {
        // 제품 정보를 가져온다
        Product product = productService.getProduct(id);
        if (product == null) {
            // 제품이 존재하지 않을 경우, 에러 처리 또는 다른 동작 수행
            return "error_page";
        }

        // 필요한 데이터를 가져온다
        List<Cask> caskList = caskService.getAllCask();
        List<Nation> nationList = nationService.getAllNation();
        List<Pairing> pairingList = pairingService.getAllPairing();
        List<ABVrange> abVrangeList = abVrangeService.getAllABVrange();
        List<CostRange> costRangeList = costRangeService.getAllCostRange();
        List<NetWeight> netWeightList = netWeightService.getAllNetWeight();
        List<SubCategory> subCategoryList = subCategoryService.getAllSubCategories();
        List<MainCategory> mainCategoryList = mainCategoryService.getAllMainCategories();

        // 모델에 데이터를 추가한다
        model.addAttribute("productForm", product);
        model.addAttribute("caskList", caskList);
        model.addAttribute("nationList", nationList);
        model.addAttribute("pairingList", pairingList);
        model.addAttribute("abVrangeList", abVrangeList);
        model.addAttribute("costRangeList", costRangeList);
        model.addAttribute("netWeightList", netWeightList);
        model.addAttribute("mainCategoryList", mainCategoryList);
        model.addAttribute("subCategoryList", subCategoryList);

        return "product_form";
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PostMapping("/product/modify/{id}")
    public String productModify(@ModelAttribute("productForm") @Valid ProductForm productForm, BindingResult bindingResult,
                                 Principal principal, @PathVariable("id") Integer id) {
        Product product = productService.getProduct(id);
        System.out.println("제품 수정 정보 확인:");
        System.out.println("수정된 이름: " + productForm.getName());
        System.out.println("수정된 대분류: " + productForm.getMainCategoryId());
        System.out.println("수정된 중분류: " + productForm.getSubCategoryId());
        System.out.println("수정된 가격범위: " + productForm.getCostRangeId());
        System.out.println("수정된 도수범위: " + productForm.getAbvRangeId());
        System.out.println("수정된 용량: " + productForm.getNetWeightId());
        System.out.println("수정된 안주: " + productForm.getPairings());
        System.out.println("수정된 캐스크: " + productForm.getCasks());
        System.out.println("수정된 생산국: " + productForm.getNationId());
        if (bindingResult.hasErrors()) {
            System.out.println("유효성 검사 오류 발생");
            return "product_form";
        }
        SiteUser siteUser = this.userService.getUser(principal.getName());
        this.productService.modifyProduct(id, productForm, siteUser);

        System.out.println("제품 수정 완료");

        return String.format("redirect:/product/detail/%s", product.getId());
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')") // 관리자만 접근 가능하도록 설정
    @GetMapping("/delete/product/{id}") // 제품 삭제
    public String productDelete(Principal principal, @PathVariable("id") Integer id) {
        Product product = this.productService.getProduct(id);
        this.productService.delete(product);
        return "redirect:/admin/page";
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("/delete/review/{id}")
    public String reviewDelete(Principal principal, @PathVariable("id") Long id) {
        Review review = this.reviewService.getReview(id);
        this.reviewService.delete(review);
        return "redirect:/admin/page";
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("/delete/siteUser/{id}") // 사용자 삭제
    public String userDelete(Principal principal, @PathVariable("id") Long id ) {
        SiteUser user = this.userService.getUserId(id);
        this.userService.deleteUser(user);
        return "redirect:/admin/page";
    }

}
