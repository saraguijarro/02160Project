package com.project.dto.dao;

import com.project.dto.Client;

import java.util.ArrayList;


public interface Repository<T> {
    T find(String id);

    ArrayList<T> findAll();

    T create(T obj);

    T update(T obj);

    int delete(String id);
}
