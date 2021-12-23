package File;
import BL.GameLogic.file;
import BL.GameLogic.Data;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.File;  // Import the File class
import java.io.IOException;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.*;
import java.util.*;
import  java.lang.String;

public class File_Handling implements file{

    public File_Handling() {

       }

    public static String fileToString(String filePath) throws Exception{
        String input = null;
        Scanner sc = new Scanner(new File(filePath));
        StringBuffer sb = new StringBuffer();
        while (sc.hasNextLine()) {
            input = sc.nextLine();
            sb.append(input);
        }
        return sb.toString();
    }

    public JSONObject viewState()throws Exception
    {
        String arr[]=new String[10];
        Scanner sc = null;

        try {

            File file = new File("Data.txt"); // java.io.File

            sc = new Scanner(file);     // java.util.Scanner
            String data;

            int i=0;
            while(sc.hasNextLine()) {

                    data =(sc.next());
                    arr[i]=data;
                    i++;

            }

        }

        catch(FileNotFoundException e)

        {

            e.printStackTrace();

        }

        finally {

            if (sc != null) sc.close();


        }
        return StrArrayToJSON(arr);

    }
    public void deleteState(JSONObject ob)throws Exception{
        try {

            //-------------------------------/
            String stateNum = JSONToString(ob);
            //------------------------------/

            File file = new File("Data.txt"); // java.io.File

            File file2 = new File(stateNum+".txt");

            file2.delete();

            String filePath = "Data.txt";
            String result = fileToString(filePath);

            //Replacing the word with desired one

            result = result.replaceAll("\\b"+" "+stateNum+"\\b", "");
            //Rewriting the contents of the file
            PrintWriter writer = new PrintWriter(new File(filePath));
            writer.append(result);
            writer.flush();

            writer.close();



        }



        catch(FileNotFoundException e)

        {

            e.printStackTrace();

        }

    }

    public JSONObject loadState(JSONObject o)throws Exception
    {

        String n = JSONToString(o);

        Data gridSize=new Data();
        int col=gridSize.getCol();
        int row=gridSize.getRow();

        int arr[][]=new int [row][col];


        Scanner sc = null;

        try {

            File file = new File(n+".txt"); // java.io.File

            sc = new Scanner(file);     // java.util.Scanner
            int data;


            for (int i = 0;i<row ; i++) {


                for (int j=0; j<col;j++) {

                    data = Integer.parseInt(sc.next());

                    arr[i][j]=data;
                }




            }

        }

        catch(FileNotFoundException e)

        {

            e.printStackTrace();

        }

        finally {

            if (sc != null) sc.close();

        }
        return ArrayToJSON(arr);
    }

    public void saveState (JSONObject ob)throws Exception {

        JSONObject o = (JSONObject) ob.get("Arr");
        int [][]arr = JSONTOArray(o);
        String name = (String)ob.get("Str");

        Data gridSize=new Data();
        int col=gridSize.getCol();
        int row=gridSize.getRow();


                    FileWriter myWriter = new FileWriter(name+".txt");

                    for (int i = 0; i < row; i++) {
                        for (int j = 0; j < col; j++) {
                            myWriter.write(String.valueOf(arr[i][j]));
                            myWriter.write(" ");
                        }
                        myWriter.write('\n');
                    }


                    //FileWriter myWriter3 = new FileWriter("Data.txt");
        String filePath = "Data.txt";
        String result = fileToString(filePath);
        result=result+" "+name;
        PrintWriter writer = new PrintWriter(new File(filePath));
        writer.append(result);
        writer.flush();

        writer.close();

                    myWriter.close();


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




