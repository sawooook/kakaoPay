package com.example.kakaoPay.controller;

import com.example.kakaoPay.concern.dto.SignUpRequestDto;
import com.example.kakaoPay.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("api")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    //회원가입 요청시
    @PostMapping("/user")
    public ResponseEntity signUp(@RequestBody SignUpRequestDto signUpRequestDto) {
        userService.signUp(signUpRequestDto.getEmail(), signUpRequestDto.getPassword());

    }
}
