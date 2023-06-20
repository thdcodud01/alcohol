package com.ll.spirits.oauth;

//import com.ll.spirits.member.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;
import java.util.UUID;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class OAuth2UserService extends DefaultOAuth2UserService {

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
//        Member member = null;
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
//                    member = Member.builder()
//                            .email(email)
//                            .username(username)
//                            .password(passwordEncoder.encode(UUID.randomUUID().toString()))
//                            .build();
//
//                    memberRepository.save(member);
//                }
//            }
//        } else {
//            member = memberRepository.findByUsername("%s_%s".formatted(oauthType, oauthId))
//                    .orElseThrow(MemberNotFoundException::new);
//        }
//
//        Set<GrantedAuthority> authorities = new LinkedHashSet<>();
//        authorities.add(new SimpleGrantedAuthority("USER"));
//        return new MemberContext(member, authorities, attributes, userNameAttributeName);
//    }
//
//
//
//    private boolean isNew(String oAuthType, String oAuthId) {
//        return memberRepository.findByUsername("%s_%s".formatted(oAuthType, oAuthId)).isEmpty();
//    }
//
//}



//    public String getKakaoAccessToken (String code) {
//        String access_Token = "";
//        String refresh_Token = "";
//        String reqURL = "https://kauth.kakao.com/oauth/token";
//
//        try {
//            URL url = new URL(reqURL);
//            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
//
//            //POST 요청을 위해 기본값이 false인 setDoOutput을 true로
//            conn.setRequestMethod("POST");
//            conn.setDoOutput(true);
//
//            //POST 요청에 필요로 요구하는 파라미터 스트림을 통해 전송
//            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(conn.getOutputStream()));
//            StringBuilder sb = new StringBuilder();
//            sb.append("grant_type=authorization_code");
//            sb.append("&client_id=3c35881ebb2a44ca79547aae99512188"); // TODO REST_API_KEY 입력
//            sb.append("&redirect_uri=http://localhost:8080/oauth/kakao"); // TODO 인가코드 받은 redirect_uri 입력
//            sb.append("&code=" + code);
//            bw.write(sb.toString());
//            bw.flush();
//
//            //결과 코드가 200이라면 성공
//            int responseCode = conn.getResponseCode();
//            System.out.println("responseCode : " + responseCode);
//
//            //요청을 통해 얻은 JSON타입의 Response 메세지 읽어오기
//            BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
//            String line = "";
//            String result = "";
//
//            while ((line = br.readLine()) != null) {
//                result += line;
//            }
//            System.out.println("response body : " + result);
//
//            //Gson 라이브러리에 포함된 클래스로 JSON파싱 객체 생성
//            JsonParser parser = new JsonParser();
//            JsonElement element = parser.parse(result);
//
//            access_Token = element.getAsJsonObject().get("access_token").getAsString();
//            refresh_Token = element.getAsJsonObject().get("refresh_token").getAsString();
//
//            System.out.println("access_token : " + access_Token);
//            System.out.println("refresh_token : " + refresh_Token);
//
//            br.close();
//            bw.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        return access_Token;
//    }
}