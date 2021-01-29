package com.example.freon.b613152gson3;

import com.google.gson.annotations.SerializedName;

public class FamilyMember {
    @SerializedName("Role")
    private String role;

    @SerializedName("age")
    private int age;

    public FamilyMember(String role, int age) {
        this.role = role;
        this.age = age;
    }
}
