package com.example.farmstorelocator.models;

import java.io.Serializable;

public class Products implements Serializable {
    private String type;
    private Double costPerUnit;
    private String unit;

    public Products(String type, Double costPerUnit, String unit) {
        this.type = type;
        this.costPerUnit = costPerUnit;
        this.unit = unit;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Double getCostPerUnit() {
        return costPerUnit;
    }

    public void setCostPerUnit(Double costPerUnit) {
        this.costPerUnit = costPerUnit;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }
}
