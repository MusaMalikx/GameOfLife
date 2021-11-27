package bin.Storage.DatabaseHandler;

import bin.BL.Grid.*;
import bin.Interfaces.StorageInterface.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.StringJoiner;
import javax.sql.StatementEvent;
import java.sql.*;
import java.sql.Types;

public class DatabaseHandler implements StorageInterface {

    private String user = "admin";
    private String password = "admin123";

    public ArrayList<String> View_States() {

        ArrayList<String> StatesData = new ArrayList<String>();

        try {

            String url = "jdbc:mysql://localhost/GameOfLife"; 			// connection string, GameOfLife is the name of the database
            Connection con = DriverManager.getConnection(url, user, password); // pass the connection string, username and password
                                                                             
            System.out.println(con);
            System.out.println("Database successfully Connected.");
            Statement one = con.createStatement();
            String strViewStates = "call View_state;";
            ResultSet result = one.executeQuery(strViewStates);

            // store all statenames inside a ArrayList
            while (result.next()) 
		    {
                output.add(result.getString(1));
            }

            con.close();    //Close the connection

        } catch (SQLException e) //exception handling
        {
            System.out.println(e);
        }

        return output;
    }

    public Grid Load_States(String GridName) {

        try {

            String url = "jdbc:mysql://localhost/GameOfLife";                   // connection string, GameOfLife is the name of the database
            Connection con = DriverManager.getConnection(url, user, password); // pass the connection string,username and password

            System.out.println(con);
            System.out.println("Database is successfully connected");
            Statement one = con.createStatement();
            String strloadState = "call Load_state " + "('" + GridName + "');";
            ResultSet getGridDimension = one.executeQuery(strloadState);

            int X = 0, Y = 0;

            getGridDimension.next();

            X = getGridDimension.getInt(4);     //get Total_Xcoord from db
            Y = getGridDimension.getInt(5);     //get Total_Ycoord from db


            Grid grid = new Grid(X, Y);          //make new Grid with data

            ResultSet getGridStates = one.executeQuery(query);

            //Get states of available cells stored in db
            while (getGridStates.next())
            {
                grid.setCellStatus(getGridStates.getInt(1), getGridStates.getInt(2), getGridStates.getBoolean(3));
            }

            con.close();        //close the connection

        } catch (SQLException e)    //exception handling
        {
            System.out.println(e);
        }

        return grid;

    }

    public void Save_States(Grid grid, String GridName) {

        try {

            String url = "jdbc:mysql://localhost/GameOfLife";                   // connection string here; GameOfLife is the name of the database
            Connection con = DriverManager.getConnection(url, user, password); // pass the connection string,username and password

            System.out.println(con);
            System.out.println("Database is successfully connected");
            Statement one = con.createStatement();

            //Saving cell states one by one
            String strSaveState;
            int alive;

            for (int X = 0; X < grid.getRows(); X++) {
                for (int Y = 0; Y < grid.getColumns(); Y++) {
                    if (grid.getCellState(X, Y)) {
                        alive = 1;
                        strSaveState = "call Save_state " + "('" + GridName + "'," + X + "," + Y + "," + alive + "," + grid.getRow() + "," + grid.getCol() + ");";
                        one.executeQuery(strSaveState);
                    }
                }
            }

            con.close();    //close the connection

        } catch (SQLException e)        //exception handling
        {
            System.out.println(e);
        }
    }

    public void Delete_States(String Gridname) {
        try {

            String url = "jdbc:mysql://localhost/GameOfLife"; // connection string here; GameOfLife is the name of the database
            Connection con = DriverManager.getConnection(url, user, password); // pass the connection string, username and password

            System.out.println(con);
            System.out.println("Database is successfully connected");
            Statement one = con.createStatement();
            String strDeleteState = "call Delete_state " + "('" + Gridname + "');";
            one.executeQuery(strDeleteState);
            con.close();

        } catch (SQLException e)    //exception handling
        {
            System.out.println(e);
        }

    }

}
