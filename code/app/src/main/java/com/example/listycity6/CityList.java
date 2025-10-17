package com.example.listycity6;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CityList {
    private List<City> cities = new ArrayList<>();

    /**
     * This adds a city to the list if the city does not exist
     * @param city
     *  This is a candidate city to add
     */
    public void add(City city){
        if (cities.contains(city)){
            throw new IllegalArgumentException();
        }
        cities.add(city);
    }

    /**
     * This returns a sorted list of cities
     * @return
     *  Returns the sorted list
     */
    public List<City> getCities(){
        List<City> list = cities;
        Collections.sort(list);
        return list;
    }

    /**
     * This returns a boolean if a list has the specified city or not
     * @param city
     *  This is the city to check if it's inside the list
     * @return
     *  Returns the boolean (whether city inside list or not)
     */
    public boolean hasCity(City city){
        if(cities.contains(city)){
            return false;
        }
        else
        {
            return true;
        }
    }

    /**
     * This deletes a city inside the list
     * @param city
     *  This is the city to be deleted
     */
    public void delete(City city){
        if(cities.contains(city)){
            cities.remove(city);
        } else {
            throw new IllegalArgumentException();
        }
    }

    /**
     * This returns the number of cities inside list
     * @return
     *  Returns the size of list
     */
    public int countCities(){
        return cities.size();
    }

}