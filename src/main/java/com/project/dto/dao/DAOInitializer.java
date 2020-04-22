
package dao;

import config.PROP;
import org.apache.log4j.Logger;

import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Class for database initialization.
 */
public class DAOInitializer
{

    final static Logger log = Logger.getLogger(DAOInitializer.class);

    /**
     * Empty private constructor.
     */
    private DAOInitializer()
    {
    }

    /**
     * Initialize the database.
     */
    public static void init()
    {
        if ("true".equalsIgnoreCase(PROP.getProperty("db.createTables")))
        {
            DAOInitializer.createTables();
        }

    }

    /**
     * Create tables in the database.
     */
    private static void createTables()
    {
        // products table :
        String createQuery = "CREATE TABLE IF NOT EXISTS client("
                + "ID INT PRIMARY KEY AUTO_INCREMENT,"
                + "Name VARCHAR(255),"
                + "Address VARCHAR(255),"
                + "Person VARCHAR(255),"
                + "Email VARCHAR(255)"
                + ")";

        log.info("Creating table client...");

        try
        {
            PreparedStatement ps = DAOConnection.getInstance().prepareStatement(createQuery);
            ps.executeUpdate();

            log.info("Table clients created.");

        } catch (SQLException e)
        {
            log.error("Error creating table clients : " + e);
        }
    }

}
