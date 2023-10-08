package com.salprojects.springboot.jpa1.entity;

import com.salprojects.springboot.jpa1.repository.CourseMaterialRepository;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Course {

    @Id
    @SequenceGenerator(
            name = "course_sequence",
            sequenceName = "course_sequence",
            allocationSize = 1
    )
    @GeneratedValue (
            strategy = GenerationType.SEQUENCE,
            generator = "course_sequence"
    )
    private Long courseId;
    private String title;
    private Integer credit;


    // There already exists OnetoOne Mapping in courseMaterial class
    // referred to the course.
    @OneToOne(
            mappedBy = "course"
    )
    private CourseMaterial courseMaterial;

    @ManyToOne(
            cascade = CascadeType.ALL
    )
    @JoinColumn(
       // A common col / foreign key is used to maintain relation between
       // two entities.
            name = "teacher_id",
            referencedColumnName = "teacherId"
    )
    private Teacher teacher;

    // Multiple students will enrolled to a single course.
    @ManyToMany (
            cascade = CascadeType.ALL
    )
    @JoinTable(
          name = "student_course_map",
          // We have will table of two columns , course_id and student_id.
            // and it contains mapping between course and student
          joinColumns = @JoinColumn(
                  name = "course_id",
                  referencedColumnName = "courseId"
          ),
            inverseJoinColumns = @JoinColumn(
               name = "student_id",
               referencedColumnName = "studentId"
          )
    )
    private List<Student> students;

    public void addStudents(Student student) {
        if(students == null) {
            students = new ArrayList<>();
        }
        students.add(student);
    }
}
