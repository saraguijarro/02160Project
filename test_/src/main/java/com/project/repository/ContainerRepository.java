package com.project.repository;

import com.project.dto.ContainerEntity;
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
 * The ContainerEntity repository implementation.
 */
public class ContainerRepository implements Repository<ContainerEntity> {
    final static Logger log = Logger.getLogger(ContainerEntity.class);

    @Override
    public ContainerEntity find(String id) {
        log.debug("Start method...");

        ContainerEntity obj = null;

        try {
            PreparedStatement prepared = DAOConnection.getInstance().prepareStatement(
                    "SELECT * FROM containers WHERE id=?");
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
    public ArrayList<ContainerEntity> findAll() {
        log.debug("Start method...");
        ArrayList<ContainerEntity> users = new ArrayList<>();

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
    public ContainerEntity create(ContainerEntity obj) {
        log.debug("Start method...");

        try {
            PreparedStatement prepared = DAOConnection.getInstance().prepareStatement(
                    " INSERT INTO containers (id, name, description) "
                    + " VALUES(?, ?, ?) ", Statement.RETURN_GENERATED_KEYS);

            prepared.setString(1, UUID.randomUUID().toString());
            prepared.setString(2, obj.getName());
            prepared.setString(3, obj.getDescription());

        } catch (SQLException e) {
            log.error("Error creating new container : " + e);
        }

        log.debug("End method.");
        return obj;
    }

    @Override
    public ContainerEntity update(ContainerEntity obj) {
        throw new UnsupportedOperationException();
    }


    @Override
    public int delete(String id) {
        log.debug("Start method...");
        int affectedRows = 0;
        try {
            PreparedStatement prepared = DAOConnection.getInstance().prepareStatement(
                    " DELETE FROM containers "
                    + " WHERE id=? ");

            prepared.setString(1, id);

            // execute query and get the affected rows number :
            affectedRows = prepared.executeUpdate();

        } catch (SQLException e) {
            log.error("Error deleting container : " + e);
        }

        log.debug("End method.");

        return affectedRows;
    }


    private static ContainerEntity map(ResultSet resultSet) throws SQLException {
        ContainerEntity obj = new ContainerEntity();

        obj.setId(resultSet.getString("id"));
        obj.setDescription(resultSet.getString("description"));
        obj.setName(resultSet.getString("name"));
        return obj;
    }
}
