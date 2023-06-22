package com.example.dddpracticeorder.infrastructure.partner;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.dddpracticeorder.domain.partner.Partner;

public interface PartnerRepository extends JpaRepository<Partner, Long> {
    Optional<Partner> findByPartnerToken(String partnerToken);
}
