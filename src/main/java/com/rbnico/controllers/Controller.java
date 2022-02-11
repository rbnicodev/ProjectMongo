package com.rbnico.controllers;

import java.util.List;

public interface Controller <S, I>{
    void create(S entity);
    S find(I id);
    void update(S entity);
    void delete(I id);
    S[] findAll();
    S[] findBy(S minMax);
}
