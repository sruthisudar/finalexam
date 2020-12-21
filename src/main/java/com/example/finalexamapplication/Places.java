package com.example.finalexamapplication;

public class Places {
    String country;
    String capitalCity;
    String visits;
    double price;
    String placeImg;


    public Places(String country, String capitalCity,String visits, double price, String placeImg) {
        this.country = country;
        this.capitalCity = capitalCity;
        this.visits = visits;
        this.price = price;
        this.placeImg = placeImg;
    }

    public String getCountry() {
        return country;
    }

    public String getCapitalCity() {
        return capitalCity;
    }

    public String getVisits() {
        return visits;
    }

    public double getPrice() {
        return price;
    }

    public String getPlaceImg() {
        return placeImg;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setCapitalCity(String capitalCity) {
        this.capitalCity = capitalCity;
    }

    public void setVisits(String visits) {
        this.visits = visits;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setPlaceImg(String placeImg) {
        this.placeImg = placeImg;
    }
}

