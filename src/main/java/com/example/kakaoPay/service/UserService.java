package com.example.kakaoPay.service;

import com.example.kakaoPay.domain.User;
import com.example.kakaoPay.domain.repository.UserRepository;
import com.example.kakaoPay.service.exception.DuplicateEmailExcption;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;


    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public void signUp(String email, String password) {
        String encodePassword = passwordEncoder.encode(password);
        if (validCheck(email)) {
            User user = new User(email, encodePassword);
            userRepository.save(user);
        } else {
            throw new DuplicateEmailExcption();
        }
    }

    private boolean validCheck(String email) {
        Optional<User> user = userRepository.findByEmail(email);
        if (user.isPresent()) {
            // 이미 사용하고 있는 이메일의 유저가 존재
            return false;
        } else {
            // 사용가능한 이메일
            return true;
        }
    }
}
