package com.sal.springboot.learnjpaandhibernate.course;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Course {

    @Id
    private long id;

//    @Column(name = "name")
    private String name;

//    @Column(name = "author")
    private String author;
}
