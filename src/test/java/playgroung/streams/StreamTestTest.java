package playgroung.streams;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;
import static java.util.Arrays.asList;

public class StreamTestTest {

    @Test
    public void countCars() {
        List<Car> cars = Arrays.asList(
                new Car("Porshe", asList("3-doors", "red", "cabriolet")),
                new Car("BMW", asList("5-doors", "black", "climat-control")),
                new Car("Mersedes", asList("5-doors", "black", "max-complectation")));
        StreamTest streamTest = new StreamTest();
        assertEquals(2, streamTest.countCars(cars, 5));
        assertEquals(1, streamTest.countCars(cars, 3));

    }
}