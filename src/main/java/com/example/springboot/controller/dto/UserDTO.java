package com.example.springboot.controller.dto;


import lombok.Data;


/*
接收前端登录请求的参数，和user实体类区分
 */
@Data
public class UserDTO {
    private String username;
    private String password;
    private String nickname;
    private String email;
    private String avatarUrl;
    private String token;
}
