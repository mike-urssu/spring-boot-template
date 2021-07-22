package com.springboot.template.domain.service;

import com.springboot.template.application.request.UserSignInRequest;
import com.springboot.template.application.request.UserSignupRequest;
import com.springboot.template.core.security.JwtTokenProvider;
import com.springboot.template.domain.exception.UserAlreadyExistsException;
import com.springboot.template.domain.exception.UserNotFoundException;
import com.springboot.template.domain.model.entity.User;
import com.springboot.template.domain.model.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class AuthService {
    private final UserRepository userRepository;

    private final JwtTokenProvider jwtTokenProvider;

    public void signup(UserSignupRequest userSignupRequest) {
        if (userRepository.existsByUsername(userSignupRequest.getUsername()))
            throw new UserAlreadyExistsException();
        User user = new User(userSignupRequest);
        userRepository.save(user);
    }

    public String signIn(UserSignInRequest userSignInRequest) {
        User user = userRepository.findByUsernameAndPassword(userSignInRequest.getUsername(), userSignInRequest.getPassword()).orElseThrow(UserNotFoundException::new);
        return jwtTokenProvider.generateJwtToken(user.getId(), user.getRole());
    }
}
