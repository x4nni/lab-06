package com.example.listycity6;


/**
 * This is a class that defines a City
 */
public class City implements Comparable {

    private String city;
    private String province;

    City(String city,String province){
        this.city = city;
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public String getProvince() {
        return province;
    }

    @Override
    public int compareTo(Object o){
        City city = (City) o;
        return this.city.compareTo(city.getCity());
    }


}
