package com.ll.spirits.oauth;
import com.ll.spirits.user.SiteUser;
import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.oauth2.core.user.OAuth2User;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Getter
public class MemberContext extends SiteUser implements OAuth2User { // Spring Security와 OAuth2를 사용하여 로그인한 사용자의 정보를 담음, 이를 활용하여 인증과 권한 부여를 처리하는 Spring Security의 기능을 사용
    private final Long id;
    private final String password;

    private Map<String, Object> attributes; // OAuth2 인증 시스템에서 제공되는 추가 사용자 속성을 저장하는 맵
    private String userNameAttributeName; // OAuth2 인증 시스템에서 사용자 이름을 식별하는 속성의 이름

    public MemberContext(SiteUser user, List<GrantedAuthority> authorities) {
        super(user.getUsername(), user.getPassword(), authorities);
        this.id = user.getId();
        this.password = user.getPassword();
    }

    public MemberContext(SiteUser user, List<GrantedAuthority> authorities, Map<String, Object> attributes, String userNameAttributeName) {
        this(user, authorities);
        this.attributes = attributes;
        this.userNameAttributeName = userNameAttributeName;
    }

    @Override
    public Map<String, Object> getAttributes() {
        return this.attributes;
    }

    @Override
    public String getName() {
        return this.getAttribute(this.userNameAttributeName).toString();
    }
}
