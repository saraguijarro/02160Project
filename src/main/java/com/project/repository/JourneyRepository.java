package com.project.repository;

import com.project.dto.Client;
import com.project.dto.JourneyEntity;
import com.project.dto.dao.DAOConnection;
import com.project.dto.dao.Repository;
import org.apache.log4j.Logger;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * The JourneyEntity repository implementation.
 */
public class JourneyRepository implements Repository<JourneyEntity> {
    final static Logger log = Logger.getLogger(JourneyEntity.class);

    @Override
    public JourneyEntity find(String id) {
        log.debug("Start method...");

        JourneyEntity obj = null;

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
    public ArrayList<JourneyEntity> findAll() {
        log.debug("Start method...");
        ArrayList<JourneyEntity> users = new ArrayList<>();

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
    public JourneyEntity create(JourneyEntity obj) {
        log.debug("Start method...");

        try {
            PreparedStatement prepared = DAOConnection.getInstance().prepareStatement(
                    " INSERT INTO journeys (origin, destination, container_id, company, description) "
                    + " VALUES(?, ?, ?, ?, ?) ", Statement.RETURN_GENERATED_KEYS);

            prepared.setString(1, obj.getOrigin());
            prepared.setString(2, obj.getDestination());
            prepared.setString(3, obj.getContainerId());
            prepared.setString(4, obj.getCompany());
            prepared.setString(5, obj.getDescription());

        } catch (SQLException e) {
            log.error("Error creating new container : " + e);
        }

        log.debug("End method.");
        return obj;
    }


    @Override
    public JourneyEntity update(JourneyEntity obj)
    {
        log.debug("Start method...");

        obj = null;

        try
        {
            PreparedStatement prepared = DAOConnection.getInstance().prepareStatement(
                    " UPDATE journeys "
                            + " SET origin =?, "
                            + " destination=?, "
                            + " description=?, "
                            + "company=?"
                            + " WHERE ID=? ");

            prepared.setString(1, obj.getOrigin());
            prepared.setString(2, obj.getDestination());
            prepared.setString(3, obj.getDescription());
            prepared.setString(4, obj.getOrigin());
            prepared.setString(5, obj.getId());


        } catch (SQLException e)
        {
            log.error("Error updating client : " + e);
        }

        log.debug("End method.");

        return obj;
    }


    @Override
    public int delete(String id) {
        log.debug("Start method...");
        int affectedRows = 0;
        try {
            PreparedStatement prepared = DAOConnection.getInstance().prepareStatement(
                    " DELETE FROM journeys "
                    + " WHERE id=? ");

            prepared.setString(1, id);

            // execute query and get the affected rows number :
            affectedRows = prepared.executeUpdate();

        } catch (SQLException e) {
            log.error("Error deleting journey : " + e);
        }

        log.debug("End method.");

        return affectedRows;
    }


    private static JourneyEntity map(ResultSet resultSet) throws SQLException {
        JourneyEntity obj = new JourneyEntity();

        obj.setCompany(resultSet.getString("company"));
        obj.setDescription(resultSet.getString("description"));
        obj.setContainerId(resultSet.getString("container_id"));
        obj.setDestination(resultSet.getString("destination"));
        obj.setOrigin(resultSet.getString("origin"));
        return obj;
    }
}
