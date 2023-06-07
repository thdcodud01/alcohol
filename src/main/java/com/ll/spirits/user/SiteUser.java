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
//    @Column(unique = true)
//    private String email; // 필요한가?
    private String password;
    @Column(unique = true)
    private String nickname;
}
