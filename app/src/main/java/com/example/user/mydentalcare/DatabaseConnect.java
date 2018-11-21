package com.example.user.mydentalcare;

import android.os.AsyncTask;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DatabaseConnect{
    public Connection ConnectDatabase() throws SQLException {
        /*Declare and initialize a swl Connection variable*/
        Connection conn = null;

        try {
            /* Register for jdbc driver class. */
            Class.forName("com.mysql.cj.jdbc.Driver");

            /* Create connection url. */
            String mysqlConnUrl = "jdbc:mysql://localhost/MyDentalCare";

            /* db user name. */
            String mysqlUserName = "root";

            /* db password. */
            String mysqlPassword = "";

            /* Get the Connection object. */
             conn = DriverManager.getConnection(mysqlConnUrl, mysqlUserName , mysqlPassword);


        }
        catch (Exception ex){
            ex.printStackTrace();
        }
        finally {
            System.out.println("Connected");
            return conn;
        }
    }

}
