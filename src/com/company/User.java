package com.company;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class User implements Serializable {
    private String firstName, lastName, email;
    private int id;

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public List<ContBancar> getConturi() {
        return conturi;
    }

    private List<ContBancar> conturi;

    public User(int id, String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.id = id;

        conturi = new ArrayList<>();
    }

    public void addCont(ContBancar c1) {
        conturi.add(c1);
    }

    public int getId() {
        return id;
    }
}