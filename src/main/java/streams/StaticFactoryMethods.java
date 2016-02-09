package streams;

import java.time.Clock;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class StaticFactoryMethods {


    public void someStreams() {


        Stream<Integer> integerStream = Stream.of(1, 2, 3, 4, 5);


        IntStream intStream = IntStream.rangeClosed(0, 100);

        LongStream longStream = Stream.generate(() -> Clock.systemUTC().millis()).mapToLong(Long::longValue);
    }

}
