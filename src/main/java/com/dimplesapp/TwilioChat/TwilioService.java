package com.dimplesapp.TwilioChat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TwilioService {

    private final TwilioSender twilioSender;

    @Autowired
    public TwilioService(TwilioSender twilioSender) {
        this.twilioSender = twilioSender;
    }

    public void sendSMS(SmsRequest smsRequest) {
        twilioSender.sendSms(smsRequest);
    }

}
