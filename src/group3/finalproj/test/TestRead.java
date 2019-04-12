package group3.finalproj.test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import group3.finalproj.car.Car;
import group3.finalproj.car.CarType;

import group3.finalproj.car.Property;
import group3.finalproj.io.ReadData;

/**
 * JUnit test class which tests if files are read properly
 * @author Dominik Buszowiecki
 *
 */
public class TestRead {
	
	ArrayList<CarType> types = new ArrayList<CarType>(); //Must be in sorted order!
	
	public boolean isCorrectCategories(ArrayList<CarType> selectedTypes){
		int amount = 0;
		for(CarType type: selectedTypes) {
			for(Car car: ReadData.cars) {
				if(CarType.valueOf((String)car.get(Property.BodyStyle)) == type) amount++;
			}
		}
		return amount == ReadData.cars.size();
	}
	
	public boolean isInPriceRange(int minPrice, int maxPrice) {
		for(Car car: ReadData.cars) 
			if((int)car.get(Property.Price) > maxPrice || (int)car.get(Property.Price) < minPrice) return false;
		return true;
	}
	
	@Before
	public void setUp() {
		ReadData.cars.clear();
		types.clear();
	}
	/***************************************************************************
	 * Last Category - 	Last category may cause problems with scanner (Read line error)
	 ***************************************************************************/
	
	@Test
	public void testLastCategory_New() {
		types.add(CarType.Wagon);
		ReadData.readCars("data/newCars.csv", types);
		assert(isCorrectCategories(types));
		assert(isInPriceRange(0,Integer.MAX_VALUE));
	}
	
	@Test
	public void testLastCategory_Used() {
		types.add(CarType.Wagon);
		ReadData.readCars("data/usedCars.csv", types);
		assert(isCorrectCategories(types));
		assert(isInPriceRange(0,Integer.MAX_VALUE));
	}
	
	/***************************************************************************
	 * Data Tests - Tests if the dataread matches what is specified to be read
	 ***************************************************************************/
	
	@Test
	public void testTypesAndPriceRange_Used() {
		types.add(CarType.Coupe);
		types.add(CarType.Sedan);
		ReadData.readCars("data/usedCars.csv", types, 5000, 40000);
		assert(isCorrectCategories(types));
		assert(isInPriceRange(5000,40000));
	}

	@Test
	public void testTypesAndPriceRange_New() {
		types.add(CarType.Coupe);
		types.add(CarType.Sedan);
		ReadData.readCars("data/newCars.csv", types, 5000, 40000);
		assert(isCorrectCategories(types));
		assert(isInPriceRange(5000,40000));
	}
	
	/***************************************************************************
	 * 	Count tests
	 * Wwe know how many cars of a category there should added based on the datasets
	 ***************************************************************************/
	
	@Test
	public void testCargoVanCount_Used() {
		types.add(CarType.CargoVan);
		ReadData.readCars("data/usedCars.csv", types);
		assertEquals(1842, ReadData.cars.size());
	}
	
	@Test
	public void testCargoVanCount_New() {
		types.add(CarType.CargoVan);
		ReadData.readCars("data/newCars.csv", types);
		assertEquals(374, ReadData.cars.size());
	}
	
	@Test
	public void testSedanCoupeCount_New() {
		types.add(CarType.Coupe);
		types.add(CarType.Sedan);
		ReadData.readCars("data/newCars.csv", types);
		assertEquals(2414, ReadData.cars.size());
	}

	@Test
	public void testSedanCoupeCount_Used() {
		types.add(CarType.Coupe);
		types.add(CarType.Sedan);
		ReadData.readCars("data/usedCars.csv", types);
		assertEquals(27822, ReadData.cars.size());
	}
	
	@Test
	public void testSUVCount_Used() {
		types.add(CarType.SUV);
		ReadData.readCars("data/usedCars.csv", types);
		assertEquals(18077, ReadData.cars.size());
	}
	
	@Test
	public void testSUVCount_New() {
		types.add(CarType.SUV);
		ReadData.readCars("data/newCars.csv", types);
		assertEquals(2169, ReadData.cars.size());
	}
	
	/***************************************************************************
	 * 	Count tests with Price Range
	 * We should know how many cars there should be in a price range and category
	 * based on the data
	 ***************************************************************************/
	
	@Test
	public void testCrewCabPickupCountRange_Used() {
		types.add(CarType.CrewCabPickup);
		ReadData.readCars("data/usedCars.csv", types,5000, 30000);
		assertEquals(2304, ReadData.cars.size());
	}
	
	@Test
	public void testCrewCabPickupCountRange_New() {
		types.add(CarType.CrewCabPickup);
		ReadData.readCars("data/newCars.csv", types,40000, 60000);
		assertEquals(136, ReadData.cars.size());
	}
	
}
