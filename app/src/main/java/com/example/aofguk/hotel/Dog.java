package com.example.aofguk.hotel;

import java.util.ArrayList;
import java.util.List;



public class Dog {
    private int resId;
    private int resId2;
    private String breed;
    private String description;
    private double lat;
    private double lon;

    List<Dog> dogs = new ArrayList<>();

    Dog() {

    }

    Dog(int resId,int resId2, String breed, String description, Double lat, Double lon) {
        this.resId = resId;
        this.resId2 = resId2;
        this.breed = breed;
        this.description = description;
        this.lat = lat;
        this.lon = lon;
    }
    Dog(int resId, String breed) {
        this.resId = resId;
        this.breed = breed;

    }


    public int getResId() {
        return resId;
    }

    public void setResId(int resId) {
        this.resId = resId;
    }

    public int getResId2() {
        return resId2;
    }

    public void setResId2(int resId2) {
        this.resId2 = resId2;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Dog> getDogs() {
        return dogs;
    }

    public void setDogs(List<Dog> dogs) {
        this.dogs = dogs;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLon() {
        return lon;
    }

    public void setLon(double lon) {
        this.lon = lon;
    }
}
