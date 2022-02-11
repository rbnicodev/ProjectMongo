package com.rbnico.models;

import org.bson.codecs.pojo.annotations.BsonId;

import javax.persistence.*;

@Entity
public class Student extends EntityModel {
    @BsonId //MONGO
    @Id //JPA
    @GeneratedValue
    private int id;
    private String name;
    private String lastname;
    private int age;

    @ManyToOne
    private Teacher teacher;

    public Student() {
    }

    public Student(int id, String name, String lastname, int age) {
        this.id = id;
        this.name = name;
        this.lastname = lastname;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lastname='" + lastname + '\'' +
                ", age=" + age +
                ", teacher=" + teacher +
                '}';
    }
}
