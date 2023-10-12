package com.salprojects.springsecurityclient.event.listener;


import com.salprojects.springsecurityclient.entity.User;
import com.salprojects.springsecurityclient.event.RegistrationCompleteEvent;
import com.salprojects.springsecurityclient.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import java.util.UUID;


@Component
@Slf4j
public class RegistrationCompleteEventListener implements ApplicationListener<RegistrationCompleteEvent>{
    @Autowired
    private UserService userService;

    @Override
    public void onApplicationEvent(RegistrationCompleteEvent event) {
        // Create the verificiation token for the user with link.
        User user = event.getUser();
        // A unique token for each user can be used to match contents within
        // the database.
        String token = UUID.randomUUID().toString();
        //Send mail to user.
        userService.saveVerificationTokenForUser(token,user);

        String url = event.getApplicationUrl() +
                "/verifyRegistration?token=" + token;

        // sendVerificationEmail()
        log.info("Click the link to verify your account : {}" , url);
    }
}
