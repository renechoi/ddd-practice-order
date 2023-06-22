package com.example.dddpracticeorder.interfaces.partner;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.dddpracticeorder.application.partner.PartnerFacade;
import com.example.dddpracticeorder.common.response.CommonResponse;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/partners")
public class PartnerApiController {
    private final PartnerFacade partnerFacade;

    @PostMapping
    public CommonResponse registerPartner(@RequestBody @Valid PartnerDto.RegisterRequest request) {
        var partnerInfo = partnerFacade.registerPartner(request.toCommand());
        var response = new PartnerDto.RegisterResponse(partnerInfo);
        return CommonResponse.success(response);
    }
}
