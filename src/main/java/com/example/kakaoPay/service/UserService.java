package com.example.kakaoPay.service;

import com.example.kakaoPay.concern.dto.SignUpRequestDto;
import com.example.kakaoPay.domain.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void signUp(String email, String password) {
    }
}
