package programming;

import java.util.List;

public class demo2 {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(12,9,13,4,6,2,4,12,15);
//        printAllNumbersInListStructured(numbers);
        printSquareEvenNumbersInListFunctional(numbers);

    }
    // Functional way of printing all the numbers

    private static void print(int n) {
        System.out.println(n);
    }
    private static void printAllNumbersInListStructured(List<Integer> integers) {
        // What to do ? Functional way ?
        // 1] Convert a list of numbers into a stream of numbers.
        // 2] Attach the method reference function to the stream
            // demo2::print.

//        integers.stream().forEach(demo2::print);  // Method reference
        // For each num coming from the stream , the method needs to be called.

        // Or we could directly do this , defining print method directly.
        integers.stream().forEach(System.out::println);
    }

    private static boolean checkEven(int x) {
        return x % 2 == 0;
    }

    // number -> number % 2 == 0
    private static void printAllEvenNumbersInListStructured(List<Integer> integers) {
        // Add Functional filter function

        // integers.stream().filter(demo2::checkEven).forEach(System.out::println);

        // OR , Do this down below using Lambda Expression.
        // Lambda Expression --> It is simplified representation of the method.
        integers.stream().filter(number -> number % 2 == 0).forEach(System.out::println);
    }
    // Printing square of even numbers using Functional Approach.
    private static void printSquareEvenNumbersInListFunctional(List<Integer> numbers) {
        numbers
                .stream()
                .filter(num -> num % 2 == 0)
                .map(x -> x * x)  // mapping in
                .forEach(System.out::println);  // Method of
    }
}
