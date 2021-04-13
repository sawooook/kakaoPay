package com.example.kakaoPay.domain.repository;

import com.example.kakaoPay.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
