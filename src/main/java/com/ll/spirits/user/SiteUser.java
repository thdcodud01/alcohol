package com.ll.spirits.user;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class SiteUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String userId; // email 형식
    private String password;
    @Column(unique = true)
    private String nickname;
    @Enumerated(EnumType.STRING)
    private UserRole role;
}
