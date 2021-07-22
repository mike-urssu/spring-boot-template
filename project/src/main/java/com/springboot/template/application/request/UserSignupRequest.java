package com.springboot.template.application.request;

import lombok.Data;

@Data
public class UserSignupRequest {
    private String username;
    private String password;
}
