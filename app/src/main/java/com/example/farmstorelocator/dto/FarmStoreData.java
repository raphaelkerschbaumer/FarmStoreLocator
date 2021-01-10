package com.example.farmstorelocator.dto;

import com.example.farmstorelocator.models.OpeningHours;
import com.example.farmstorelocator.models.Products;

import java.util.List;

public class FarmStoreData {
    private Integer id;
    private String name;
    private Integer zip;
    private String town;
    private String street;
    private List<OpeningHours> openingHours;
   // private OpeningHours[] openingHours;
    private List<Products> products;
   // private Products[] products;

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

    public List<OpeningHours> getOpeningHours() {
        return openingHours;
    }

    public List<Products> getProducts() {
        return products;
    }

    public Integer getId() {
        return id;
    }
}
