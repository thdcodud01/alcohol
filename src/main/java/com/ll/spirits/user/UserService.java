package com.ll.spirits.user;

import com.ll.spirits.DataNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public SiteUser create(String username, String password, String nickname, UserRole role) {
        SiteUser user = new SiteUser();
        user.setUsername(username);
        user.setPassword(passwordEncoder.encode(password));
        user.setNickname(nickname);
        user.setRole(role);
        this.userRepository.save(user);
        return user;
    }

    public SiteUser getUser(String username) {
        Optional<SiteUser> siteUser = this.userRepository.findByUsername(username);
        if (siteUser.isPresent()) {
            return siteUser.get();
        } else {
            throw new DataNotFoundException("siteuser not found");
        }
    }

    public void deleteUser(SiteUser user) {
        if (user.getRole() == UserRole.ADMIN) {
            throw new IllegalArgumentException("관리자는 다른 사용자 계정을 삭제할 수 없습니다.");
        }
        userRepository.delete(user);
    }



    public Optional<SiteUser> getUserByusername(String username) {
        return userRepository.findByUsername(username);
    }
}
