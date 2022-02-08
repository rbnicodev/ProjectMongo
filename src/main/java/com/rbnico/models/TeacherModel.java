package com.rbnico.models;

import java.util.List;

public class TeacherModel {
    private String name;
    private String lastName;

    public TeacherModel() {
    }

    public TeacherModel(String name, String lastName) {
        this.name = name;
        this.lastName = lastName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

}
