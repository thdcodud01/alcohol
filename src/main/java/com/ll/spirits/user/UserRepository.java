package com.ll.spirits.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<SiteUser, Long> {

    Optional<SiteUser> findByNickname(String nickname);

    Optional<SiteUser> findByUsername(String username);

//    @Query("select role from site_user where username = :username")
//    Optional<SiteUser> findByRole(@Param("username") String username);
}