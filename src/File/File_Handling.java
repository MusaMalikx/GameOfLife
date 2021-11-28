package File;
import BL.GameLogic.file;
import java.io.File;  // Import the File class
import java.io.IOException;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.*;
import java.util.*;
import  java.lang.String;

public class File_Handling implements file{
    int fileNo;
    public File_Handling() {


        Scanner sc = null;

        try {

            File file = new File("main.txt"); // java.io.File

            sc = new Scanner(file);     // java.util.Scanner
            int data;
            data = Integer.parseInt(sc.next());
            fileNo=data;
        }
        catch(FileNotFoundException e)

        {

            e.printStackTrace();

        }

        finally {

            if (sc != null) sc.close();

        }


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

    public String[] viewState()throws Exception
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
        return arr;

    }
    public void deleteState(String stateNum)throws Exception{
        try {

            File file = new File("Data.txt"); // java.io.File
            File file2 = new File(stateNum+".txt");

            file2.delete();

            String filePath = "Data.txt";
            String result = fileToString(filePath);

            //Replacing the word with desired one

            result = result.replaceAll("\\b"+stateNum+"\\b", "");
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

    public int[][] loadState(String n)throws Exception
    {


        int arr[][]=new int [60][80];


        Scanner sc = null;

        try {

            File file = new File(n+".txt"); // java.io.File

            sc = new Scanner(file);     // java.util.Scanner
            int data;


            for (int i = 0;i<60 ; i++) {


                for (int j=0; j<80;j++) {

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
        return arr;
    }

    public void saveState (int arr[][],String name)throws Exception {

                Integer l = fileNo;
                String c = l.toString();



                    FileWriter myWriter = new FileWriter(name+".txt");

                    for (int i = 0; i < 60; i++) {
                        for (int j = 0; j < 80; j++) {
                            myWriter.write(String.valueOf(arr[i][j]));
                            myWriter.write(" ");
                        }
                        myWriter.write('\n');
                    }
                    fileNo++;
                    FileWriter myWriter2 = new FileWriter("main.txt");
                    myWriter2.write(String.valueOf(fileNo));
                    //FileWriter myWriter3 = new FileWriter("Data.txt");
        String filePath = "Data.txt";
        String result = fileToString(filePath);
        result=result+" "+name;
        PrintWriter writer = new PrintWriter(new File(filePath));
        writer.append(result);
        writer.flush();

        writer.close();

                    myWriter.close();
                    myWriter2.close();

                }
            }




