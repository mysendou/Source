package com.jeff.datastore;

public class DataStore {
    private static final Logger LOGGER = LoggerFactory.getLogger(DataStore.class);

    public final DataCache dataCache = new DataCache();

    private Connection connection;
}
