package com.rbnico.models;

import org.bson.codecs.pojo.annotations.BsonId;

public class StudentModel extends EntityModel {
    @BsonId
    private Long id;
    private String name;
    private String lastName;
    private int age;

    public StudentModel() {
    }

    public StudentModel(Long id, String name, String lastName, int age) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.age = age;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public void setLastName(String lastName) { this.lastName = lastName; }

    public int getAge() { return age; }

    public void setAge(int age) {
        this.age = age;
    }

}
