package com.project.dto.dao;


import java.util.ArrayList;


public interface Repository<T> {

//    method to fetch all the data from the database
    ArrayList<T> findAll();

//    method to insert the data inside the tables
    T create(T obj);

    // TODO: to make it as simple abstract method when all repositories will implement it
    // method to save all the data in the database from the classes
    default void putAllInDatabase(ArrayList<T> entitiesList) {
        throw new RuntimeException("Method was not implemented for specific repository");
    }

}
