package com.salprojects.springboot.jpa1.entity;

import jakarta.annotation.Generated;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

// We want student class to be entity.
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "tbl_student", uniqueConstraints = @UniqueConstraint(name = "emailid_unique", columnNames = "email_address"))

public class Student {
    // I want primary key to be student id.

    @Id
    @SequenceGenerator(name = "student_sequence", sequenceName = "student_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "student_sequence")

    private Long StudentId;
    private String firstName;
    private String lastName;

    // Making sure that the email_address is unique for each student entity.
    @Column(name = "email_address", nullable = false)
    private String emailId;

    // Import class and adding Embedded Annontation.
    @Embedded
    private Guardian guardian;
}

/*
 * 
 * Using Table --> giving a table name.
 * Using Column --> giving a col name.
 */