package com.salprojects.springsecurityclient.repository;

import com.salprojects.springsecurityclient.entity.VerificationToken;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VerficiationTokenRepository
        extends JpaRepository<VerificationToken,Long> {

    VerificationToken findByToken(String token);
}
