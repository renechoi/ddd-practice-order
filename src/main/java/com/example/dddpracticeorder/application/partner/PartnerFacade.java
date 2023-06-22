package com.example.dddpracticeorder.application.partner;

import org.springframework.stereotype.Service;

import com.example.dddpracticeorder.domain.notification.NotificationService;
import com.example.dddpracticeorder.domain.partner.PartnerCommand;
import com.example.dddpracticeorder.domain.partner.PartnerInfo;
import com.example.dddpracticeorder.domain.partner.PartnerService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class PartnerFacade {
    private final PartnerService partnerService;
    private final NotificationService notificationService;

    public PartnerInfo registerPartner(PartnerCommand command) {
        var partnerInfo = partnerService.registerPartner(command);
        notificationService.sendEmail(partnerInfo.getEmail(), "title", "description");
        return partnerInfo;
    }
}
