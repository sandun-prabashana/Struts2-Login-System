package com.epic.db;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;



public class DBConnection {

    public Connection connection;
    public DBConnection(){
    }

    public  Connection getConnection() throws ClassNotFoundException, SQLException {
        System.out.println("db1");
        Class.forName("com.mysql.cj.jdbc.Driver");
        System.out.println("db2");
        connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/struts2","root","mysql");
        System.out.println("db3");
        return connection;
    }

    public  void connnectionClose() throws SQLException {
        System.out.println("connection closed");
        connection.close();
    }

}
