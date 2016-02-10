package terminaloperations;

import common.Dish;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static common.Dish.menu;
/**
 * Borrowed from
 * https://github.com/java8/Java8InAction
 *
 * Java 8 in Action
 * Lambdas, streams, and functional-style programming
 * Raoul-Gabriel Urma, Mario Fusco, and Alan Mycroft
 */
public class Reducing {

    public static void main(String... args) {

        List<Integer> numbers = Arrays.asList(3, 4, 5, 1, 2);
        int sum = numbers.stream().reduce(0, (a, b) -> a + b);
        System.out.println(sum);

        int sum2 = numbers.stream().reduce(0, Integer::sum);
        System.out.println(sum2);

        int max = numbers.stream().reduce(0, (a, b) -> Integer.max(a, b));
        System.out.println(max);

        Optional<Integer> min = numbers.stream().reduce(Integer::min);
        min.ifPresent(System.out::println);

        int calories = menu.stream()
                .map(Dish::getCalories)
                .reduce(0, Integer::sum);
        System.out.println("Number of calories:" + calories);
    }
}
