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
//
//        // 입력된 비밀번호와 데이터베이스에서 조회한 사용자의 비밀번호 비교
//        if (!passwordEncoder.matches(userCreateForm.getPassword1(), siteUser.getPassword())) {
//            System.out.println("입력한 패스워드: " + userCreateForm.getPassword1());
//            System.out.println("저장된 패스워드: " + siteUser.getPassword());
//            throw new BadCredentialsException("비밀번호가 일치하지 않습니다.");
//        }
//
//        System.out.println(siteUser.getUsername());
//        System.out.println(siteUser.getPassword());
//        System.out.println(siteUser);
//        // 사용자의 권한 정보를 설정
        List<GrantedAuthority> authorities = new ArrayList<>();
        if ("admin@gmail.com".equals(username)) {
            authorities.add(new SimpleGrantedAuthority(UserRole.ADMIN.getValue()));
        } else if("admin1@gmail.com".equals(username)) {
            authorities.add(new SimpleGrantedAuthority(UserRole.ADMIN.getValue()));
        } else if("admin2@gmail.com".equals(username)) {
            authorities.add(new SimpleGrantedAuthority(UserRole.ADMIN.getValue()));
        } else {
            authorities.add(new SimpleGrantedAuthority(UserRole.USER.getValue()));
        }
        return new User(siteUser.getUsername(), siteUser.getPassword(), authorities);
    }
}