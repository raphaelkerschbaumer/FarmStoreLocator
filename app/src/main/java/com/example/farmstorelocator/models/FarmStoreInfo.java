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
    //private OpeningHours[] openingHours;
    private List<Products> products;
    //private Products[] products;
    private String error;

    public FarmStoreInfo(Integer id, String name, Integer zip,
                         String town, String street,
                         List<OpeningHours> openingHours, List<Products> products) {
        this.id = id;
        this.name = name;
        this.zip = zip;
        this.town = town;
        this.street = street;
        this.openingHours = openingHours;
        this.products = products;
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

    //public OpeningHours[] getOpeningHours() {
    //    return openingHours;
    //}
    public List<OpeningHours> getOpeningHours() {
        return openingHours;
    }

    public void setOpeningHours(List<OpeningHours> openingHours) {
        this.openingHours = openingHours;
    }

   //public void setOpeningHours(OpeningHours[] openingHours) {
   //     this.openingHours = openingHours;
   //}

    public List<Products> getProducts() {
        return products;
    }

    public void setProducts(List<Products> products) {
        this.products = products;
    }

   // public Products[] getProducts() {
   //     return products;
   // }
//
   // public void setProducts(Products[] products) {
   //     this.products = products;
   // }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
