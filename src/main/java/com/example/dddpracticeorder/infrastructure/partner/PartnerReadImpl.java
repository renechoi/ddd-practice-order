package com.example.dddpracticeorder.infrastructure.partner;

import org.springframework.stereotype.Component;

import com.example.dddpracticeorder.common.exception.EntityNotFoundException;
import com.example.dddpracticeorder.domain.partner.Partner;
import com.example.dddpracticeorder.domain.partner.PartnerReader;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
@RequiredArgsConstructor
public class PartnerReadImpl implements PartnerReader {
    private final PartnerRepository partnerRepository;

    @Override
    public Partner getPartner(Long partnerId) {
        return partnerRepository.findById(partnerId)
                .orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public Partner getPartner(String partnerToken) {
        return partnerRepository.findByPartnerToken(partnerToken)
                .orElseThrow(EntityNotFoundException::new);
    }
}
