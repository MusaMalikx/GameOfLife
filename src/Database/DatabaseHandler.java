package Database;

import BL.GameLogic.Grid;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.StringJoiner;
import javax.sql.StatementEvent;
import java.sql.*;
import java.sql.Types;
import BL.GameLogic.file;

public class DatabaseHandler implements file {

    private String user = "admin";
    private String password = "admin123";

    public String[] viewState() {

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
                StatesData.add(result.getString(1));
            }

            con.close();    //Close the connection

        } catch (SQLException e) //exception handling
        {
            System.out.println(e);
        }

        //Return String Array
        int n = StatesData.size();
        String[] output = new String[n];

        for(int i=0; i<n; i++)
        {
            output[i] = StatesData.get(i);
        }

        return output;
    }

    public int[][] loadState(String GridName) {

        int cells[][]=new int[60][80];
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

            ResultSet getGridStates = one.executeQuery(strloadState);

            //Get states of available cells stored in db
            while (getGridStates.next())
            {
                grid.setCellStatus(getGridStates.getInt(1), getGridStates.getInt(2), getGridStates.getBoolean(3));
               int value;
                if(getGridStates.getBoolean(3)==true)
                {
                value=1;
                }
                else
                {
                    value=0;
                }
                cells[getGridStates.getInt(1)][getGridStates.getInt(2)] = value;
            }

            con.close();        //close the connection

        } catch (SQLException e)    //exception handling
        {
            System.out.println(e);
        }


        return cells;   //return 2d array

    }

    public void saveState(int arr[][], String GridName) {

        try {

            String url = "jdbc:mysql://localhost/GameOfLife";                   // connection string here; GameOfLife is the name of the database
            Connection con = DriverManager.getConnection(url, user, password); // pass the connection string,username and password

            System.out.println(con);
            System.out.println("Database is successfully connected");
            Statement one = con.createStatement();

            //Saving cell states one by one
            String strSaveState;
            int alive;

            for (int X = 0; X < 60; X++) {
                for (int Y = 0; Y < 80; Y++) {
                    if (arr[X][Y] == 1) {
                        alive = 1;
                        strSaveState = "call Save_state " + "('" + GridName + "'," + X + "," + Y + "," + alive + "," + 60 + "," + 80 + ");";
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

    public void deleteState(String Gridname) {
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
