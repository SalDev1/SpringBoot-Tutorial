package com.salprojects.springsecurityclient.service;


import com.salprojects.springsecurityclient.entity.PasswordResetToken;
import com.salprojects.springsecurityclient.entity.User;
import com.salprojects.springsecurityclient.entity.VerificationToken;
import com.salprojects.springsecurityclient.model.UserModel;
import com.salprojects.springsecurityclient.repository.PasswordResetTokenRepository;
import com.salprojects.springsecurityclient.repository.UserRepository;
import com.salprojects.springsecurityclient.repository.VerficiationTokenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordResetTokenRepository passwordResetTokenRepository;

    @Autowired
    private VerficiationTokenRepository verificationTokenRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;


    @Override
    public User registerUser(UserModel userModel) {
        User user = new User();
        user.setEmail(userModel.getEmail());
        user.setFirstName(userModel.getFirstName());
        user.setLastName(userModel.getLastName());

        // We are encoding the password using bcrypt library and then
        // save it into the repository.
        user.setPassword(passwordEncoder.encode(userModel.getPassword()));
        user.setRole("USER");
        return user;
    }

    @Override
    public void saveVerificationTokenForUser(String token, User user) {
        VerificationToken verificationToken = new VerificationToken(user,token);

        verificationTokenRepository.save(verificationToken);
    }

    @Override
    public String vaildateVerificationToken(String token) {
        VerificationToken verificationToken =
                verificationTokenRepository.findByToken(token);

        System.out.println("verificationToken = " + verificationToken);
        if(verificationToken == null) {
            return "invalid";
        }

        User user = verificationToken.getUser();
        Calendar cal = Calendar.getInstance();

        if((verificationToken.getExpirationTime().getTime() - cal.getTime().getTime()) <= 0) {
            verificationTokenRepository.delete(verificationToken);
            return "expired";
        }
        user.setEnabled(true);
        userRepository.save(user);
        return "valid";
    }

    @Override
    public VerificationToken generateVerificationToken(String oldToken) {
        VerificationToken verificationToken = verificationTokenRepository.findByToken(oldToken);

        verificationToken.setToken(UUID.randomUUID().toString());
        verificationTokenRepository.save(verificationToken);
        return verificationToken;
    }

    @Override
    public User findUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public void createPasswordResetTokenForUser(User user, String token) {
        PasswordResetToken passwordResetToken = new PasswordResetToken(user,token);

        passwordResetTokenRepository.save(passwordResetToken);
    }

    // We are validating password reset token over here.
    @Override
    public String validatePasswordResetToken(String token) {
        PasswordResetToken passwordResetToken =
                passwordResetTokenRepository.findByToken(token);

        if(passwordResetToken == null) {
            return "invalid";
        }

        User user = passwordResetToken.getUser();
        Calendar cal = Calendar.getInstance();

        if((passwordResetToken.getExpirationTime().getTime() - cal.getTime().getTime()) <= 0) {
            passwordResetTokenRepository.delete(passwordResetToken);
            return "expired";
        }
        return "valid";
    }

    @Override
    public Optional<User> getUserByPasswordResetToken(String token) {
        return Optional.ofNullable(passwordResetTokenRepository.findByToken(token).getUser());
    }

    @Override
    public void changePassword(User user, String newPassword) {
        user.setPassword(passwordEncoder.encode(newPassword));
        userRepository.save(user);
    }

    @Override
    public boolean checkIfValidOldPassword(User user, String oldPassword) {
        return passwordEncoder.matches(oldPassword, user.getPassword());
    }

}
