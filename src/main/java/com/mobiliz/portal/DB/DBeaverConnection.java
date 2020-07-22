package com.mobiliz.portal.DB;

import java.util.logging.Logger;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class DBeaverConnection {


    private static final Logger LOGGER = Logger.getLogger(DBeaverConnection.class.getName());
    private String host = "192.168.4.122:1433";
    private String username = "webuser_integration";
    private String password = "webuser_integration";
    private String dbName = "eMOVE_TEST";
    protected Connection connection;

    public static void main(String[] args) {


    }

    public DBeaverConnection() {


    }


    public void closePrepStatement(PreparedStatement preparedStatement) {
        try {
            if (preparedStatement != null) {
                preparedStatement.close();
            }
        } catch (SQLException e) {
            System.out.println("CATCH IN closePrepStatement METHOD");
            LOGGER.severe(e.getMessage());
        }
    }


    public void closeResultSet(ResultSet resultSet) {
        try {
            if (resultSet != null) {
                resultSet.close();
            }
        } catch (SQLException e) {
            System.out.println("CATCH IN closeResultSet METHOD");

            LOGGER.severe(e.getMessage());
        }
    }


    public void close() {
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            System.out.println("catch for close() method");
            LOGGER.severe(e.getMessage());
        }
    }


    public Connection getConnection() throws ClassNotFoundException, SQLException {

        try {


            connection = null;

            String dbDriver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";

            Class.forName(dbDriver); //hata bu satırda

            //String dbConnectUrl = "jdbc:sqlserver://" + host + "/" + dbName + "?connectTimeout=5";

            String dbConnectUrl = "jdbc:sqlserver://192.168.4.122:1433;databaseName=eMOVE_TEST;charset=ISO-8859-9";

            connection = DriverManager.getConnection(dbConnectUrl, username, password);


        } catch (Exception ex) {

            System.out.println("CATCH MESSAGE FOR getConnection() : " + ex.getStackTrace());
            System.out.println();

        }


        return connection;
    }


    public String getUsername() {
        return username;
    }


    public String getPassword() {
        return password;
    }


    public String getDbName() {
        return dbName;
    }


    public String getHost() {
        return host;
    }

}
