package optionals;

import java.util.Optional;
/**
 * Borrowed from
 * https://github.com/java8/Java8InAction
 *
 * Java 8 in Action
 * Lambdas, streams, and functional-style programming
 * Raoul-Gabriel Urma, Mario Fusco, and Alan Mycroft
 */
public class Car {

    private Optional<Insurance> insurance;

    public Optional<Insurance> getInsurance() {
        return insurance;
    }
}
