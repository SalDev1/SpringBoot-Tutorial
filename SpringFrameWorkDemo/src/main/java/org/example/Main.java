package org.example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        System.out.println("Hello World");

        // XML Configuration to understand Dependency Injection
        // XML File must be in the class path.

        // Injecting using XML Configuration
        // XML File that you created must be passed to this ApplicationContext
//        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
//
//        // Whatever bean of doctor class type , we will fetch it
//        // make use of that particular bean.
//        Doctor doc = context.getBean(Doctor.class);
//        doc.assist();
//
//        // We are finding the class of Nurse Type
//        // We can specify the id to get a specific class.
//        Nurse nur1 = context.getBean(Nurse.class);
//        nur1.assist();
//
//        Nurse nur2 = (Nurse) context.getBean("nurse");
//        nur2.assist();
//
//        Staff staff = context.getBean(Doctor.class);
//        staff.assist();
//
//        // You can inject direct values from the beans defined in XML File.
//        Doctor doc1 = context.getBean(Doctor.class);
//        doc1.assist();
//        System.out.println(doc1.getQualification());

         // Injecting using Annotation Configuration.
//         ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
//
//         Staff staff = context.getBean(Nurse.class);
//         staff.assist();

         // Injecting with Java Configuration
//        ApplicationContext context = new AnnotationConfigApplicationContext(BeanConfig.class);
//
//        Staff staff = context.getBean(Doctor.class);
//        staff.assist();

        // Playing with singleton scope.

        // The property values
        // will be remain same for new objects we called for the same class
        // It is creating an single object for an entire application.
        // It only creates only once instance of the object and it is been
        // carried out in the entire application.
        ApplicationContext context = new AnnotationConfigApplicationContext(BeanConfig.class);

        Doctor doctor = context.getBean(Doctor.class);
        doctor.assist();
        doctor.setQualification("MBBS");
        System.out.println(doctor);

        Doctor doc1 = context.getBean(Doctor.class);
        System.out.println(doc1);
    }
}