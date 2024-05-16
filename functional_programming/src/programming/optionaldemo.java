package programming;

import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

public class optionaldemo {
    public static void main(String[] args) {
        List<String> fruits = List.of("apple" , "banana" , "mango");

        Predicate<? super String> predicate = fruit -> fruit.startsWith("n");

        // The reason why we use optional is that what we are looking for may or may not
        // exist in the array and to handle the null point exception we use this.
        Optional<String> optional = fruits.stream().filter(predicate).findFirst();

        // Optional is a container object which may or may not a non-Null value.
        // If no value exists then , it returns an empty value.

        System.out.println(optional);
        System.out.println(optional.isEmpty());
        System.out.println(optional.isPresent());
        System.out.println(optional.get());
    }
}
