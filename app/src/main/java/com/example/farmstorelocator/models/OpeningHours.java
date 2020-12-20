package com.example.farmstorelocator.models;

public class OpeningHours {
    private String day;
    private String hours;

    public OpeningHours(String day, String hours) {
        this.day = day;
        this.hours = hours;
    }

    public String getHours() {
        return hours;
    }

    public void setHours(String hours) {
        this.hours = hours;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }
}
