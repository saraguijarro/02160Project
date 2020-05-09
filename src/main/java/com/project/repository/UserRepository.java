//package com.project.repository;
//
//import com.google.common.hash.Hashing;
//
//import com.project.dto.UserEntity;
//import com.project.dto.UserType;
//import com.project.dto.dao.DAOConnection;
//import com.project.dto.dao.Repository;
//import org.apache.log4j.Logger;
//
//import java.nio.charset.StandardCharsets;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.sql.Statement;
//import java.util.ArrayList;
//import java.util.UUID;
//
///**
// * The UserEntity repository implementation.
// */
//public class UserRepository implements Repository<UserEntity> {
//    final static Logger log = Logger.getLogger(UserEntity.class);
//
//    @Override
//    public UserEntity find(String id) {
//        log.debug("Start method...");
//
//        UserEntity obj = null;
//
//        try {
//            PreparedStatement prepared = DAOConnection.getInstance().prepareStatement(
//                    "SELECT * FROM users WHERE id=?");
//            prepared.setString(1, id);
//            ResultSet result = prepared.executeQuery();
//
//            if (result.first()) {
//                obj = map(result);
//            }
//        } catch (SQLException e) {
//            log.error("Error finding user : " + e);
//        }
//
//        log.debug("End method.");
//        return obj;
//    }
//
//    public UserEntity loginUser(String email, String password) {
//        log.debug("Start method...");
//
//        UserEntity obj = null;
//
//        try {
//            PreparedStatement prepared = DAOConnection.getInstance().prepareStatement(
//                    "SELECT * FROM users WHERE email=?");
//            prepared.setString(1, email);
//            ResultSet result = prepared.executeQuery();
//
//            if (result.first()) {
//                obj = map(result);
//            }
//        } catch (SQLException e) {
//            log.error("Error finding user : " + e);
//        }
//
//        if (obj == null || !obj.getPassword().equals(hashString(password))) {
//             return null;
//        }
//
//        log.debug("End method.");
//        return obj;
//    }
//
//    @Override
//    public ArrayList<UserEntity> findAll() {
//        log.debug("Start method...");
//        ArrayList<UserEntity> users = new ArrayList<>();
//
//        try {
//            PreparedStatement prepared = DAOConnection.getInstance().prepareStatement(
//                    "SELECT * FROM users");
//
//            ResultSet result = prepared.executeQuery();
//            while (result.next()) {
//                users.add(map(result));
//            }
//        } catch (SQLException e) {
//            log.error("Error finding users : " + e);
//        }
//
//        log.debug("End method.");
//        return users;
//    }
//
//    @Override
//    public UserEntity create(UserEntity obj) {
//        log.debug("Start method...");
//
//        try {
//            PreparedStatement prepared = DAOConnection.getInstance().prepareStatement(
//                    " INSERT INTO users (id, email, password, user_type) "
//                    + " VALUES(?, ?, ?, ?) ", Statement.RETURN_GENERATED_KEYS);
//
//            prepared.setString(1, UUID.randomUUID().toString());
//            prepared.setString(2, obj.getEmail());
//            prepared.setString(3, hashString(obj.getPassword()));
//            prepared.setString(4, obj.getUserType().getUrl());
//
//        } catch (SQLException e) {
//            log.error("Error creating new user : " + e);
//        }
//
//        log.debug("End method.");
//        return obj;
//    }
//
//    @Override
//    public UserEntity update(UserEntity obj) {
//        throw new UnsupportedOperationException();
//    }
//
//    private String hashString(String string) {
//        return Hashing.sha256()
//                .hashString(string, StandardCharsets.UTF_8)
//                .toString();
//    }
//
//
//    @Override
//    public int delete(String id) {
//        log.debug("Start method...");
//
//        int affectedRows = 0;
//
//        try {
//            PreparedStatement prepared = DAOConnection.getInstance().prepareStatement(
//                    " DELETE FROM users "
//                    + " WHERE id=? ");
//
//            prepared.setString(1, id);
//
//            // execute query and get the affected rows number :
//            affectedRows = prepared.executeUpdate();
//
//        } catch (SQLException e) {
//            log.error("Error deleting user : " + e);
//        }
//
//        log.debug("End method.");
//
//        return affectedRows;
//    }
//
//
//    private static UserEntity map(ResultSet resultSet) throws SQLException {
//        UserEntity obj = new UserEntity();
//
//        obj.setId(resultSet.getLong("id"));
//        obj.setEmail(resultSet.getString("email"));
//        obj.setPassword(resultSet.getString("password"));
//        obj.setUserType(UserType.valueOf(resultSet.getString("user_type")));
//
//        return obj;
//    }
//}
