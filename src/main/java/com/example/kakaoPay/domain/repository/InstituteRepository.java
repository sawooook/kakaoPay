package com.example.kakaoPay.domain.repository;

import com.example.kakaoPay.domain.Institute;
import com.example.kakaoPay.domain.InstituteState;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InstituteRepository extends JpaRepository<Institute, Long> {
    Institute findByState(InstituteState state);
}
