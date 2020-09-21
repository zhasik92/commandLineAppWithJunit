package playgroung.streams;

import java.util.Collection;

public class StreamTest {

    public long countCars(Collection<Car> cars, int numberOfDoors) {
        long total = cars.stream().flatMap(
                c -> c.getParameters().stream())
                .filter(c -> c.startsWith((numberOfDoors + "-"))).count();// total number of 5-doors cars
        System.out.println("Total number of 5 doors cars is: " + total);
        return total;
    }


}