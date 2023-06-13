package com.ll.spirits.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<SiteUser, Long> {
    Optional<SiteUser> findByUsername(String username);



    // 에러 터지면 메소드 이름 의심해보기
    // userId를 username으로 싹다 바꿔주기
//    @Query("select role from site_user where username = :username")
//    Optional<SiteUser> findByRole(@Param("username") String username);



}