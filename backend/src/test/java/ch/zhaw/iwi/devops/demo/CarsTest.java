package ch.zhaw.iwi.devops.demo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CarsTest {
    
    @Test
    void testGetId() {
        Cars car = new Cars(1, "Toyota Yaris TS");
        Assertions.assertEquals(1, car.getId(), "The car ID should be 1.");
    }

    @Test
    void testGetName() {
        Cars car = new Cars(1, "Toyota Yaris TS");
        Assertions.assertEquals("Toyota Yaris TS", car.getName(), "The car name should be 'Toyota Yaris TS'.");
    }

    @Test
    void testSetId() {
        Cars car = new Cars();
        car.setId(2);
        Assertions.assertEquals(2, car.getId(), "The car ID should be set to 2.");
    }

    @Test
    void testSetName() {
        Cars car = new Cars();
        car.setName("Suzuki Alto");
        Assertions.assertEquals("Suzuki Alto", car.getName(), "The car name should be set to 'Suzuki Alto'.");
    }
}
