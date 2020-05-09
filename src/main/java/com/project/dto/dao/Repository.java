package com.project.dto.dao;


import java.util.ArrayList;


public interface Repository<T> {
    ArrayList<T> findAll();

    T create(T obj);


    // TODO: to make it as simple abstract method when all repositories will implement it
    default void putAllInDatabase(ArrayList<T> entitiesList) {
        throw new RuntimeException("Method was not implemented for specific repository");
    }

}
