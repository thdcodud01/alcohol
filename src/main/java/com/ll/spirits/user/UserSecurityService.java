package com.ll.spirits.user;

import com.ll.spirits.SecurityConfig;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class UserSecurityService implements UserDetailsService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final UserCreateForm userCreateForm;

    private final UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<SiteUser> _siteUser = this.userRepository.findByUsername(username);

        if (username.isEmpty()) { // 입력받은 userId가 비어있을 경우 >> 따로 템플릿상에서 게스트모드 버튼으로 만들어서 처리하면 됨.
            // 기본 사용자 정보(게스트)를 반환하도록 처리
            List<GrantedAuthority> defaultAuthorities = new ArrayList<>();
            defaultAuthorities.add(new SimpleGrantedAuthority(UserRole.USER.getValue()));
            return new User("GUEST", "", defaultAuthorities);
        }
        if (_siteUser.isEmpty()) {
            throw new UsernameNotFoundException("사용자를 찾을 수 없습니다.");
        }
        SiteUser siteUser = _siteUser.get();

//        // 사용자의 권한 정보를 설정
        List<GrantedAuthority> authorities = new ArrayList<>();

        Optional<SiteUser> usrInfo = userService.getUserByusername(username);

        UserRole role = usrInfo.get().getRole();

        StringBuilder result = new StringBuilder();

        String strSample1 = "ROLE_";
        String strSample2 = role.toString();

        result.append(strSample1);
        result.append(strSample2);

        authorities.add(new SimpleGrantedAuthority(result.toString()));

        return new User(siteUser.getUsername(), siteUser.getPassword(), authorities);
    }
}