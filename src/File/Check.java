package File;

import BL.GameLogic.file;
import java.io.File;  // Import the File class
import java.io.IOException;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.*;
import java.util.*;
import  java.lang.String;

public class Check {
    public static void main(String[] args) throws Exception {
        int arr[][] = new int[3][3];
        Integer l = 5;
        String c = l.toString();

        Scanner sc = null;

        try {

            File file = new File(c+".txt"); // java.io.File


            sc = new Scanner(file);     // java.util.Scanner
            int data;


            for (int i = 0;i<3 ; i++) {


                for (int j=0; j<3;j++) {

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
        System.out.print('\n');
        for (int i = 0; i <3 ; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(arr[i][j]+" ");
            }
            System.out.print('\n');
        }
    }
}

