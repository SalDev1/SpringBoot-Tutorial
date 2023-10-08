package com.salprojects.springboot.jpa1.repository;

import com.salprojects.springboot.jpa1.entity.Guardian;
import com.salprojects.springboot.jpa1.entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


// Helps you test the layer and once the execution is done , it flushes out
// the data --> @DataJpaTest
@SpringBootTest  // To make some effect to the repository.
class StudentRepositoryTest {
    @Autowired
    private StudentRepository studentRepository;

    // Create a method to save a student
    @Test
    public void saveStudent() {
        // Builder pattern to build the object.
        Student student = Student.builder()
                .emailId("salman@gmail.com")
                .firstName("Salman")
                .lastName("Uddin")
                //.guardianName("Sam")
                //.guardianEmail("sam@gmail.com")
                //.guardianMobile("1242321323")
                .build();

        studentRepository.save(student);
    }

    @Test
    public void saveStudentWithGuardian() {
        Guardian guardian = Guardian.builder()
                .name("Melissa")
                .email("melissa@gmail.com")
                .mobile("99751414151")
                .build();

        Student student =
                Student.builder()
                        .firstName("Anna")
                        .emailId("anna1@gmail.com")
                        .lastName("Williams")
                        .guardian(guardian)
                .build();

        studentRepository.save(student);
    }

    @Test
    public void findStudents() {
        List<Student> studentsList = studentRepository.findAll();
        System.out.println("studentsList = " + studentsList);
    }

    @Test
    public void printStudentByFirstName() {
        List<Student> students = studentRepository.findByFirstName("Salman");
        System.out.println("students = " + students);
    }

    @Test
    public void printStudentByFirstNameContaining() {
        List<Student> students = studentRepository.findByFirstNameContaining("al");
        System.out.println("students = " + students);
    }

    @Test
    public void printStudentBasedOnGuardianName() {
        List<Student> students = studentRepository.findByGuardianName("Sam");
        System.out.println("students = " + students);
    }

    @Test
    public void printgetStudentByEmailAddress() {
        Student student = studentRepository.getStudentByEmailAddress("salman@gmail.com");
        System.out.println("student = " + student);
    }

    @Test
    public void printgetStudentFirstNameByEmailAddress() {
        String firstName = studentRepository.getFirstNameStudentByEmailAddress("salman@gmail.com");
        System.out.println("student = " + firstName);
    }


    // Native Query
    @Test
    public void printgetStudentByEmailAddressNative() {
        Student student = studentRepository.getStudentByEmailAddressNative("salman@gmail.com");
        System.out.println("student = " + student);
    }

    @Test
    public void printgetStudentByEmailAddressNativeNamedParam() {
        Student student = studentRepository.getStudentByEmailAddressNativeNamedParam("salman@gmail.com");
        System.out.println("student = " + student);
    }

    @Test
    public void updateStudentNameByEmailIdTest() {
        studentRepository.updateStudentNameByEmailId("Sal" , "salman@gmail.com");

    }
}