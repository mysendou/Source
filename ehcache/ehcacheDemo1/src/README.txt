ON this project have the cache.


View the page 
1. On the PeeperServletContextListener have the contextInitialized method will execute the DATA_STORE.init method
2. On the Data_Store will set up the dataCache  and create the table PEEPS.
3. DataCache create cacheManager and cache
4. PeeperServlet doGet method invoke the DataStore findAllPeeps method first get the data from DB. if get the data will return if not
will get data from DB then add the data into cache.
5. On the add method will clear cache.