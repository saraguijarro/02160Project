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
 * The ContainerEntity repository implementation.
 */
public class ContainerRepository implements Repository<Container> {
    final static Logger log = Logger.getLogger(Container.class);

//    @Override
//    public Container find(String id) {
//        log.debug("Start method...");
//
//        Container obj = null;
//
//        try {
//            PreparedStatement prepared = DAOConnection.getInstance().prepareStatement(
//                    "SELECT * FROM containers WHERE id=?");
//            prepared.setString(1, id);
//            ResultSet result = prepared.executeQuery();
//
//            if (result.first()) {
//                obj = map(result);
//            }
//        } catch (SQLException e) {
//            log.error("Error finding container : " + e);
//        }
//
//        log.debug("End method.");
//        return obj;
//    }

    @Override
    public ArrayList<Container> findAll() {
        log.debug("Start method...");
        ArrayList<Container> users = new ArrayList<>();

        try {
            PreparedStatement prepared = DAOConnection.getInstance().prepareStatement(
                    "SELECT * FROM containers");

            ResultSet result = prepared.executeQuery();
            while (result.next()) {
                users.add(map(result));
            }
        } catch (SQLException e) {
            log.error("Error finding containers : " + e);
        }

        log.debug("End method.");
        return users;
    }

    @Override
    public Container create(Container obj) {
        log.debug("Start method...");

        try {
            PreparedStatement prepared = DAOConnection.getInstance().prepareStatement(
                    " INSERT INTO containers (id, position, journey_id, in_journey) "
                            + " VALUES(?, ?, ?, ?) ", Statement.RETURN_GENERATED_KEYS);

            prepared.setString(1, obj.getContainerID());
            prepared.setString(2, obj.getCurrentPosition());
//            prepared.setString(3, obj.get);
//            prepared.setString(2, obj.getCurrentPosition());
//            prepared.setString(2, obj.getCurrentPosition());
//            prepared.setString(2, obj.getCurrentPosition());
            prepared.setBoolean(4, obj.getInJourney());

        } catch (SQLException e) {
            log.error("Error creating new container : " + e);
        }

        log.debug("End method.");
        return obj;
    }

    @Override
    public void putAllInDatabase(ArrayList<Container> entitiesList) {
        log.debug("Start method...");

        try
        {
            PreparedStatement prepared = DAOConnection.getInstance().prepareStatement(
                    " TRUNCATE TABLE containers");
            prepared.executeUpdate();
        } catch (SQLException e)
        {
            log.error("Error truncating the table: " + e);
        }

        entitiesList.forEach(this::create);

        log.debug("End method.");

    }

    private static Container map(ResultSet resultSet) throws SQLException {
        Container obj = new Container();

        obj.setContainerID(resultSet.getString("id"));
        obj.setCurrentPosition(resultSet.getString("Position"));
        obj.setInJourney(resultSet.getBoolean("In Journey"));
        return obj;
    }
}