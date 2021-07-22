package com.springboot.template.application.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserSignInResponse {
    private String accessToken;
}
