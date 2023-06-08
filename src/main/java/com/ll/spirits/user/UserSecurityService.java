package com.ll.spirits.user;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class UserSecurityService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException {
        Optional<SiteUser> _siteUser = this.userRepository.findByuserId(userId);
        if (_siteUser.isEmpty()) {
            throw new UsernameNotFoundException("사용자를 찾을 수 없습니다.");
        }
        SiteUser siteUser = _siteUser.get();
        List<GrantedAuthority> authorities = new ArrayList<>();

        // 관리자인 경우 ROLE_ADMIN을 추가
        if (siteUser.getRole() == UserRole.ADMIN) {
            authorities.add(new SimpleGrantedAuthority(UserRole.ADMIN.getValue()));
        }

        // 일반 유저는 항상 ROLE_USER를 추가
        authorities.add(new SimpleGrantedAuthority(UserRole.USER.getValue()));

        return new User(siteUser.getUserId(), siteUser.getPassword(), authorities);
    }
}
