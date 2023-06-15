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

        MainCategory mainCategory = mainCategoryService.getMainCategoryId(mainCategoryId);
        SubCategory subCategory = subCategoryService.getSubCategoryById(subCategoryId);


        model.addAttribute("caskList", caskList);
        model.addAttribute("nationList", nationList);
        model.addAttribute("pairingList", pairingList);
        model.addAttribute("abVrangeList", abVrangeList);
        model.addAttribute("costRangeList", costRangeList);
        model.addAttribute("netWeightList", netWeightList);
        model.addAttribute("subCategoryId", subCategoryId);
        model.addAttribute("mainCategoryId", mainCategoryId);
        model.addAttribute("subCategoryList", subCategoryList);
        model.addAttribute("mainCategoryList", mainCategoryList);
        model.addAttribute("productList", productList);
        model.addAttribute("mainCategory", mainCategory);
        model.addAttribute("subCategory", subCategory);
        model.addAttribute("subCategoryList", filteredSubCategoryList);

        return "product_form";
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PostMapping("/create")
    public String createProduct(@Valid @ModelAttribute("productForm") ProductForm productForm, BindingResult bindingResult,
                                Principal principal, Model model) {
        if (bindingResult.hasErrors()) {
            return getProductCreateForm(productForm, model, productForm.getMainCategoryId(), productForm.getSubCategoryId());
        }

//        MainCategory mainCategory = mainCategoryService.getMainCategory(principal.getName());
//        SubCategory subCategory = subCategoryService.getSubCategory(principal.getName());
//        CostRange costRange = costRangeService.getCostRange(principal.getName());
//        ABVrange abvRange = abvrangeService.getABVrange(principal.getName());
//        NetWeight netWeight = netWeightService.getNetWeight(principal.getName());
//        Nation nation = nationService.getNation(principal.getName());

        SiteUser siteUser = this.userService.getUser(principal.getName());
//        productService.createProduct(productForm);
//        productService.create(productForm.getProductName(), productForm.getAbv(), productForm.getAroma(),
//                productForm.getFlavor(), productForm.getInfo(), productForm.getCost(), siteUser, mainCategory, subCategory, costRange, abvRange, netWeight, nation);

        // Process Cask and Pairing information
        // You can modify the code below based on your specific implementation
        for (Integer caskId : productForm.getCaskIds()) {
            if (caskId != null) {
                Cask cask = caskService.getCaskById(caskId);
                // Add logic to associate the cask with the created product
                // Example: productService.addCaskToProduct(createdProductId, caskId);
            }
        }

        for (Integer pairingId : productForm.getPairingIds()) {
            if (pairingId != null) {
                Pairing pairing = pairingService.getPairingById(pairingId);
                // Add logic to associate the pairing with the created product
                // Example: productService.addPairingToProduct(createdProductId, pairingId);
            }
        }

        return "redirect:/product/list";
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
    @PreAuthorize("hasRole('ROLE_ADMIN')") // 관리자만 접근 가능하도록 설정 // 제품 등록 Post
    @PostMapping("/product") // post == 보내다
    public String adminProductCreate(@Valid ProductForm productForm, BindingResult bindingResult, Principal principal, Integer mainCategoryId, Integer subCategoryId, Model model) {

        List<Product> productList = productService.getProductsByMainCategoryIdAndSubCategoryId(mainCategoryId, subCategoryId);

        model.addAttribute("productList", productList);

        if (bindingResult.hasErrors()) {
            return "redirect:/admin/product";
        }
        SiteUser siteUser = this.userService.getUser(principal.getName());
        this.productService.create(productForm.getName(), productForm.getAbv(), productForm.getAroma(), productForm.getFlavor(), productForm.getInfo(), productForm.getCost(), siteUser);
        // 사진을 띄워야 하는데 여기 create 로직에서 처리할지 HTML 템플릿에서 처리할지 고민해봐야 함
        // create(이 안에 get으로 가져오는 것들이 리스트 상에서 띄울 제품정보);
        return "redirect:/admin/product"; // 제품 저장후 제품목록으로 이동
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
    @GetMapping("/delete/siteUser/{username}") // 사용자 삭제
    public String userDelete(Principal principal, @PathVariable("username") String username ) {
        SiteUser user = this.userService.getUser(username);
        this.userService.deleteUser(user);
        return "redirect:/admin/product";
    }

}
