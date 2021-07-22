package com.springboot.template.application.controller;

import com.springboot.template.application.request.UserSignInRequest;
import com.springboot.template.application.request.UserSignupRequest;
import com.springboot.template.application.response.UserSignInResponse;
import com.springboot.template.domain.service.AuthService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;

    @ApiOperation(value = "회원가입")
    @PostMapping("/v1/api/auth/signup")
    @ResponseStatus(HttpStatus.CREATED)
    public void signup(
            @RequestBody UserSignupRequest userSignupRequest
    ) {
        authService.signup(userSignupRequest);
    }

    @ApiOperation(value = "로그인")
    @PostMapping("/v1/api/auth/signin")
    @ResponseStatus(HttpStatus.OK)
    public UserSignInResponse signIn(
            @RequestBody UserSignInRequest userSignInRequest
    ) {
        String accessToken = authService.signIn(userSignInRequest);
        return new UserSignInResponse(accessToken);
    }
}
