package com.ll.spirits.product;

import com.ll.spirits.product.dto.ProductDTO;
import com.ll.spirits.product.productEntity.abvRange.ABVrange;
import com.ll.spirits.product.productEntity.abvRange.ABVrangeService;
import com.ll.spirits.product.productEntity.cask.Cask;
import com.ll.spirits.product.productEntity.cask.CaskService;
import com.ll.spirits.product.productEntity.costRange.CostRange;
import com.ll.spirits.product.productEntity.costRange.CostRangeService;
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
import org.springframework.web.server.ResponseStatusException;

import java.security.Principal;
import java.util.List;


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


    @GetMapping("/list/{mainCategory}")
    public String listProductsByMainCategory(@PathVariable("mainCategory") String mainCategory,
                                             @RequestParam(value = "subCategoryId", required = false) Integer subCategoryId,
                                             @RequestParam(value = "costRangeId", required = false) Integer costRangeId,
                                             @RequestParam(value = "abvRangeId", required = false) Integer abvRangeId,
                                             @RequestParam(value = "netWeightRangeId", required = false) Integer netWeightRangeId,
                                             @RequestParam(value = "pairingIds", required = false) List<Integer> pairingIds, // GET /list/whiskey?pairingIds=1,2,3 클라이언트에서 이런식으로 요청가능
                                             @RequestParam(value = "caskIds", required = false) List<Integer> caskIds,
                                             @RequestParam(value = "nationId", required = false) Integer nationId,
                                             Model model) {

        List<ABVrange> abVrangeList = abVrangeService.getAllABVrange();
        List<Cask> caskList = caskService.getAllCask();
        List<CostRange> costRangeList = costRangeService.getAllCostRange();
        List<Nation> nationList = nationService.getAllNation();
        List<NetWeight> netWeightList = netWeightService.getAllNetWeight();
        List<Pairing> pairingList = pairingService.getAllPairing();
        List<SubCategory> subCategoryList = subCategoryService.getAllSubCategories();

        Integer mainCategoryId = mainCategoryService.getMainCategoryIdBymainCategory(mainCategory);

        ProductDTO productDTO = new ProductDTO();
        productDTO.setSubCategory(subCategoryId != null ? subCategoryService.getSubCategory(subCategoryId) : null);
        productDTO.setCostRange(costRangeId != null ? costRangeService.getCostRange(costRangeId) : null);
        productDTO.setAbvRange(abvRangeId != null ? abVrangeService.getABVrange(abvRangeId) : null);
        productDTO.setNetWeight(netWeightRangeId != null ? netWeightService.getNetWeight(netWeightRangeId) : null);
        productDTO.setPairings(pairingIds != null ? pairingService.getPairings(pairingIds) : null);
        productDTO.setCasks(caskIds != null ? caskService.getCasks(caskIds) : null);
        productDTO.setNation(nationId != null ? nationService.getNation(nationId) : null);

        List<Product> productDTOList = productService.getFilteredProductsByMainCategory(productDTO, mainCategoryId);
        model.addAttribute("productList", productDTOList);
        model.addAttribute("mainCategoryId", mainCategoryId);

        // 필터링된 상품 리스트 가져오기
        List<Product> productList;

        if (subCategoryId == null) {
            productList = productService.findByMainCategoryId(mainCategoryId);
        } else {
            productList = productService.findByMainCategoryIdAndSubCategoryId(mainCategoryId, subCategoryId);
        }

        if (costRangeId != null) {
            productList = productService.findByCostRangeId(costRangeId);
        } else if (abvRangeId != null) {
            productList = productService.findByABVrangeId(abvRangeId);
        } else if (netWeightRangeId != null) {
            productList = productService.findByNetWeightId(netWeightRangeId);
        } else if (pairingIds != null) {
            productList = productService.findByPairingsIdIn(pairingIds);
        } else if (caskIds != null) {
            productList = productService.findByCasksIdIn(caskIds);
        } else if (nationId != null) {
            productList = productService.findByNationId(nationId);
        } else {
            productList = productService.findByMainCategoryIdAndSubCategoryId(mainCategoryId, subCategoryId);
        }
        model.addAttribute("productList", productList);
        model.addAttribute("mainCategoryId", mainCategoryId);
        model.addAttribute("subCategoryId", subCategoryId);
        model.addAttribute("subCategoryList", subCategoryList);
        model.addAttribute("costRangeList", costRangeList);
        model.addAttribute("abVrangeList", abVrangeList);
        model.addAttribute("caskList", caskList);
        model.addAttribute("nationList", nationList);
        model.addAttribute("netWeightList", netWeightList);
        model.addAttribute("pairingList", pairingList);
        model.addAttribute("productList", productDTOList);

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
                templateName = "product_list_liqueur";
                break;
            default:
                templateName = "product_list";
                break;
        }

        return templateName;
    }

    @GetMapping
    @ResponseBody
    public List<Product> getFilteredProductsByMainCategory(@RequestParam(value = "mainCategoryId") Integer mainCategoryId,
                                                           @RequestParam(value = "subCategoryId", required = false) Integer subCategoryId,
                                                           @RequestParam(value = "costRangeId", required = false) Integer costRangeId,
                                                           @RequestParam(value = "abvRangeId", required = false) Integer abvRangeId,
                                                           @RequestParam(value = "netWeightRangeId", required = false) Integer netWeightRangeId,
                                                           @RequestParam(value = "pairingIds", required = false) List<Integer> pairingIds,
                                                           @RequestParam(value = "caskIds", required = false) List<Integer> caskIds,
                                                           @RequestParam(value = "nationId", required = false) Integer nationId) {
        ProductDTO productDTO = new ProductDTO();
        productDTO.setSubCategory(subCategoryId != null ? subCategoryService.getSubCategory(subCategoryId) : null);
        productDTO.setCostRange(costRangeId != null ? costRangeService.getCostRange(costRangeId) : null);
        productDTO.setAbvRange(abvRangeId != null ? abVrangeService.getABVrange(abvRangeId) : null);
        productDTO.setNetWeight(netWeightRangeId != null ? netWeightService.getNetWeight(netWeightRangeId) : null);
        productDTO.setPairings(pairingIds != null ? pairingService.getPairings(pairingIds) : null);
        productDTO.setCasks(caskIds != null ? caskService.getCasks(caskIds) : null);
        productDTO.setNation(nationId != null ? nationService.getNation(nationId) : null);

        return productService.getFilteredProductsByMainCategory(productDTO, mainCategoryId);
    }


    @PreAuthorize("isAuthenticated()") // 제품 등록 Get
    @GetMapping("/create")
    public String productCreate(ProductForm productForm) {
        return "product_form";
    }
    @PreAuthorize("isAuthenticated()") // 제품 등록 Post
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
    @GetMapping("/detail/{id}") // 제품 상세보기
    public String getProductDetail(@PathVariable Integer id, ReviewForm reviewForm, Model model, Principal principal) {
        Product product = this.productService.getProduct(id);
        List<Review> reviews = this.productService.getReviewsByProduct(product); // 리뷰부분 제대로 작동하지 않을 시 최우선으로 삭제 고려할 것
//        SiteUser siteUser = this.userService.getUser(principal.getName());
        model.addAttribute("product", product);
        model.addAttribute("reviews", reviews); // List로 불러온 리뷰들
//        model.addAttribute("siteUser", siteUser);

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
    @PreAuthorize("isAuthenticated()")
    @GetMapping("/delete/{id}") // 제품 삭제
    public String productDelete(Principal principal, @PathVariable("id") Integer id) {
        Product product = this.productService.getProduct(id);
        if (!product.getAuthor().getUserId().equals(principal.getName())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "삭제권한이 없습니다.");
        }
        this.productService.delete(product);
        return "redirect:/";
    }
}
