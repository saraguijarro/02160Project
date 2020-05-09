package com.project.repository;

import com.project.dto.ContainerStatusEntity;
import com.project.dto.dao.DAOConnection;
import com.project.dto.dao.Repository;
import org.apache.log4j.Logger;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.UUID;

/**
 * The ContainerStatusEntity repository implementation.
 */
public class ContainerStatusRepository implements Repository<ContainerStatusEntity> {
    final static Logger log = Logger.getLogger(ContainerStatusEntity.class);

    @Override
    public ContainerStatusEntity find(String id) {
        log.debug("Start method...");

        ContainerStatusEntity obj = null;

        try {
            PreparedStatement prepared = DAOConnection.getInstance().prepareStatement(
                    "SELECT * FROM container_status WHERE id=?");
            prepared.setString(1, id);
            ResultSet result = prepared.executeQuery();

            if (result.first()) {
                obj = map(result);
            }
        } catch (SQLException e) {
            log.error("Error finding container status : " + e);
        }

        log.debug("End method.");
        return obj;
    }

    @Override
    public ArrayList<ContainerStatusEntity> findAll() {
        log.debug("Start method...");
        ArrayList<ContainerStatusEntity> users = new ArrayList<>();

        try {
            PreparedStatement prepared = DAOConnection.getInstance().prepareStatement(
                    "SELECT * FROM container_status");

            ResultSet result = prepared.executeQuery();
            while (result.next()) {
                users.add(map(result));
            }
        } catch (SQLException e) {
            log.error("Error finding container statuses : " + e);
        }

        log.debug("End method.");
        return users;
    }

    @Override
    public ContainerStatusEntity create(ContainerStatusEntity obj) {
        log.debug("Start method...");

        try {
            PreparedStatement prepared = DAOConnection.getInstance().prepareStatement(
                    " INSERT INTO container_status (id, temperature, humidity, pressure, journey_id, container_id) "
                    + " VALUES(?, ?, ?, ?, ?, ?) ", Statement.RETURN_GENERATED_KEYS);
            prepared.setString(1, UUID.randomUUID().toString());
            prepared.setString(2, obj.getTemperature());
            prepared.setString(3, obj.getHumidity());
            prepared.setString(4, obj.getPressure());
            prepared.setString(5, obj.getJourneyId());
            prepared.setString(6, obj.getContainerId());

        } catch (SQLException e) {
            log.error("Error creating new container status : " + e);
        }

        log.debug("End method.");
        return obj;
    }

    @Override
    public ContainerStatusEntity update(ContainerStatusEntity obj) {
        throw new UnsupportedOperationException();

    }


    @Override
    public int delete(String id) {
        log.debug("Start method...");
        int affectedRows = 0;
        try {
            PreparedStatement prepared = DAOConnection.getInstance().prepareStatement(
                    " DELETE FROM container_status "
                    + " WHERE id=? ");

            prepared.setString(1, id);

            // execute query and get the affected rows number :
            affectedRows = prepared.executeUpdate();

        } catch (SQLException e) {
            log.error("Error deleting container status : " + e);
        }

        log.debug("End method.");

        return affectedRows;
    }


    private static ContainerStatusEntity map(ResultSet resultSet) throws SQLException {
        ContainerStatusEntity obj = new ContainerStatusEntity();

        obj.setId(resultSet.getString("id"));
        obj.setContainerId(resultSet.getString("container_id"));
        obj.setPressure(resultSet.getString("pressure"));
        obj.setHumidity(resultSet.getString("humidity"));
        obj.setTemperature(resultSet.getString("temperature"));
        obj.setJourneyId(resultSet.getString("journey_id"));
        return obj;
    }
}
