package com.example.farmstorelocator.dto;

import com.example.farmstorelocator.models.OpeningHours;
import com.example.farmstorelocator.models.Products;

public class FarmStoreData {
    private Integer id;
    private String name;
    private Integer zip;
    private String town;
    private String street;
    private OpeningHours[] openingHours;
    private Products[] products;

    public String getName() {
        return name;
    }

    public Integer getZip() {
        return zip;
    }

    public String getTown() {
        return town;
    }

    public String getStreet() {
        return street;
    }

    public OpeningHours[] getOpeningHours() {
        return openingHours;
    }

    public Products[] getProducts() {
        return products;
    }

    public Integer getId() {
        return id;
    }
}
