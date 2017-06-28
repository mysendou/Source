package com.jeff.datastore;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.jeff.cache.DataCache;

public class DataStore {
    private static final Logger LOGGER = Logger.getLogger(DataStore.class);

    public final DataCache dataCache = new DataCache();

    private Connection connection;

    public void close() throws Exception {
        dataCache.close();
        connection.close();
    }

    public void init() throws Exception {
        dataCache.setupCache();
        Class.forName("com.mysql.jdbc.Driver");
        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "root");
        Statement statement = connection.createStatement();
        try {
            statement.execute("CREATE TABLE IF NOT EXISTS PEEPS (" + "id bigint auto_increment primary key,"
                    + "PEEP_TEXT VARCHAR(142) NOT NULL" + ")");
            // connection.commit(); //have set auto commit
        } finally {
            statement.close();
        }
    }

    public synchronized void addPeep(String peepText) throws Exception {
        LOGGER.info("Adding peep into DB");
        PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO PEEPS (PEEP_TEXT) VALUES (?)");
        try {
            preparedStatement.setString(1, peepText);
            preparedStatement.execute();
            connection.commit();

            // For any add in database; clear the cache
            // LOGGER.info(" Added new peep in DB, clearing cache...");
            LOGGER.info("Clearing peeps cache");
            dataCache.clearCache();
        } finally {
            preparedStatement.close();
        }
    }

    public List<String> findAllPeeps() throws Exception {
        List<String> result = new ArrayList<String>();
        // find from cache 1st
        List<String> fromCache = dataCache.getFromCache();
        if (fromCache != null) {
            LOGGER.info("Getting peeps from cache");
            return fromCache;
        }

        LOGGER.info("Loading peeps from DB");
        Statement statement = connection.createStatement();
        try {
            ResultSet resultSet = statement.executeQuery("SELECT * FROM PEEPS");

            while (resultSet.next()) {
                String peepText = resultSet.getString("PEEP_TEXT");
                result.add(peepText);
            }
        } finally {
            statement.close();
        }

        LOGGER.info("Filling cache with peeps");
        dataCache.addToCache(result);
        return result;
    }
}
