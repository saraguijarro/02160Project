package com.project.dto.dao;

import java.util.ArrayList;


public interface Repository<T> {
    T find(String id);

    ArrayList<T> findAll();

    T create(T obj);

    int delete(String id);
}
