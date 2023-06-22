package com.ll.spirits.user;

import com.ll.spirits.DataNotFoundException;
//import com.ll.spirits.user.emailService.EmailService;
//import com.ll.spirits.user.emailService.EmailVerificationToken;
//import com.ll.spirits.user.emailService.EmailVerificationTokenRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

//    private final EmailVerificationTokenRepository tokenRepository;
//    private final EmailService emailService;

    public SiteUser create(String username, String password, String nickname, LocalDate birthDate, UserRole role) {
        SiteUser user = new SiteUser();
        user.setUsername(username);
        user.setPassword(passwordEncoder.encode(password));
        user.setNickname(nickname);
        user.setBirthDate(birthDate);
        user.setRole(role);
        this.userRepository.save(user);
        return user;
    }
    public SiteUser modifyPassword(String password) {
        SiteUser user = new SiteUser();
        user.setPassword(passwordEncoder.encode(password));
        this.userRepository.save(user);
        return user;
    }
    public SiteUser confirmPassword(String password) {
        SiteUser user = new SiteUser();
        this.userRepository.save(user);
        return user;
    }

    public List<SiteUser> getList () {
        return this.userRepository.findAll();
    }

    public SiteUser getUser(Long id) {
        Optional<SiteUser> siteUser = this.userRepository.findById(id);
        if (siteUser.isPresent()) {
            return siteUser.get();
        } else {
            throw new DataNotFoundException("siteuser not found");
        }
    }

    public SiteUser getUser(String name) {
        Optional<SiteUser> siteUser = this.userRepository.findByUsername(name);
        if (siteUser.isPresent()) {
            return siteUser.get();
        } else {
            throw new DataNotFoundException("siteuser not found");
        }
    }
    public SiteUser getUserId(Long id) {// Integer 로 타입이 들어오면 null 값도 허용해줄 수 있음
        Optional<SiteUser> siteUser = this.userRepository.findById(id);
        if (siteUser.isPresent()) {
            return siteUser.get();
        } else {
            throw new DataNotFoundException("siteUserId not found"); // 예외처리로 에러(DataNotFoundException)를 표시
        }
    }

    public boolean isNicknameDuplicate(String nickname) {
        Optional<SiteUser> existingUser = userRepository.findByNickname(nickname);
        return existingUser.isPresent();
    }

    public CurrentUser updateUser(String newUsername, String newPassword) {
        CurrentUser currentUser = new CurrentUser();
        currentUser.setUsername(newUsername);
        currentUser.setPassword(newPassword);
        return currentUser;
    }

    public void deleteUser(SiteUser user) {
        this.userRepository.delete(user);
    }



    public Optional<SiteUser> getUserByusername(String username) {
        return userRepository.findByUsername(username);
    }

//    public void registerUser(SiteUser user) {
//        // 비밀번호 암호화
//        user.setPassword(passwordEncoder.encode(user.getPassword()));
//
//        // 사용자 저장
//        userRepository.save(user);
//
//        // 이메일 인증 토큰 생성
//        EmailVerificationToken token = new EmailVerificationToken();
//        token.setToken(generateToken());
//        token.setUser(user);
//        token.setExpiryDate(LocalDateTime.now().plusHours(24));
//        tokenRepository.save(token);
//
//        // 이메일 발송
//        String subject = "이메일 인증을 완료해주세요.";
//        String body = "인증을 완료하려면 다음 링크를 클릭하세요: http://example.com/verify?token=" + token.getToken();
//        emailService.sendEmail(user.getUsername(), subject, body);
//    }
//
//    private String generateToken() {
//        // 토큰 생성 로직 구현
//        // 예시: 랜덤한 문자열 생성 또는 UUID 사용
//        return "generated_token";
//    }

}