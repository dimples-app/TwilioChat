package com.dimplesapp.TwilioChat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;


@Configuration
public class TwilioStarter {
    public final TwilioConfiguration twilioConfiguration;

    @Autowired
    public TwilioStarter(TwilioConfiguration twilioConfiguration) {
        this.twilioConfiguration = twilioConfiguration;
        Twilio.init(twilioConfiguration.getAccount_sid(), twilioConfiguration.getAuth_token());
    }
}

