package com.springboot.template.application.request;

import lombok.Data;

@Data
public class UserSignInRequest {
    private String username;
    private String password;
}
