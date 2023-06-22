//package com.ll.spirits.oauth;
//
//import com.ll.spirits.user.SiteUser;
//import com.ll.spirits.user.UserRepository;
//import lombok.RequiredArgsConstructor;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
//import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
//import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
//import org.springframework.security.oauth2.core.user.OAuth2User;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//import java.util.*;
//
//@Service
//@Transactional(readOnly = true)
//@RequiredArgsConstructor
//public class OAuth2UserService extends DefaultOAuth2UserService {
//
//    @Autowired
//    private UserRepository userRepository;
//    @Override
//    @Transactional
//    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
//        OAuth2User oAuth2User = super.loadUser(userRequest);
//
//        String userNameAttributeName = userRequest.getClientRegistration().getProviderDetails().getUserInfoEndpoint()
//                .getUserNameAttributeName();
//        Map<String, Object> attributes = oAuth2User.getAttributes();
//
//        String oauthId = oAuth2User.getName();
//
//        SiteUser user = null;
//        String oauthType = userRequest.getClientRegistration().getRegistrationId().toUpperCase();
//
//        if (!"KAKAO".equals(oauthType)) {
//            throw new OAuthTypeMatchNotFoundException();
//        }
//
//        if (isNew(oauthType, oauthId)) {
//            switch (oauthType) {
//                case "KAKAO" -> {
//                    Map attributesProperties = (Map) attributes.get("properties");
//                    Map attributesKakaoAcount = (Map) attributes.get("kakao_account");
//                    String nickname = (String) attributesProperties.get("nickname");
//                    String email = "%s@kakao.com".formatted(oauthId);
//                    String username = "KAKAO_%s".formatted(oauthId);
//
//                    if ((boolean) attributesKakaoAcount.get("has_email")) {
//                        email = (String) attributesKakaoAcount.get("email");
//                    }
//
//                    user = SiteUser.builder()
//                            .nickname(nickname)
//                            .username(email)
//                            .password("")
//                            .build();
//                    userRepository.save(user);
//                }
//            }
//        }
//
//        List<GrantedAuthority> authorities = new ArrayList<>();
//        authorities.add(new SimpleGrantedAuthority("USER"));
//        return new MemberDTO(user, authorities, attributes, userNameAttributeName);
//    }
//
//
//
//    private boolean isNew(String oAuthType, String oAuthId) { // isNew -> 사용자명으로 조회한 결과가 비어있는지 여부에 따라 새로운 사용자인지를 판단하고, isEmpty()를 사용하여 그 결과를 확인
//        return userRepository.findByUsername("%s_%s".formatted(oAuthType, oAuthId)).isEmpty(); // isEmpty -> 반환된 리스트가 비어있는지를 확인하는 역할
//    }
//
//}