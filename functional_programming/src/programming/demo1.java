package programming;

import java.util.List;

public class demo1 {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(12,9,13,4,6,2,4,12,15);

//        printAllNumbersInListStructured(numbers);
        printAllEvenNumbersInListStructured(numbers);
    }

    // Structured Way of printing the numbers.
    private static void printAllNumbersInListStructured(List<Integer> integers) {
        for(Integer i : integers) {
            System.out.println(i);
        }
    }

    private static void printAllEvenNumbersInListStructured(List<Integer> integers) {
        for(Integer i : integers) {
            if(i % 2 == 0) {
                System.out.println(i);
            }
        }
    }
}

/*
*  One way to declare list would be
*  List<String> places = Arrays.asList("Buenos Aires", "Córdoba", "La Plata");
* */