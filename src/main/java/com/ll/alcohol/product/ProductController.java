package com.ll.alcohol.product;

import com.ll.alcohol.user.SiteUser;
import com.ll.alcohol.user.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
@Controller
@RequiredArgsConstructor
@RequestMapping("/product")
public class ProductController {
    //private final ProductService productService;
    //private final UserService userService;

    @PreAuthorize("isAuthenticated()")
    @GetMapping("/create")
    public String productCreate(ProductForm productForm) {
        return "product_form";
    }


}
