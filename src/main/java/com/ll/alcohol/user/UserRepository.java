package com.ll.alcohol.user;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<SiteUser, Long> {
    Optional<SiteUser> findByuserId(String userId); // 에러 터지면 메소드 이름 의심해보기
    // userId를 username으로 싹다 바꿔주기
}