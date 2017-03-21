package com.jeff.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.jeff.dataStore.DataStore;

public class PeeperServletContextListener implements ServletContextListener{
    public static final DataStore DATA_STORE = new DataStore();

    @Override
    public void contextDestroyed(ServletContextEvent arg0) {
        try {
            DATA_STORE.close();
        } catch (Exception e) {
            throw new RuntimeException("Cannot close datastore", e);
        }
    }

    @Override
    public void contextInitialized(ServletContextEvent arg0) {
        try {
            DATA_STORE.init();
        } catch (Exception e) {
            throw new RuntimeException("Cannot initialize datastore", e);
        }
    }
}
