package com.example.freon.b613142gson2;

import android.location.Address;

import com.google.gson.annotations.SerializedName;

public class Employee {

    @SerializedName("first_name")
    private String firstName;

    @SerializedName("age")
    private int age;

    @SerializedName("mail")
    private String mail;

    @SerializedName("address")
    private Address1 address;

    public Employee(String firstName, int age, String mail, Address1 address) {
        this.firstName = firstName;
        this.age = age;
        this.mail = mail;
        this.address = address;
    }
}
