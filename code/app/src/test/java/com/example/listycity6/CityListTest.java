package com.example.listycity6;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CityListTest {
    private CityList mockCityList() {
        CityList cityList = new CityList();
        cityList.add(mockCity());
        return cityList;
    }

    private City mockCity() {
        return new City("Edmonton", "Alberta");
    }

    @Test
    void testAdd() {
        CityList cityList = mockCityList();
        assertEquals(1, cityList.getCities().size());
        City city = new City("Regina", "Saskatchewan");
        cityList.add(city);
        assertEquals(2, cityList.getCities().size());
        assertTrue(cityList.getCities().contains(city));
    }

    @Test
    void testAddException() {
        CityList cityList = mockCityList();
        City city = new City("Yellowknife", "Northwest Territories");
        cityList.add(city);
        assertThrows(IllegalArgumentException.class, () -> {
            cityList.add(city);
        });
    }

    @Test
    void testGetCities() {
        CityList cityList = mockCityList();
        // This line checks if the first city in the cityList (retrieved by cityList.getCities().get(0))
        // is the same as the city returned by mockCity()
        assertEquals(0, mockCity().compareTo(cityList.getCities().get(0)));
        // This pushes down the original city
        City city = new City("Charlottetown", "Prince Edward Island");
        cityList.add(city);
        // Now the original city should be at position 1
        assertEquals(0, city.compareTo(cityList.getCities().get(0)));
        assertEquals(0, mockCity().compareTo(cityList.getCities().get(1)));
    }

    @Test
    void testHasCity(){
        CityList cityList = mockCityList();
        City city = new City("Calgary","Alberta");
        cityList.add(city);
        assertEquals(0, city.compareTo(cityList.getCities().get(0)));
    }

    @Test
    void testDelete(){
        CityList cityList = mockCityList();
        // This line first checks if there is one city inside mockCityList
        assertEquals(1, cityList.getCities().size());
        // Next two lines add a new city inside cityList
        City city = new City("Saskatoon","Saskatchewan");
        cityList.add(city);
        // We then check if the size of the list increases
        assertEquals(2, cityList.getCities().size());
        // Then we remove the city, check the new size, and also check if the city is in list
        cityList.delete(city);
        assertEquals(1, cityList.getCities().size());
        assertFalse(cityList.getCities().contains(city));
    }

    @Test
    void testDeleteException(){
        CityList cityList = mockCityList();
        assertEquals(1, cityList.getCities().size());
        City city = new City("Saskatoon","Saskatchewan");
        assertThrows(IllegalArgumentException.class, () -> {
            cityList.delete(city);
        });
    }

    @Test
    void testCountCities(){
        CityList cityList = mockCityList();
        assertEquals(1, cityList.getCities().size());
        City city = new City("Toronto","Ontario");
        City city1 = new City("Quebec City", "Quebec");
        cityList.add(city);
        cityList.add(city1);
        assertEquals(3, cityList.getCities().size());
    }
}