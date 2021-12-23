package Database;

import BL.GameLogic.Grid;
import BL.GameLogic.Data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.StringJoiner;
import javax.sql.StatementEvent;
import java.sql.*;
import java.sql.Types;
import BL.GameLogic.file;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class DatabaseHandler implements file {

    private String user = "root";
    private String password = "admin123";
    private Connection con = null;

    public DatabaseHandler()
    {
        try {

            String url = "jdbc:mysql://localhost:3306/GameOfLife"; 			// connection string, GameOfLife is the name of the database
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(url, user, password); // pass the connection string, username and password

            System.out.println(con);
            System.out.println("Database successfully Connected.");


            //con.close();    //Close the connection

        } catch (SQLException | ClassNotFoundException e) //exception handling
        {
            System.out.println(e);
        }
    }

    public JSONObject viewState() {

        ArrayList<String> StatesData = new ArrayList<String>();

        try {


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

        //----------------------------/
        return StrArrayToJSON(output);
        //return StringToJSON(output);
        //----------------------------/
    }

    public JSONObject loadState(JSONObject ob) {

        String GridName = JSONToString(ob);

        Data gridsize=new Data();
        int cells[][]=new int[gridsize.getRow()][gridsize.getCol()];
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

        //-------------------------------------/
        return ArrayToJSON(cells);
        //return cells;   //return 2d array
        //-------------------------------------/

    }

    public void saveState(JSONObject ob) {

        JSONObject o = (JSONObject) ob.get("Arr");
        int [][]arr = JSONTOArray(o);
        String GridName = (String)ob.get("Str");

        try {

            String url = "jdbc:mysql://localhost/GameOfLife";                   // connection string here; GameOfLife is the name of the database
            Connection con = DriverManager.getConnection(url, user, password); // pass the connection string,username and password

            System.out.println(con);
            System.out.println("Database is successfully connected");
            Statement one = con.createStatement();

            //Saving cell states one by one
            String strSaveState;
            int alive;
            Data gridSize=new Data();
            int col=gridSize.getCol();
            int row=gridSize.getRow();
            for (int X = 0; X < row; X++) {
                for (int Y = 0; Y < col; Y++) {
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

    public void deleteState(JSONObject ob) {

        //-------------------------------/
        String Gridname = JSONToString(ob);
        //------------------------------/

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

    public JSONObject StrArrayToJSON(String [] str){
        JSONObject ob = new JSONObject();

        for (int i = 0; i < str.length; i++) {
            ob.put(Integer.toString(i),str[i]);
        }

        return ob;
    }

    public String[] JSONToStrArray(JSONObject js){
        String []str = new String[js.size()];

        for (int i = 0; i < js.size(); i++) {
            str[i] = js.get(Integer.toString(i)).toString();
        }

        return str;
    }

    public JSONObject StringToJSON(String s){
        JSONObject ob = new JSONObject();
        ob.put("str",s);

        return ob;
    }

    public String JSONToString(JSONObject ob){
        String str = (String)ob.get("str");
        return str;
    }

    public JSONObject ArrayToJSON(int[][] arr){
        JSONObject o = new JSONObject();
        //ar.add(arr);
        //o.put("Array",ar);

        JSONArray jsonArray = new JSONArray();
        for (int[] ca : arr) {
            JSONArray arr1 = new JSONArray();
            for (int c : ca) {
                arr1.add(c); // or some other conversion
            }
            jsonArray.add(arr1);
        }

        o.put("Array",jsonArray);

        return o;

    }

    public int[][] JSONTOArray(JSONObject o){
        JSONArray aar = (JSONArray)o.get("Array");
        //System.out.println(aar.get(0));
        //System.out.println(aar.get(0).length);
        //System.out.println(aar.size());

        int arr2[][] = new int[aar.size()][];

        for (int i = 0; i < aar.size(); i++) {
            //System.out.println(aar.get(i));
            JSONArray a = (JSONArray)aar.get(i);
            //System.out.println(a.size());
            arr2[i] = new int[a.size()];
            for (int j = 0; j < a.size(); j++) {
                arr2[i][j] = (int)a.get(j);
            }
        }

        return arr2;
    }

    public JSONObject Str_ArrayToJSON(int [][]arr,String n){
        JSONObject o = new JSONObject();
        o.put("Arr",ArrayToJSON(arr));
        o.put("Str", n);

        return o;
    }

}
