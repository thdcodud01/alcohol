package com.ll.alcohol.user;

import java.util.Optional;

public interface UserRepository {
    Optional<SiteUser> findByusername(String username);
}
