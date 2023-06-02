package com.ll.spirits.product.productEntity.subCategory;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class SubCategoryController {

    private final SubCategoryService subCategoryService;

    @GetMapping("/subcategories")
    public String listProductsBySubCategory(Model model) {
        List<SubCategory> subCategoryList = subCategoryService.getAllSubCategories();
        model.addAttribute("subCategoryList", subCategoryList);
        return "product_list_whiskey";
    }
}
