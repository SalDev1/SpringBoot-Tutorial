package com.salprojects.springbootoauth.repository;

import com.salprojects.springbootoauth.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
    User findByEmail(String email);
}
