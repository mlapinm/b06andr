package com.example.freon.b613132gson1;

import com.google.gson.annotations.SerializedName;

public class Employee {

    @SerializedName("first_name")
    private String firstName;

    @SerializedName("age")
    private int age;

    @SerializedName("mail")
    private String mail;

    public Employee(String firstName, int age, String mail) {
        this.firstName = firstName;
        this.age = age;
        this.mail = mail;
    }
}
