package group3.finalproj.test;


import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import group3.finalproj.car.Car;
import group3.finalproj.car.CarType;
import group3.finalproj.car.Property;
import group3.finalproj.io.ReadData;
import group3.finalproj.util.Heap;

public class TestSort {

    public static ArrayList<Car> sortedCars = ReadData.cars;

    public static Property property;

    @Before
    public void setUp() throws Exception {
        ArrayList<CarType> types = new ArrayList<CarType>(); // Must be in sorted order!
        types.add(CarType.CargoVan);
        types.add(CarType.Coupe);
        ReadData.readCars("data/newCars.csv", types, 0, 10000);
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void test() {

        Heap.sort(sortedCars, Property.Price);
        Heap.show(sortedCars);
        System.out.println(sortedCars.get(1).get(Property.Price));

        Boolean flag = true;
        for (int i = 0; i < sortedCars.size() - 1; i++) {
            if ((int) sortedCars.get(i).get(Property.Price) > (int) sortedCars.get(i + 1).get(Property.Price) ) {
                flag = false;
            }
        }

        assertTrue(flag);
    }

}
