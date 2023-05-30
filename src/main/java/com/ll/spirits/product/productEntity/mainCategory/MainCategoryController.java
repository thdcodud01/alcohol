package com.ll.spirits.product.productEntity.mainCategory;

import com.ll.spirits.product.Product;
import com.ll.spirits.product.ProductService;
import com.ll.spirits.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/product")
public class MainCategoryController {
    private final ProductService productService;
    private final MainCategoryService mainCategoryService;
    private final UserService userService;

    @GetMapping("/{id}/products")
    public List<Product> getProductsByMainCategoryId(@PathVariable("id") Integer id) { // 카테고리별로 제품 리스트업 (2023-05-30)
        return mainCategoryService.getProductsByMainCategoryId(id);
    }

    @GetMapping("/list/whiskey") // 상품 리스트
    public String listWhiskey(Model model, @RequestParam(value = "page", defaultValue = "1") int page, @RequestParam(value = "kw", defaultValue = "") String kw) { // url에 page내용이 없을땐 0값을 기본값으로 설정해라.
        List<MainCategory> productList = this.mainCategoryService.getList(); // 컨트롤러에서 바로 QuestionRepository 로 가던 구조를 중간에 Service 를 만들어서 거쳐가게끔 만듬.
        model.addAttribute("productList", productList);
        return "product_list_whiskey"; // resources 예하 templates 예하 question_list HTML 파일로 인식해서 브라우저에 띄워줌
    }

    @GetMapping("/list/beer") // 상품 리스트
    public String listBeer(Model model, @RequestParam(value = "page", defaultValue = "1") int page, @RequestParam(value = "kw", defaultValue = "") String kw) { // url에 page내용이 없을땐 0값을 기본값으로 설정해라.
        List<MainCategory> productList = this.mainCategoryService.getList(); // 컨트롤러에서 바로 QuestionRepository 로 가던 구조를 중간에 Service 를 만들어서 거쳐가게끔 만듬.
        model.addAttribute("productList", productList);
        return "product_list_beer"; // resources 예하 templates 예하 question_list HTML 파일로 인식해서 브라우저에 띄워줌
    }

    @GetMapping("/list/gin") // 상품 리스트
    public String listGin(Model model, @RequestParam(value = "page", defaultValue = "1") int page, @RequestParam(value = "kw", defaultValue = "") String kw) { // url에 page내용이 없을땐 0값을 기본값으로 설정해라.
//        List<Product> productList = this.mainCategoryService.getMainCategoryList(4); // 컨트롤러에서 바로 QuestionRepository 로 가던 구조를 중간에 Service 를 만들어서 거쳐가게끔 만듬.
        List<MainCategory> productList = this.mainCategoryService.getList();
        model.addAttribute("productList", productList);
        return "product_list_gin"; // resources 예하 templates 예하 question_list HTML 파일로 인식해서 브라우저에 띄워줌
    }

    @GetMapping("/list/rum") // 상품 리스트
    public String listRum(Model model, @RequestParam(value = "page", defaultValue = "1") int page, @RequestParam(value = "kw", defaultValue = "") String kw) { // url에 page내용이 없을땐 0값을 기본값으로 설정해라.
        List<MainCategory> productList = this.mainCategoryService.getList(); // 컨트롤러에서 바로 QuestionRepository 로 가던 구조를 중간에 Service 를 만들어서 거쳐가게끔 만듬.
        model.addAttribute("productList", productList);
        return "product_list_rum"; // resources 예하 templates 예하 question_list HTML 파일로 인식해서 브라우저에 띄워줌
    }

    @GetMapping("/list/tequila") // 상품 리스트
    public String listTequila(Model model, @RequestParam(value = "page", defaultValue = "1") int page, @RequestParam(value = "kw", defaultValue = "") String kw) { // url에 page내용이 없을땐 0값을 기본값으로 설정해라.
        List<MainCategory> productList = this.mainCategoryService.getList(); // 컨트롤러에서 바로 QuestionRepository 로 가던 구조를 중간에 Service 를 만들어서 거쳐가게끔 만듬.
        model.addAttribute("productList", productList);
        return "product_list_tequila"; // resources 예하 templates 예하 question_list HTML 파일로 인식해서 브라우저에 띄워줌
    }

    @GetMapping("/list/vodka") // 상품 리스트
    public String listVodka(Model model, @RequestParam(value = "page", defaultValue = "1") int page, @RequestParam(value = "kw", defaultValue = "") String kw) { // url에 page내용이 없을땐 0값을 기본값으로 설정해라.
        List<MainCategory> productList = this.mainCategoryService.getList(); // 컨트롤러에서 바로 QuestionRepository 로 가던 구조를 중간에 Service 를 만들어서 거쳐가게끔 만듬.
        model.addAttribute("productList", productList);
        return "product_list_vodka"; // resources 예하 templates 예하 question_list HTML 파일로 인식해서 브라우저에 띄워줌
    }

    @GetMapping("/list/brandy") // 상품 리스트
    public String listBrandy(Model model, @RequestParam(value = "page", defaultValue = "1") int page, @RequestParam(value = "kw", defaultValue = "") String kw) { // url에 page내용이 없을땐 0값을 기본값으로 설정해라.
        List<MainCategory> productList = this.mainCategoryService.getList(); // 컨트롤러에서 바로 QuestionRepository 로 가던 구조를 중간에 Service 를 만들어서 거쳐가게끔 만듬.
        model.addAttribute("productList", productList);
        return "product_list_brandy"; // resources 예하 templates 예하 question_list HTML 파일로 인식해서 브라우저에 띄워줌
    }
}
