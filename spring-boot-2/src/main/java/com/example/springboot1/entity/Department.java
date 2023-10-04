package com.example.springboot1.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.*;
import lombok.*;
import org.hibernate.validator.constraints.Length;


// In order for department to interact with JPA and
// database, we use entity annotation.


// Use Lombok library / plugin , we are able to easily replace the
// boilerplate code with predefined annotation that does the same job.
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Department {
    // In SQL , every tuple has one unique key.
    @Id
    @GeneratedValue(strategy =  GenerationType.AUTO)
    // DepartmentId
    private long departmentId;

    // Name of the department.

    // These are some of the validations method of Hibernate.
    @NotBlank(message = "Please add Department name")
//    @Length(max = 5 , min = 1)
//    @Size(max =10 , min = 0)
//    @Email
//    @Positive
//    @Negative
//    @PositiveOrZero
//    @NegativeOrZero
//    @Future
//    @FutureOrPresent
    private String departmentName;
    // Department Address.
    private String departmentAddress;
    // Code of the department.
    private String departmentCode;
}
//    public Department() {
//
//    }
//    public long getDepartmentId() {
//        return departmentId;
//    }
//
//    public void setDepartmentId(long departmentId) {
//        this.departmentId = departmentId;
//    }
//
//    public String getDepartmentName() {
//        return departmentName;
//    }
//
//    public void setDepartmentName(String departmentName) {
//        this.departmentName = departmentName;
//    }
//
//    public String getDepartmentAddress() {
//        return departmentAddress;
//    }
//
//    public void setDepartmentAddress(String departmentAddress) {
//        this.departmentAddress = departmentAddress;
//    }
//    public String getDepartmentCode() {
//        return departmentCode;
//    }
//
//    public void setDepartmentCode(String departmentCode) {
//        this.departmentCode = departmentCode;
//    }
//
//    public Department(long departmentId, String departmentName, String departmentAddress, String departmentCode) {
//        this.departmentId = departmentId;
//        this.departmentName = departmentName;
//        this.departmentAddress = departmentAddress;
//        this.departmentCode = departmentCode;
//    }
//
//    @Override
//    public String toString() {
//        return "Department{" +
//                "departmentId=" + departmentId +
//                ", departmentName='" + departmentName + '\'' +
//                ", departmentAddress='" + departmentAddress + '\'' +
//                ", departmentCode='" + departmentCode + '\'' +
//                '}';
//    }
