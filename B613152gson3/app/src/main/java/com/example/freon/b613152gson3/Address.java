package com.example.freon.b613152gson3;

import com.google.gson.annotations.SerializedName;

public class Address {
    @SerializedName("country")
    private String country;

    @SerializedName("city")
    private String sity;

    public Address(String country, String sity) {
        this.country = country;
        this.sity = sity;
    }
}
