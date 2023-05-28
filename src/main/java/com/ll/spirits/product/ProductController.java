package com.ll.spirits.product;

import com.ll.spirits.review.Review;
import com.ll.spirits.review.ReviewForm;
import com.ll.spirits.user.SiteUser;
import com.ll.spirits.user.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
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



    @GetMapping("/list") // 상품 리스트
    public String list(Model model, @RequestParam(value = "page", defaultValue = "1") int page, @RequestParam(value = "kw", defaultValue = "") String kw) { // url에 page내용이 없을땐 0값을 기본값으로 설정해라.
        List<Product> productList = this.productService.getList(); // 컨트롤러에서 바로 QuestionRepository 로 가던 구조를 중간에 Service 를 만들어서 거쳐가게끔 만듬.
        model.addAttribute("productList", productList);
        return "product_list"; // resources 예하 templates 예하 question_list HTML 파일로 인식해서 브라우저에 띄워줌
    }

    @GetMapping("/list/{mainCategoryId}")
    public String listProducts(Model model, @PathVariable("mainCategoryId") Integer mainCategoryId, @RequestParam(value = "kw", defaultValue = "") String kw) {
        List<Product> productList;

        // 상품 종류에 따라 productList를 가져오는 로직
        if (mainCategoryId == 1) {
            productList = this.productService.getWhiskeyList();
        } else if (mainCategoryId == 2) {
            productList = this.productService.getVodcaList();
        } else if (mainCategoryId == 3) {
            productList = this.productService.getTequilaList();
        } else if (mainCategoryId == 4) {
            productList = this.productService.getGinList();
        } else if (mainCategoryId == 5) {
            productList = this.productService.getRumList();
        } else if (mainCategoryId == 6) {
            productList = this.productService.getBrandyList();
        } else if (mainCategoryId == 7) {
            productList = this.productService.getBeerList();
        } else {
            // 상품 종류가 잘못된 경우에 대한 예외 처리
            return "error";
        }

        model.addAttribute("productList", productList);
        return "product_list";
    }

    @GetMapping("/list/{mainCategoryId}/{subCategoryId}")
    public String listProductsByCategory(Model model, @PathVariable("mainCategoryId") Integer mainCategoryId, @PathVariable("subCategoryId") Integer subCategoryId, @RequestParam(value = "kw", defaultValue = "") String kw) {
        List<Product> productList = productService.getProductsByCategory(mainCategoryId, subCategoryId);
        model.addAttribute("productList", productList);

        // 서브 카테고리에 따라 productList를 가져오는 로직
        if (mainCategoryId == 1) {
            if (subCategoryId == 1) {
                productList = productService.getProductsBySubCategoryId(1); // whiskey(single molt)
            } else if (subCategoryId == 2) {
                productList = productService.getProductsBySubCategoryId(2); // whiskey(singlegrain)
            } else if (subCategoryId == 3) {
                productList = productService.getProductsBySubCategoryId(3); // whiskey(blended molt)
            } else if (subCategoryId == 4) {
                productList = productService.getProductsBySubCategoryId(4); // whiskey(blended)
            } else if (subCategoryId == 5) {
                productList = productService.getProductsBySubCategoryId(5); // whiskey(burbun)
            } else if (subCategoryId == 6) {
                productList = productService.getProductsBySubCategoryId(6); // whiskey(tenesi)
            } else if (subCategoryId == 7) {
                productList = productService.getProductsBySubCategoryId(7); // whiskey(etc)
            } else {
                return "error";
            }
        } else if (mainCategoryId == 2) {
            if (subCategoryId == 8) {
                productList = productService.getProductsBySubCategoryId(1); // vodka(normal)
            } else if (subCategoryId == 9) {
                productList = productService.getProductsBySubCategoryId(2); // vodca(play bird),
            } else if (subCategoryId == 10) {
                productList = productService.getProductsBySubCategoryId(3); // vodca(etc)
            } else {
                return "error";
            }
        } else if (mainCategoryId == 3) {
            if (subCategoryId == 11) {
                productList = productService.getProductsBySubCategoryId(1); // tequila(mezcal)
            } else if (subCategoryId == 12) {
                productList = productService.getProductsBySubCategoryId(2); // tequila(blanco)
            } else if (subCategoryId == 13) {
                productList = productService.getProductsBySubCategoryId(3); // tequila(reposedo)
            } else if (subCategoryId == 14) {
                productList = productService.getProductsBySubCategoryId(4); // tequila(ancho)
            } else if (subCategoryId == 15) {
                productList = productService.getProductsBySubCategoryId(5); // tequila(etc)
            } else {
                return "error";
            }
        } else if (mainCategoryId == 4) {
            if (subCategoryId == 16) {
                productList = productService.getProductsBySubCategoryId(1); // gin(juniver)
            } else if (subCategoryId == 17) {
                productList = productService.getProductsBySubCategoryId(2); // gin(oldTom)
            } else if (subCategoryId == 18) {
                productList = productService.getProductsBySubCategoryId(3); // gin(londonDry)
            } else if (subCategoryId == 19) {
                productList = productService.getProductsBySubCategoryId(4); // gin(navyStrenth)
            } else if (subCategoryId == 20) {
                productList = productService.getProductsBySubCategoryId(5); // gin(slo)
            } else if (subCategoryId == 21) {
                productList = productService.getProductsBySubCategoryId(6); // gin(craft)
            } else if (subCategoryId == 22) {
                productList = productService.getProductsBySubCategoryId(7); // gin(etc)
            } else {
                return "error";
            }
        } else if (mainCategoryId == 5) {
            if (subCategoryId == 23) {
                productList = productService.getProductsBySubCategoryId(1); // rum(white)
            } else if (subCategoryId == 24) {
                productList = productService.getProductsBySubCategoryId(2); // rum(gold)
            } else if (subCategoryId == 25) {
                productList = productService.getProductsBySubCategoryId(3); // rum(dark)
            } else if (subCategoryId == 26) {
                productList = productService.getProductsBySubCategoryId(4); // rum(overproof)
            } else if (subCategoryId == 27) {
                productList = productService.getProductsBySubCategoryId(5); // rum(etc)
            } else {
                return "error";
            }
        } else if (mainCategoryId == 6) {
            if (subCategoryId == 28) {
                productList = productService.getProductsBySubCategoryId(1); // brandy(konaic)
            } else if (subCategoryId == 29) {
                productList = productService.getProductsBySubCategoryId(2); // brandy(armaniac)
            } else if (subCategoryId == 30) {
                productList = productService.getProductsBySubCategoryId(3); // brandy(kalbados)
            } else if (subCategoryId == 31) {
                productList = productService.getProductsBySubCategoryId(4); // brandy(etc)
            } else {
                return "error";
            }
        } else if (mainCategoryId == 7) {
            if (subCategoryId == 32) {
                productList = productService.getProductsBySubCategoryId(1); // beer(lager)
            } else if (subCategoryId == 33) {
                productList = productService.getProductsBySubCategoryId(2); // beer(yeil)
            } else if (subCategoryId == 34) {
                productList = productService.getProductsBySubCategoryId(3); // beer(meal)
            } else if (subCategoryId == 35) {
                productList = productService.getProductsBySubCategoryId(4); // beer(dark)
            } else if (subCategoryId == 36) {
                productList = productService.getProductsBySubCategoryId(5); // beer(etc)
            } else {
                return "error";
            }
        } else
            // 메인 카테고리가 잘못된 경우에 대한 예외 처리
            return "error";

        model.addAttribute("productList", productList);
        return "product_list";
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

    @PreAuthorize("isAuthenticated()")
    @GetMapping("/vote/{id}")
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
    @GetMapping("/wish/{id}")
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
    @GetMapping("/delete/{id}")
    public String productDelete(Principal principal, @PathVariable("id") Integer id) {
        Product product = this.productService.getProduct(id);
        if (!product.getAuthor().getUserId().equals(principal.getName())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "삭제권한이 없습니다.");
        }
        this.productService.delete(product);
        return "redirect:/";
    }
}
