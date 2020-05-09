package com.project.repository;

import com.project.dto.Container;
import com.project.dto.dao.DAOConnection;
import com.project.dto.dao.Repository;
import org.apache.log4j.Logger;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * The ContainerStatusEntity repository implementation.
 */
public class ContainerStatusRepository implements Repository<Container> {
    final static Logger log = Logger.getLogger(Container.class);


    @Override
    public ArrayList<Container> findAll() {
        log.debug("Start method...");
        ArrayList<Container> users = new ArrayList<>();

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
    public Container create(Container obj) {
        log.debug("Start method...");

        try {
            PreparedStatement prepared = DAOConnection.getInstance().prepareStatement(
                    " INSERT INTO container_status (temperature, humidity, pressure, container_id) "
                    + " VALUES(?, ?, ?, ?, ?) ", Statement.RETURN_GENERATED_KEYS);
            prepared.setString(1, String.valueOf(obj.getTemperature()));
            prepared.setString(2, String.valueOf(obj.getHumidity()));
            prepared.setString(3, String.valueOf(obj.getPressure()));
            prepared.setString(4, obj.getContainerID());

        } catch (SQLException e) {
            log.error("Error creating new container status : " + e);
        }

        log.debug("End method.");
        return obj;
    }


    private static Container map(ResultSet resultSet) throws SQLException {
        Container obj = new Container();

        obj.setContainerID(resultSet.getString("container_id"));
//        obj.setPressure(String.valueOf(resultSet.getString("pressure")));
//        obj.setHumidity(resultSet.getString("humidity"));
//        obj.setTemperature(resultSet.getString("temperature"));
        return obj;
    }
}
