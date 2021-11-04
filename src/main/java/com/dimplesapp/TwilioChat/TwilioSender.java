package com.dimplesapp.TwilioChat;
import com.twilio.type.PhoneNumber;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.rest.api.v2010.account.MessageCreator;
import org.springframework.stereotype.Service;

@Service("twilio")
public class TwilioSender implements Sender {

    private final TwilioConfiguration twilioConfiguration;

    public TwilioSender(TwilioConfiguration twilioConfiguration) {
        this.twilioConfiguration = twilioConfiguration;
    }

    @Override
    public void sendSms(SmsRequest smsRequest) {
        if (hasValidPhone(smsRequest.getPhoneNumber())) {
            PhoneNumber to = new PhoneNumber(smsRequest.getPhoneNumber());
            PhoneNumber from = new PhoneNumber(twilioConfiguration.getTrial_number());
            String message = smsRequest.getMessage();
            MessageCreator creator = Message.creator(to, from, message);
            creator.create();
        } else {
            throw new IllegalArgumentException("Invalid Phone");
        }
    }

    // helper method
    private boolean hasValidPhone(String phoneNumber) {
        return true;
    }
}