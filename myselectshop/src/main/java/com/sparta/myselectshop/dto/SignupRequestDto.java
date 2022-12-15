package com.sparta.myselectshop.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class SignupRequestDto {
    private String username;
    private String password;
    private String email;
    private boolean admin = false; // 애드민 값이 있을시 true 가 됨
    private String adminToken = ""; // 애드민토큰 값이 저장됨
}