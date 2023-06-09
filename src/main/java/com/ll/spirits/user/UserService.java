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

    public SiteUser create(String userId, String password, String nickname, UserRole role) {
        SiteUser user = new SiteUser();
        user.setUserId(userId);
        user.setPassword(passwordEncoder.encode(password));
        user.setNickname(nickname);
        user.setRole(role);
        this.userRepository.save(user);
        return user;
    }

    public SiteUser getUser(String userId) {
        Optional<SiteUser> siteUser = this.userRepository.findByuserId(userId);
        if (siteUser.isPresent()) {
            return siteUser.get();
        } else {
            throw new DataNotFoundException("siteuser not found");
        }
    }

    public Optional<SiteUser> getUserByuserId(String userId) {
        return userRepository.findByuserId(userId);
    }
}
