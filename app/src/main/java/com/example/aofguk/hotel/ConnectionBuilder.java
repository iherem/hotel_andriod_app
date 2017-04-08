package com.example.aofguk.hotel;

/**
 * Created by AOfGUK on 8/4/2560.
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectionBuilder {

    public static Connection getConntection(){
        Connection con = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://kumnet.me:3306/hotel?zeroDateTimeBehavior=convertToNull", "aof", "123456789");
        }catch(ClassNotFoundException e){
            System.out.println(e);
        }catch(SQLException e){
            System.out.println(e);
        }
        return con;
    }

}
