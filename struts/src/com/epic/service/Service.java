package com.epic.service;

import com.epic.Quary.Quary;
import com.epic.db.DBConnection;
import com.epic.model.User;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Service extends Quary {

    Quary quary = new Quary();

    public boolean registerUser(User user) throws ClassNotFoundException {


        DBConnection connection = null;
        try {
            connection = new DBConnection();


            PreparedStatement preparedStatement = connection.getConnection().prepareStatement(quary.registerUser);
            preparedStatement.setString(1, user.getUser_name());
            preparedStatement.setString(2, user.getEmail_address());
            preparedStatement.setString(3, user.getPassword());
            System.out.println(preparedStatement);

            int i = preparedStatement.executeUpdate();
            if (i >= 0) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            try {
                connection.connection.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return false;
    }

    public boolean SignIn(User user) throws ClassNotFoundException {

        boolean status = false;
        DBConnection connection = null;

        try {
            connection = new DBConnection();


            PreparedStatement preparedStatement = connection.getConnection().prepareStatement(quary.signin) ;
            preparedStatement.setString(1, user.getUser_name());
            preparedStatement.setString(2, user.getPassword());

            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            status = rs.next();
        } catch (SQLException e) {
            try {
                connection.connection.close();
            } catch (SQLException ex) {
                Logger.getLogger(Service.class.getName()).log(Level.SEVERE, null, ex);
            }
        }


        return status;
    }

    public boolean userValidateByName(User user) throws ClassNotFoundException {

        boolean status = false;
        DBConnection connection = null;

        try {
            connection = new DBConnection();


            PreparedStatement preparedStatement = connection.getConnection().prepareStatement(quary.userValidateByName) ;
            preparedStatement.setString(1, user.getUser_name());

            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            status = rs.next();
        } catch (SQLException e) {
            try {
                connection.connection.close();
            } catch (SQLException ex) {
                Logger.getLogger(Service.class.getName()).log(Level.SEVERE, null, ex);
            }
        }


        return status;
    }

    public boolean userValidateByEmail(User user) throws ClassNotFoundException {

        boolean status = false;
        DBConnection connection = null;

        try {
            connection = new DBConnection();


            PreparedStatement preparedStatement = connection.getConnection().prepareStatement(quary.userValidateByEmail) ;
            preparedStatement.setString(1, user.getEmail_address());

            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            status = rs.next();
        } catch (SQLException e) {
            try {
                connection.connection.close();
            } catch (SQLException ex) {
                Logger.getLogger(Service.class.getName()).log(Level.SEVERE, null, ex);
            }
        }


        return status;
    }

}
