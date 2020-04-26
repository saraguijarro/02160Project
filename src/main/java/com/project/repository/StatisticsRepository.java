package com.project.repository;

import com.project.dto.StatisticsEntity;
import com.project.dto.dao.DAOConnection;
import com.project.dto.dao.Repository;
import org.apache.log4j.Logger;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class StatisticsRepository implements Repository<StatisticsEntity> {
    /**
     * The StatisticsEntity repository implementation.
     */

        final static Logger log = Logger.getLogger(StatisticsEntity.class);

        @Override
        public StatisticsEntity find(String id) {
            log.debug("Start method...");

            StatisticsEntity obj = null;

            try {
                PreparedStatement prepared = DAOConnection.getInstance().prepareStatement(
                        "SELECT * FROM user_actions WHERE id=?");
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
        public ArrayList<StatisticsEntity> findAll() {
            log.debug("Start method...");
            ArrayList<StatisticsEntity> users = new ArrayList<>();

            try {
                PreparedStatement prepared = DAOConnection.getInstance().prepareStatement(
                        "SELECT * FROM user_actions");

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
        public StatisticsEntity create(StatisticsEntity obj) {
            log.debug("Start method...");

            try {
                PreparedStatement prepared = DAOConnection.getInstance().prepareStatement(
                        " INSERT INTO user_actions (user_id, action) "
                                + " VALUES(?, ?) ", Statement.RETURN_GENERATED_KEYS);

                prepared.setInt(1, obj.getUser_id());
                prepared.setString(2, obj.getAction());

            } catch (SQLException e) {
                log.error("Error creating new container : " + e);
            }

            log.debug("End method.");
            return obj;
        }

        @Override
        public StatisticsEntity update(StatisticsEntity obj) {
            throw new UnsupportedOperationException();
        }


        @Override
        public int delete(String id) {
            log.debug("Start method...");
            int affectedRows = 0;
            try {
                PreparedStatement prepared = DAOConnection.getInstance().prepareStatement(
                        " DELETE FROM user_actions "
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


        private static StatisticsEntity map(ResultSet resultSet) throws SQLException {
            StatisticsEntity obj = new StatisticsEntity();

            obj.setId(resultSet.getInt("id"));
            obj.setUser_id(resultSet.getInt("user_id"));
            obj.setAction(resultSet.getString("Action performed"));
            return obj;
        }
}

