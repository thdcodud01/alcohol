package com.ll.spirits.admin;

import com.ll.spirits.product.Product;
import com.ll.spirits.product.ProductForm;
import com.ll.spirits.product.ProductService;
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
import com.ll.spirits.review.ReviewService;
import com.ll.spirits.user.SiteUser;
import com.ll.spirits.user.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
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
    @GetMapping("/product")
    public String adminProductCreate(ProductForm productForm, Model model) {

        List<Product> productList = productService.getList();
        List<Review> reviewList = reviewService.getList();
        List<SiteUser> siteUserList = userService.getList();
        model.addAttribute("productList", productList);
        model.addAttribute("reviewList",reviewList);
        model.addAttribute("siteUserList", siteUserList);
        return "admin";
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')") // 관리자만 접근 가능하도록 설정
    @GetMapping("/delete/product/{id}") // 제품 삭제
    public String productDelete(Principal principal, @PathVariable("id") Integer id) {
        Product product = this.productService.getProduct(id);
        this.productService.delete(product);
        return "redirect:/admin/product";
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("/delete/review/{id}")
    public String reviewDelete(Principal principal, @PathVariable("id") Long id) {
        Review review = this.reviewService.getReview(id);
        this.reviewService.delete(review);
        return String.format("redirect:/product/detail/%s", review.getProduct().getId());
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("/siteUser/delete/{id}") // 사용자 삭제
    public String userDelete(Principal principal, @PathVariable("id") Long id ) {
        SiteUser user = this.userService.getUser(id);
        this.userService.deleteUser(user);
        return "redirect:/admin/product";
    }

}
