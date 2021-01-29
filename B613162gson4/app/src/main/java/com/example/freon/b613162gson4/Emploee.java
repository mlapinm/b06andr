package com.example.freon.b613162gson4;

import com.google.gson.annotations.Expose;

public class Emploee {
    @Expose
    private String firstName;

    @Expose(serialize = false)
    private int age;

    @Expose(deserialize = false)
    private String mail;

    private String password;

    public Emploee(String firstName, int age, String mail, String password) {
        this.firstName = firstName;
        this.age = age;
        this.mail = mail;
        this.password = password;
    }
}
