package com.project.repository;

import com.project.dto.Jou;
import com.project.dto.dao.DAOConnection;
import com.project.dto.dao.Repository;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;

/**
 * The Journey repository implementation.
 */
public class JourneyRepository implements Repository<Jou> {
    final static Logger log = Logger.getLogger(Jou.class);


    @Override
    public ArrayList<Jou> findAll() {
        log.debug("Start method...");
        ArrayList<Jou> users = new ArrayList<>();

        try {
            PreparedStatement prepared = DAOConnection.getInstance().prepareStatement(
                    "SELECT * FROM journeys");

            ResultSet result = prepared.executeQuery();
            while (result.next()) {
                users.add(map(result));
            }
        } catch (SQLException e) {
            log.error("Error finding journeys : " + e);
        }

        log.debug("End method.");
        return users;
    }


    @Override
    public Jou create(Jou obj) {
        log.debug("Start method...");

        try {
            PreparedStatement prepared = DAOConnection.getInstance().prepareStatement(
                    " INSERT INTO journeys (id, origin, destination, company, container_id, client_id, description, ongoing) " +
                            " VALUES(?, ?, ?, ?, ?, ?, ?, ?) ", Statement.RETURN_GENERATED_KEYS);

            prepared.setString(1, obj.getJourneyID());
            prepared.setString(2, obj.getOriginPort());
            prepared.setString(3, obj.getDestination());
            prepared.setString(4, obj.getCompany());
            prepared.setString(5, obj.getContainerID());
            prepared.setString(6, obj.getClientID());
            prepared.setString(7, obj.getContent());
            prepared.setBoolean(8, obj.isOnGoing());

            prepared.executeUpdate();
        } catch (SQLException e) {
            log.error("Error creating new journey : " + e);
        }

        log.debug("End method.");
        return obj;
    }



    @Override
    public void putAllInDatabase(ArrayList<Jou> entitiesList) {
        log.debug("Start method...");

        try
        {
            PreparedStatement prepared = DAOConnection.getInstance().prepareStatement(
                    " TRUNCATE TABLE journeys");
            prepared.executeUpdate();
        } catch (SQLException e)
        {
            log.error("Error truncating the table: " + e);
        }

        entitiesList.forEach(this::create);

        log.debug("End method.");

    }
    /**
     * Map the current row of the given ResultSet to an Object.
     *
     */

    public static Jou map(ResultSet resultSet) throws SQLException {
        Jou obj = new Jou();

        obj.setJourneyID(resultSet.getString("id"));
        obj.setCompany(resultSet.getString("company"));
        obj.setContent(resultSet.getString("description"));
        obj.setOnGoing(resultSet.getBoolean("ongoing"));
        obj.setContainerID(resultSet.getString("container_id"));
        obj.setClientID(resultSet.getString("client_id"));
        obj.setDestination(resultSet.getString("destination"));
        obj.setOriginPort(resultSet.getString("origin"));
        return obj;
    }
}