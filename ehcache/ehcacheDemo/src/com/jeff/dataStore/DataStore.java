package com.jeff.dataStore;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

public class DataStore {
    private static final Logger LOGGER = Logger.getLogger(DataStore.class);
    private Connection connection;

    public void init() throws Exception {
        Class.forName("com.mysql.jdbc.Driver");
        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "root");
        Statement statement = connection.createStatement();
        try {
            statement.execute("CREATE TABLE IF NOT EXISTS PEEPS (" + "id bigint auto_increment primary key,"
                    + "PEEP_TEXT VARCHAR(142) NOT NULL" + ")");
//            connection.commit(); //have set auto commit
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
//            connection.commit();// have set auto commit
        } finally {
            preparedStatement.close();
        }
    }

    public synchronized List<String> findAllPeeps() throws Exception {
        LOGGER.info("Loading peeps from DB");
        List<String> result = new ArrayList<String>();

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
        return result;
      }

    public void close() throws Exception {
        connection.close();
    }
}
