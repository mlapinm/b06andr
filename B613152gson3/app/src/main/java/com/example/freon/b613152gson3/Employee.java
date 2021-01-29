package com.example.freon.b613152gson3;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Employee {

    @SerializedName("first_name")
    private String firstName;

    @SerializedName("age")
    private int age;

    @SerializedName("mail")
    private String mail;

    @SerializedName("address")
    private Address address;

    @SerializedName("family")
    private List<FamilyMember> familys;

    public Employee(String firstName, int age, String mail, Address address, List<FamilyMember> familys) {
        this.firstName = firstName;
        this.age = age;
        this.mail = mail;
        this.address = address;
        this.familys = familys;
    }
}
