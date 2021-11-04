package com.dimplesapp.TwilioChat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/sms")
public class Controller {
    private final TwilioService twilioService;

    @Autowired
    public Controller(TwilioService twilioService) {
        this.twilioService = twilioService;
    }

    @PostMapping
    public void sendSms(@RequestBody SmsRequest smsRequest) {
        twilioService.sendSMS(smsRequest);
    }
}
