package com.example.farmstorelocator.models;

import java.io.Serializable;
import java.util.List;

public class FarmStoreInfo implements Serializable {
    private Integer id;
    private String name;
    private Integer zip;
    private String town;
    private String street;
    private List<OpeningHours> openingHours;
    private List<Products> products;
    private String error;
    private double latitude;
    private double longitude;

    public FarmStoreInfo(Integer id, String name, Integer zip,
                         String town, String street, double latitude, double longitude,
                         List<OpeningHours> openingHours, List<Products> products) {
        this.id = id;
        this.name = name;
        this.zip = zip;
        this.town = town;
        this.street = street;
        this.openingHours = openingHours;
        this.products = products;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public FarmStoreInfo(String error) {
        this.error = error;
    }
    public boolean isError(){
        return error != null;
    }

    public String getError() {
        return error;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getZip() {
        return zip;
    }

    public void setZip(Integer zip) {
        this.zip = zip;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }


    public List<OpeningHours> getOpeningHours() {
        return openingHours;
    }

    public void setOpeningHours(List<OpeningHours> openingHours) {
        this.openingHours = openingHours;
    }

    public List<Products> getProducts() {
        return products;
    }

    public void setProducts(List<Products> products) {
        this.products = products;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }
}
