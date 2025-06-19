package com.german.labo4.automovil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BDConnection {
    private static final String URL = "jdbc:sqlserver://localhost:1433;databaseName=Automovil;encrypt=true;trustServerCertificate=true";
    private static final String USER = "sa";
    private static final String PASSWORD = "12345";

    private BDConnection() {}

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

}
