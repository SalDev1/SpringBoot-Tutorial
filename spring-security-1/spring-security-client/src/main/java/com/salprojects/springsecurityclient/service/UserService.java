package com.salprojects.springsecurityclient.service;

import com.salprojects.springsecurityclient.entity.User;
import com.salprojects.springsecurityclient.entity.VerificationToken;
import com.salprojects.springsecurityclient.model.UserModel;

import java.util.Optional;

public interface UserService {
    User registerUser(UserModel userModel);

    void saveVerificationTokenForUser(String token, User user);

    String vaildateVerificationToken(String token);

    VerificationToken generateVerificationToken(String oldToken);

    User findUserByEmail(String email);

    void createPasswordResetTokenForUser(User user, String token);

    String validatePasswordResetToken(String token);

    Optional<User> getUserByPasswordResetToken(String token);

    void changePassword(User user, String newPassword);

    boolean checkIfValidOldPassword(User user, String oldPassword);
}
