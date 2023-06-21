package com.ll.spirits.user;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.context.HttpSessionSecurityContextRepository;
import org.springframework.stereotype.Controller;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;
import org.springframework.web.client.RestTemplate;

import java.security.Principal;
import java.util.Optional;


@RequiredArgsConstructor
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private final UserService userService;
    private final PasswordEncoder passwordEncoder;
    private final UserSecurityService userSecurityService;
    private final UserRepository userRepository;

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

            userService.create(userCreateForm.getUsername(), userCreateForm.getPassword1(), userCreateForm.getNickname(), userCreateForm.getBirthDate(), role);
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

//    @PostMapping("/changePassword")
//    public String changePassword(
//            @RequestParam("currentPassword") String currentPassword,
//            @RequestParam("newPassword") String newPassword,
//            @RequestParam("confirmPassword") String confirmPassword,
//            Model model) {
//
//        // 현재 사용자 정보 가져오기
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        String username = authentication.getName();
//        Optional<SiteUser> user = userRepository.findByUsername(username);
//
//        // 현재 비밀번호가 일치하는지 확인
//        if (!passwordEncoder.matches(currentPassword, user.get().getPassword())) {
//            model.addAttribute("error", "현재 비밀번호가 일치하지 않습니다.");
//            return "redirect:/user/myPage";
//        }
//
//        // 새로운 비밀번호와 확인 비밀번호가 일치하는지 확인
//        if (!newPassword.equals(confirmPassword)) {
//            model.addAttribute("error", "새 비밀번호와 확인 비밀번호가 일치하지 않습니다.");
//            return "redirect:/user/myPage";
//        }
//
//        // 회원 가입 시 설정한 비밀번호와 변경할 비밀번호가 서로 다른 값인지 확인
//        if (!passwordEncoder.matches(newPassword, user.get().getPassword())) {
//            model.addAttribute("error", "기존 비밀번호와 새 비밀번호가 일치합니다.");
//            return "redirect:/user/myPage";
//        }
//
//        // 비밀번호 변경
//        String encodedNewPassword = passwordEncoder.encode(newPassword);
//        user.get().setPassword(encodedNewPassword);
//        userRepository.save(user.get());
//
//        // 변경 성공 메시지 등을 설정하여 model에 추가
//        model.addAttribute("success", "비밀번호가 성공적으로 변경되었습니다.");
//
//        return "redirect:/user/myPage"; // 비밀번호 변경 후 마이페이지로 리다이렉트
//    }

//    @PostMapping("/changePassword")
//    public ResponseEntity<?> changePassword(
//            @RequestParam("currentPassword") String currentPassword,
//            @RequestParam("newPassword") String newPassword,
//            @RequestParam("confirmPassword") String confirmPassword) {
//
//        // 현재 사용자 정보 가져오기
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        String username = authentication.getName();
//        Optional<SiteUser> user = userRepository.findByUsername(username);
//
//        // 현재 비밀번호가 일치하는지 확인
//        if (!passwordEncoder.matches(currentPassword, user.get().getPassword())) {
//            return ResponseEntity.badRequest().body("{\"error\": \"현재 비밀번호가 일치하지 않습니다.\"}");
//        }
//
//        // 새로운 비밀번호와 확인 비밀번호가 일치하는지 확인
//        if (!newPassword.equals(confirmPassword)) {
//            return ResponseEntity.badRequest().body("{\"error\": \"새 비밀번호와 확인 비밀번호가 일치하지 않습니다.\"}");
//        }
//
//        // 회원 가입 시 설정한 비밀번호와 변경할 비밀번호가 서로 다른 값인지 확인
//        if (passwordEncoder.matches(newPassword, user.get().getPassword())) {
//            return ResponseEntity.badRequest().body("{\"error\": \"기존 비밀번호와 새 비밀번호가 일치합니다.\"}");
//        }
//
//        // 비밀번호 변경
//        String encodedNewPassword = passwordEncoder.encode(newPassword);
//        user.get().setPassword(encodedNewPassword);
//        userRepository.save(user.get());
//
//        return ResponseEntity.ok("{\"success\": true}");
//    }

    @GetMapping("/login")
    public String login() {

        return "login_form";
    }

    @GetMapping("/mypage")
    public String myPage(Model model, Principal principal) {
        if (principal != null) {
            String username = principal.getName();
            SiteUser user = userService.getUser(username);

            model.addAttribute("userName", user.getUsername());
            model.addAttribute("userNickName", user.getNickname());
            model.addAttribute("userBirthDate", user.getBirthDate());
        }

        return "mypage";
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

    @GetMapping("/login/oauth2/code/kakao")
    public @ResponseBody String kakaoCallback(String code) {
        //POST방식으로 key=value 데이터 요청- 카카오로
        RestTemplate rt = new RestTemplate();

        //HttpHeader 오브젝트 생성
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-type", "application/x-www-form-urlencoded;charset=utf-8");

        //HttpBody 오브젝트 생성
        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.add("grant-type", "authorization_code");
        params.add("client_key", "3c35881ebb2a44ca79547aae99512188");
        params.add("redirect_url", "http://localhost:7777/login/oauth2/code/kakao");
        params.add("code", code);

        //HttpHeader와 HttpBody를 하나의 오브젝트에 담기
        HttpEntity<MultiValueMap<String, String>> kakaoTokenRequest =
                new HttpEntity<>(params, headers);

        //Http 요청하기 - POST 방식으로 그리고 response 변수의 응답
        ResponseEntity<String> response = rt.exchange("https://kauth.kakao.com/oauth/token"
                , HttpMethod.POST, kakaoTokenRequest, String.class);
        return "카카오 토큰 요청 완료 : 토큰에 대한 응답 : " + response;
    }

}