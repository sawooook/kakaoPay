package com.example.kakaoPay.domain.repository;

import com.example.kakaoPay.domain.BillingPay;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BillingPayRepository extends JpaRepository<BillingPay, Long> {

}
