package com.epic.service;

import com.epic.Quary.Quary;
import com.epic.db.DBConnection;
import com.epic.model.User;
import com.epic.security.PasswordConveter;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Service extends Quary {

    Quary quary = new Quary();
    private PasswordConveter conveter = new PasswordConveter();

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

    public ArrayList<User> getData() {
        System.out.println("reg bd");
        try {
            System.out.println("reg bd");


            User u = new User();

            DBConnection dbConnection = null;

            ResultSet rst = null;

            dbConnection = new DBConnection();
            PreparedStatement pstm = dbConnection.getConnection().prepareStatement(quary.allData);
            rst = pstm.executeQuery();

            ArrayList<User> load = new ArrayList<>();
            while (rst.next()) {

                String decrypt=conveter.decryptPassword(rst.getString(4));
                load.add(new User(rst.getInt(1), rst.getString(2), rst.getString(3),decrypt ));

                System.out.println("hari");
            }
            System.out.println("noo");
            dbConnection.connection.close();
            return load;
        } catch (SQLException ex) {
            Logger.getLogger(Service.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Service.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(Service.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public String deleteUser(int id) throws SQLException, Exception {
        DBConnection dbConnection = null;
        try {
            dbConnection = new DBConnection();
            PreparedStatement ps = dbConnection.getConnection().prepareStatement(quary.delete);
            ps.setInt(1, id);
            ps.executeUpdate();
            return "Delete Successful";
        } catch (Exception e) {
            e.printStackTrace();
            return e.getMessage();
        } finally {
            dbConnection.connection.close();
        }
    }


    public String updateUser(User user) throws SQLException, Exception {
        DBConnection dbConnection = null;
        try {
            dbConnection = new DBConnection();
            PreparedStatement ps = dbConnection.getConnection().prepareStatement(quary.updateById);
            ps.setString(1, user.getUser_name());
            ps.setString(2, user.getEmail_address());
            ps.setString(3, user.getPassword());
            ps.setInt(4, user.getId());
            ps.executeUpdate();
            return "Update Successful";
        } catch (Exception e) {
            e.printStackTrace();
            return e.getMessage();
        } finally {
            dbConnection.connection.close();
        }
    }

}
