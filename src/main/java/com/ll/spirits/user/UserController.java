package com.ll.spirits.user;

import com.ll.spirits.product.Product;
import com.ll.spirits.product.ProductService;
import com.ll.spirits.review.Review;
import com.ll.spirits.review.ReviewService;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.context.HttpSessionSecurityContextRepository;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;

import java.security.Principal;
import java.util.List;
import java.util.Set;


@RequiredArgsConstructor
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private final UserService userService;
    private final PasswordEncoder passwordEncoder;
    private final UserSecurityService userSecurityService;
    private final UserRepository userRepository;
    private final ReviewService reviewService;
    private final ProductService productService;

    @GetMapping("/signup")
    public String signup(UserCreateForm userCreateForm) {
        return "signup_form";
    }

    @PostMapping("/signup")
    public String signup(@Valid UserCreateForm userCreateForm, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "signup_form";
        }
        if (!userCreateForm.getPassword1().equals(userCreateForm.getPassword2())) {
            bindingResult.rejectValue("password1", "passwordIncorrect", "2개의 패스워드가 일치하지 않습니다.");
            return "signup_form";
        }

        try {
            UserRole role = userCreateForm.getUsername().startsWith("admin") ? UserRole.ADMIN : UserRole.USER;

            userService.create(userCreateForm.getUsername(), userCreateForm.getPassword1(), userCreateForm.getNickname(), userCreateForm.getBirthDate(), userCreateForm.getMailKey(), role);
        } catch (DataIntegrityViolationException e) {
            e.printStackTrace();
            bindingResult.reject("signupFailed", "이미 등록된 아이디입니다.");
            return "signup_form";
        } catch (Exception e) {
            e.printStackTrace();
            bindingResult.reject("signupFailed", e.getMessage());
            return "signup_form";
        }

        return "redirect:/";
    }

    @GetMapping("/checkDuplicate")
    @ResponseBody
    public boolean checkDuplicateNickname(@RequestParam("nickname") String nickname) {
        boolean isDuplicate = userService.isNicknameDuplicate(nickname);

        return isDuplicate;
    }
    @GetMapping("/mypage")
    public String myPage(Model model, Principal principal, Integer id) {
        SiteUser user = userService.getUser(principal.getName());
        List<Review> reviewList = reviewService.getReviewsByAuthor(user);
        List<Product> voterProducts = productService.getProductsByVoter(user);
        List<Product> wishProducts = productService.getProductsByWish(user);
        model.addAttribute("voterProducts", voterProducts);
        model.addAttribute("wishProducts", wishProducts);
        model.addAttribute("userName", user.getUsername());
        model.addAttribute("userNickName", user.getNickname());
        model.addAttribute("userBirthDate", user.getBirthDate());
        model.addAttribute("userBirthDate", user.getBirthDate());
        model.addAttribute("userImg", user.getProfileFilepath());

        System.out.println(reviewList.toString());
        return "mypage";
    }
    @PreAuthorize("isAuthenticated()")
    @PostMapping("/modifyPassword")
    public String modifyPassword(UserModifyForm userModifyForm, BindingResult bindingResult, Principal principal) {
        SiteUser siteUser = this.userService.getUser(principal.getName());
        if (bindingResult.hasErrors()) {
            return "mypage";
        }

        SiteUser user = this.userService.getUser(principal.getName());
        if (!userService.confirmPassword(userModifyForm.getPresentPW(), user)) {
            bindingResult.rejectValue("presentPW", "passwordInCorrect",
                    "현재 비밀번호를 바르게 입력해주세요.");
            return "mypage";
        }

        // 비밀번호와 비밀번호 확인에 입력한 문자열이 서로 다르면 다시 입력 하도록
        if (!userModifyForm.getNewPW().equals(userModifyForm.getNewPW2())) {
            bindingResult.rejectValue("newPW2", "passwordInCorrect",
                    "입력한 비밀번호가 일치하지 않습니다.");
            return "mypage";
        }

        userService.modifyPassword(userModifyForm.getNewPW(), user);

        return "redirect:/user/logout";
    }
    @PreAuthorize("isAuthenticated()")
    @PostMapping("/updateprofile")
    public String updateProfileImg(BindingResult bindingResult,
                                   Principal principal,
                                   @RequestParam("file") MultipartFile file) throws Exception{
        SiteUser siteUser = this.userService.getUser(principal.getName());
        if (bindingResult.hasErrors()) {
            return "mypage";
        }
        userService.updateProfile(siteUser, file);

        return "mypage";
    }
    @GetMapping("/login")
    public String login() {

        return "login_form";
    }

    @PostMapping("/login")
    public String login(@RequestParam("username") String username, @RequestParam("password") String password, HttpSession session, Model model) {

        if ("admin@gmail.com".equals(username) && "123".equals(password)) {
            UserDetails userDetails = userSecurityService.loadUserByUsername(username);
            Authentication authentication = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
            SecurityContextHolder.getContext().setAuthentication(authentication);

            session.setAttribute(HttpSessionSecurityContextRepository.SPRING_SECURITY_CONTEXT_KEY, SecurityContextHolder.getContext());

            return "redirect:/";
        } else {
            model.addAttribute("error", true);
            return "login_form";
        }
    }

}