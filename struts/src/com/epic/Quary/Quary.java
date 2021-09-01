package com.epic.Quary;

public class Quary {

    public static String registerUser = "INSERT INTO user" +
            "  ( user_name , email_address , password) VALUES " +
            " ( ?, ?, ?);";

    public static String signin = "select * from user where user_name = ? and password = ? ";

    public static String userValidateByName = "select * from user where user_name = ? ";

    public static String userValidateByEmail = "select * from user where email_address = ? ";

    public static String allData = "select id,user_name,email_address,password from user";

    public static String delete = "DELETE FROM user WHERE id=?";

    public static String updateById = "UPDATE user SET user_name=?,email_address=?,password=?  WHERE id=?";

}
