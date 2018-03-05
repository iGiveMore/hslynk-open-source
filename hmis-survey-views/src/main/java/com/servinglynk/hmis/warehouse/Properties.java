package com.servinglynk.hmis.warehouse;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.lang3.StringUtils;

public class Properties {

    public static String POSTGRESQL_DB_HOST;
    public static String POSTGRESQL_DB_PORT;
    public static String POSTGRESQL_DB_DATABASE;
    public static String POSTGRESQL_DB_USERNAME;
    public static String POSTGRESQL_DB_PASSWORD;
    public static String HBASE_MASTER;
    public static String HBASE_ZOOKEEPER_QUORUM;
    public static String HBASE_ZOOKEEPER_PROPERTY_CLIENT_PORT="2181";
    public static int SYNC_PERIOD;
    public static String SYNC_SCHEMAS;
    public static String HIVE_USERNAME;
    public static String HIVE_PASSWORD;
    public static String HIVE_DRIVER_URL;


    public void generatePropValues() throws Exception {

        InputStream in = null;
        try {
            java.util.Properties prop = new java.util.Properties();
            String propFileName = "application.conf";

            in = getClass().getClassLoader().getResourceAsStream(propFileName);

            if (in != null) {
                prop.load(in);
            } else {
                throw new FileNotFoundException("property file '" + propFileName + "' not found in the classpath");
            }
            POSTGRESQL_DB_HOST = prop.getProperty("posgresql.db.host");
            POSTGRESQL_DB_PORT = prop.getProperty("posgresql.db.port");
            POSTGRESQL_DB_DATABASE = prop.getProperty("posgresql.db.database");
            POSTGRESQL_DB_USERNAME = prop.getProperty("posgresql.db.username");
            POSTGRESQL_DB_PASSWORD = prop.getProperty("posgresql.db.password");
            HBASE_MASTER = prop.getProperty("hbase.master");
            HBASE_ZOOKEEPER_QUORUM = prop.getProperty("hbase.zookeeper.quorum");
            HBASE_ZOOKEEPER_PROPERTY_CLIENT_PORT = prop.getProperty("hbase.zookeeper.property.clientPort", "2181");
          //  SYNC_PERIOD = Integer.valueOf(prop.getProperty("sync.period"));
         //   SYNC_SCHEMAS = prop.getProperty("sync.schemas");
            HIVE_USERNAME = prop.getProperty("hive.username");
            HIVE_PASSWORD = prop.getProperty("hive.password");
            HIVE_DRIVER_URL= prop.getProperty("hive.driverUrl");

        } catch (Exception e) {
            System.out.println("Exception: " + e);
            throw e;
        } finally {
            if(in != null){
                in.close();
            }
        }

    }

    public void printProps() {
        System.out.println(POSTGRESQL_DB_HOST);
        System.out.println(POSTGRESQL_DB_PORT);
        System.out.println(POSTGRESQL_DB_DATABASE);
        System.out.println(POSTGRESQL_DB_USERNAME);
        System.out.println(POSTGRESQL_DB_PASSWORD);
        System.out.println(HBASE_MASTER);
        System.out.println(HBASE_ZOOKEEPER_QUORUM);
        System.out.println(HBASE_ZOOKEEPER_PROPERTY_CLIENT_PORT);
    }

}
