package com.salprojects.springbootoauth.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private long id;
    private String firstName;
    private String lastName;
    private String email;

    @Column(length = 60)
    // We are going to encrypt our password into hash code values
    private String password;
    private String role;
    private boolean enabled = false;
}
