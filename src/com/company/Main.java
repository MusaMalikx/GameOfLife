package com.company;
import Database.Database;
import swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {

    public static void main(String[] args) throws SQLException {
	// write your code here
//        String url = "jdbc:mysql://localhost/test";
//        Connection con = DriverManager.getConnection(url,"root","Haris@123\"?\"");
        Database db = new Database();
        db.connect();
        swing swing = new swing();
        swing.Example();
//        System.out.println(con);
    }
}
