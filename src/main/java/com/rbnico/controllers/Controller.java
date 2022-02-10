package com.rbnico.controllers;

public interface Controller <S, I>{
    void create();
    void find();
    void update();
    void delete();
    void findAll();
    void findBy();
}
