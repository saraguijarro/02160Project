package com.project.repository;

import com.project.dto.Jou;
import com.project.dto.dao.DAOConnection;
import com.project.dto.dao.Repository;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;

/**
 * The JourneyEntity repository implementation.
 */
public class JourneyRepository implements Repository<Jou> {
    final static Logger log = Logger.getLogger(Jou.class);

    @Override
    public Jou find(String id) {
        log.debug("Start method...");

        Jou obj = null;

        try {
            PreparedStatement prepared = DAOConnection.getInstance().prepareStatement(
                    "SELECT * FROM journeys WHERE id=?");
            prepared.setString(1, id);
            ResultSet result = prepared.executeQuery();

            if (result.first()) {
                obj = map(result);
            }
        } catch (SQLException e) {
            log.error("Error finding container : " + e);
        }

        log.debug("End method.");
        return obj;
    }

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


//    public void getContainerRepository(){
//        ContainerRepository containerRepository = new ContainerRepository();
//        containerRepository.findAll();
//    }

    @Override
    public Jou create(Jou obj) {
        log.debug("Start method...");

        try {
            PreparedStatement prepared = DAOConnection.getInstance().prepareStatement(
                    " INSERT INTO journeys (id, origin, destination, company, container, description, ongoing) " +
                            " VALUES(?, ?, ?, ?, ?, ?, ?) ", Statement.RETURN_GENERATED_KEYS);

            prepared.setString(1, obj.getJourneyID());
            prepared.setString(2, obj.getOriginPort());
            prepared.setString(3, obj.getDestination());
            prepared.setString(4, obj.getCompany());
            prepared.setString(6, obj.getContent());
            prepared.setBoolean(7, obj.isOnGoing());

        } catch (SQLException e) {
            log.error("Error creating new container : " + e);
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


    private static Jou map(ResultSet resultSet) throws SQLException {
        Jou obj = new Jou();

        obj.setCompany(resultSet.getString("company"));
        obj.setContent(resultSet.getString("description"));
        obj.setOnGoing(resultSet.getBoolean("ongoing"));
        obj.setDestination(resultSet.getString("destination"));
        obj.setOriginPort(resultSet.getString("origin"));
        return obj;
    }
}
