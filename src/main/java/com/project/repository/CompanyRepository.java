package com.project.repository;

import com.google.common.hash.Hashing;

import com.project.dto.LogisticCompany;
import com.project.dto.dao.DAOConnection;
import com.project.dto.dao.Repository;
import org.apache.log4j.Logger;

import java.nio.charset.StandardCharsets;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.UUID;

/**
 * The CompanyRepository repository implementation.
 */
public class CompanyRepository implements Repository<LogisticCompany> {
    final static Logger log = Logger.getLogger(CompanyRepository.class);

    @Override
    public LogisticCompany find(String id) {
        log.debug("Start method...");

        LogisticCompany obj = null;

        try {
            PreparedStatement prepared = DAOConnection.getInstance().prepareStatement(
                    "SELECT * FROM company WHERE id=?");
            prepared.setString(1, id);
            ResultSet result = prepared.executeQuery();

            if (result.first()) {
                obj = map(result);
            }
        } catch (SQLException e) {
            log.error("Error finding user : " + e);
        }

        log.debug("End method.");
        return obj;
    }

    public LogisticCompany loginUser(String name, String password) {
        log.debug("Start method...");

        LogisticCompany obj = null;

        try {
            PreparedStatement prepared = DAOConnection.getInstance().prepareStatement(
                    "SELECT * FROM company WHERE name=?");
            prepared.setString(1, name);
            ResultSet result = prepared.executeQuery();

            if (result.first()) {
                obj = map(result);
            }
        } catch (SQLException e) {
            log.error("Error finding user : " + e);
        }

        if (obj == null || !obj.getPassword().equals(hashString(password))) {
            return null;
        }

        log.debug("End method.");
        return obj;
    }

    @Override
    public ArrayList<LogisticCompany> findAll() {
        log.debug("Start method...");
        ArrayList<LogisticCompany> users = new ArrayList<>();

        try {
            PreparedStatement prepared = DAOConnection.getInstance().prepareStatement(
                    "SELECT * FROM company");

            ResultSet result = prepared.executeQuery();
            while (result.next()) {
                users.add(map(result));
            }
        } catch (SQLException e) {
            log.error("Error finding users : " + e);
        }

        log.debug("End method.");
        return users;
    }

    @Override
    public LogisticCompany create(LogisticCompany obj) {
        log.debug("Start method...");

        try {
            PreparedStatement prepared = DAOConnection.getInstance().prepareStatement(
                    " INSERT INTO company (id, name, password, details) "
                            + " VALUES(?, ?, ?, ?) ", Statement.RETURN_GENERATED_KEYS);

            prepared.setString(1, UUID.randomUUID().toString());
            prepared.setString(2, obj.getName());
            prepared.setString(3, hashString(obj.getPassword()));
            prepared.setString(4, obj.getDetails());

            prepared.executeUpdate();
        } catch (SQLException e) {
            log.error("Error creating new user : " + e);
        }

        log.debug("End method.");
        return obj;
    }

    private String hashString(String string) {
        return Hashing.sha256()
                .hashString(string, StandardCharsets.UTF_8)
                .toString();
    }


    private static LogisticCompany map(ResultSet resultSet) throws SQLException {
        LogisticCompany obj = new LogisticCompany();

        obj.setId(resultSet.getString("id"));
        obj.setName(resultSet.getString("name"));
        obj.setPassword(resultSet.getString("password"));
        obj.setDetails(resultSet.getString("details"));

        return obj;
    }
}
