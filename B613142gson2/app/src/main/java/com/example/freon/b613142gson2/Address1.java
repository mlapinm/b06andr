package com.example.freon.b613142gson2;

import com.google.gson.annotations.SerializedName;

public class Address1 {

    @SerializedName("country")
    private String country;

    @SerializedName("city")
    private String city;

    public Address1(String country, String city) {
        this.country = country;
        this.city = city;
    }
}
