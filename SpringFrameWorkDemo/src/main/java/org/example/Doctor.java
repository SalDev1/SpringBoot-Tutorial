package org.example;

// Implement injection using XML Configuration
//public class Doctor implements Staff {
//    // Have a setter and getter to use a feature or method.
//    private String qualification;
//
////    private Nurse nurse;
//    public void assist() {
//        System.out.println("Doctor is assisting to the patients.");
//    }
//    public String getQualification() {
//        return qualification;
//    }
//    public void setQualification(String qualification) {
//        this.qualification = qualification;
//    }
//}

import org.springframework.stereotype.Component;

// Implement Injection using Annotation Configuration

// Defining the class as a component and define the bean
// in the xml document.
//@Component
//public class Doctor implements Staff {
//    public void assist() {
//        System.out.println("Doctor is assisting");
//    }
//}

// Learning about the Singleton Scope

import org.springframework.context.annotation.Scope;

import javax.annotation.PostConstruct;

@Component
@Scope(scopeName = "prototype")
public class Doctor implements Staff {
    @Override
    public String toString() {
        return "Doctor{" +
                "qualification='" + qualification + '\'' +
                '}';
    }
    private String qualification;

    public void assist() {
        System.out.println("Doctor is assisting");
    }
    public String getQualification() {
        return qualification;
    }
    public void setQualification(String qualification) {
        this.qualification = qualification;
    }
    public void setBeanName(String name) {
        System.out.println("Set Bean name method is called");
    }
    @PostConstruct
    public void postConstruct() {
        System.out.println("Post Construct Method is called");
    }
}

