
package com.project.dto.dao;

import com.project.dto.config.PROP;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DAOConnection
{
    final static Logger log = Logger.getLogger(DAOConnection.class);

    private static final String driver = PROP.getProperty("db.driver");

    private static final String url = PROP.getProperty("db.url");

    private static final String user = PROP.getProperty("db.user");

    private static final String password = PROP.getProperty("db.password");

    private static Connection connection;

    /**
     * Private constructor so this class cannot be instantiated only by it self.
     */
    private DAOConnection()
    {
    }

    /**
     * Create and return the Connection if not exist.
     *
     * @return The connection object
     */
    public static Connection getInstance()
    {
        if (connection == null)
        {
            try
            {
                Class.forName(driver);
            } catch (ClassNotFoundException e)
            {
                log.error("DB Driver error : " + e);
            }

            try
            {
                connection = DriverManager.getConnection(url, user, password);
            } catch (SQLException e)
            {
                log.error("DB Connection error : " + e);
            }
        }

        return connection;
    }
}
