package com.ll.spirits.user;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.context.HttpSessionSecurityContextRepository;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;

import java.util.Optional;

@RequiredArgsConstructor
@Controller
@RequestMapping("/user")
public class UserController {

    private final UserService userService;
    private final PasswordEncoder passwordEncoder;
    private final UserSecurityService userSecurityService;

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
            UserRole role = userCreateForm.getUserId().startsWith("admin") ? UserRole.ADMIN : UserRole.USER;

            userService.create(userCreateForm.getUserId(), userCreateForm.getPassword1(), userCreateForm.getNickname(), role);
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

    @GetMapping("/login")
    public String login() {
        return "login_form";
    }

    @PostMapping("/login")
    public String login(@RequestParam("userId") String userId, @RequestParam("password1") String password, HttpSession session, Model model) {
        if ("admin@gmail.com".equals(userId) && "123".equals(password)) {
            UserDetails userDetails = userSecurityService.loadUserByUsername(userId);
            Authentication authentication = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
            SecurityContextHolder.getContext().setAuthentication(authentication);

            session.setAttribute(HttpSessionSecurityContextRepository.SPRING_SECURITY_CONTEXT_KEY, SecurityContextHolder.getContext());

            return "redirect:/";
        } else {
            model.addAttribute("error", true);
            return "login_form";
        }
    }


//    @PostMapping("/login")
//    public String login(@RequestParam("userId") String userId, @RequestParam("password1") String password, HttpSession session, Model model) {
//        // 로그인 로직을 구현합니다.
//        // 예시로 간단히 userId와 password가 일치하는지 확인하는 로직을 작성하였습니다.
//        // 실제로는 사용자 인증을 위해 Spring Security 또는 별도의 인증 로직을 구현해야 합니다.
//
//        Optional<SiteUser> optionalUser = userService.getUserByuserId(userId);
//        if (optionalUser.isPresent()) {
//            SiteUser user = optionalUser.get();
//            if (passwordEncoder.matches(password, user.getPassword())) {
//                // 비밀번호 일치
//                session.setAttribute("userId", userId);
//                return "redirect:/";
//            }
//        }
//
//        // 로그인 실패 시 처리할 로직을 작성합니다.
//        // 실패 메시지를 전달하거나 로그인 폼 페이지로 리디렉션합니다.
//        model.addAttribute("error", true);
//        return "login_form";
//    }


}