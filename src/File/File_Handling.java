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
    File_Handling() {


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

        fileNo = 0;
       }
    public void viewState()
    {

    }
    public void deleteState(int stateNum){}

    public int[][] loadState(int n)throws Exception
    {


        int arr[][]=new int [60][80];
        Integer l = n;

        String c = l.toString();

        Scanner sc = null;

        try {

            File file = new File(c+".txt"); // java.io.File

            sc = new Scanner(file);     // java.util.Scanner
            int data;


            for (int i = 0;i<60 ; i++) {


                for (int j=0; j<80;j++) {

                    data = Integer.parseInt(sc.next());
                    System.out.print(data +" ");
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

    public void saveState (int arr[][])throws Exception {

                Integer l = fileNo;
                String c = l.toString();



                    FileWriter myWriter = new FileWriter(c+".txt");

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
                    FileWriter myWriter3 = new FileWriter("main.txt");
                    myWriter3.append(c+".txt\n");
                    myWriter.close();
                    myWriter2.close();
                    myWriter3.close();
                }
            }




