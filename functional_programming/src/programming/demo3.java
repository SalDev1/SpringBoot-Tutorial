package programming;

import java.util.List;

public class demo3 {
    public static void main(String[]args) {
        List<Integer> numbers = List.of(1,2,3,4,5,6);
        List<String> courses = List.of("Spring" , "Spring Boot" , "API" , "Microservices");

        printCubeOddNumbersInListFunctional(numbers);
        printCourseNameWithLength(courses);
    }

    public static void printAllOddElements(List<Integer> numbers) {
        numbers.stream()
                .filter(number ->number % 2 == 1).forEach(System.out::println);
    }

    public static void printAllCourses(List<String> courses) {
        courses.stream().forEach(System.out::println);
    }
    public static void printAllCoursesWithSpring(List<String> courses) {
        courses.stream().filter(course -> course.contains("Spring")).forEach(System.out::println);
    }

    public static void printCourseNameWithLength(List<String> courses) {
        courses.stream()
                .map(course -> course + ' ' + course.length())
                .forEach(System.out::println);
    }

    public static void printAllCourseWith4Words(List<String> courses) {
        courses.stream().filter(course -> course.length() >= 4)
                .forEach(System.out::println);
    }

    private static void printCubeOddNumbersInListFunctional(List<Integer> numbers) {
        numbers
                .stream()
                .filter(num -> num % 2 == 1)
                .map(x -> x * x * x)  // mapping in
                .forEach(System.out::println);  // Method of
    }
}
