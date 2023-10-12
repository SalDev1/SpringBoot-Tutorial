package com.salprojects.springsecurityclient.controller;


import com.salprojects.springsecurityclient.entity.User;
import com.salprojects.springsecurityclient.entity.VerificationToken;
import com.salprojects.springsecurityclient.event.RegistrationCompleteEvent;
import com.salprojects.springsecurityclient.model.PasswordModel;
import com.salprojects.springsecurityclient.model.UserModel;
import com.salprojects.springsecurityclient.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;


// Creating an API routes over here.
@RestController
@Slf4j
public class RegistrationController {

    @Autowired
    private UserService userService;

    @Autowired
    private ApplicationEventPublisher publisher;

    @PostMapping("/register")
    public String registerUser(@RequestBody UserModel userModel , final HttpServletRequest request) {
        User user = userService.registerUser(userModel);
        publisher.publishEvent(new RegistrationCompleteEvent(
                user, 
                applicationUrl(request)
        ));
        return "Success";
    }

    // Creating a verifying Registration API.
    @GetMapping("/verifyRegistration")
    public String verifyRegistration(@RequestParam("token") String token) {
        String result = userService.vaildateVerificationToken(token);
        if(result.equalsIgnoreCase("valid")) {
            return "User Verified Successfully";
        }
        return "Bad User";
    }

    @GetMapping("/resendVerifyToken")
    public String resendVerificationToken(@RequestParam("token") String oldToken , HttpServletRequest request) {
        VerificationToken verificationToken = userService.generateVerificationToken(oldToken);

        User user = verificationToken.getUser();
        resendVerificationTokenMail(user,applicationUrl(request) , verificationToken);
        return "Verification Link Sent";
    }

    // Sending a new password token as an url in an email
    // to the user
    // if it's email exists in the database first.
    @PostMapping("/resetPassword")
    public String resetPassword(@RequestBody PasswordModel passwordModel , HttpServletRequest request) {
      User user = userService.findUserByEmail(passwordModel.getEmail());
      String url = "";
      if(user != null) {
          String token = UUID.randomUUID().toString();
          userService.createPasswordResetTokenForUser(user,token);
          url = passwordResetTokenMail(user,applicationUrl(request) , token);
      }
      return url;
    }

    @PostMapping("/savePassword")
    public String savePassword(@RequestParam("token") String token , @RequestBody PasswordModel passwordModel) {
        String result =  userService.validatePasswordResetToken(token);
        if(!result.equalsIgnoreCase("valid")) {
            return "Invalid Token";
        }
        // I need the user back based on the new token after changing the password.
        Optional<User> user = userService.getUserByPasswordResetToken(token);
        if(user.isPresent()) {
            userService.changePassword(user.get() , passwordModel.getNewPassword());
            return "Password Reset Successfully";
        }
        else {
            return "Invalid Token";
        }
    }

    @PostMapping("/changePassword")
    public String changePassword(@RequestBody PasswordModel passwordModel) {
        User user = userService.findUserByEmail(passwordModel.getEmail());
        // If the old password is valid , then only we are going to save the new password for
        // the given email / user.
        if(!userService.checkIfValidOldPassword(user,passwordModel.getOldPassword())) {
            return "Invalid Old Password";
        }

        // Save new Password
        userService.changePassword(user,passwordModel.getNewPassword());
        return "Password Changed Successfully";
    }

    private String passwordResetTokenMail(User user, String applicationUrl, String token) {
        String url = applicationUrl +
                "/savePassword?token=" + token;

        log.info("Click the link to reset your password : {}" , url);
        return url;
    }

    private void resendVerificationTokenMail(User user, String applicationUrl , VerificationToken token) {
        String url = applicationUrl +
                "/verifyRegistration?token=" + token.getToken();

        log.info("Click the link to verify your account : {}" , url);
    }


    private String applicationUrl(HttpServletRequest request) {
        return "http://" +
                request.getServerName()
                + ":" +
                request.getServerPort() +
                request.getContextPath();
    }
}
