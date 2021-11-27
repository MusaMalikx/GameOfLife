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
    public static void main(String[] args) throws Exception {
        int arr[] = new int[10];
        Scanner sc = null;

        try {

            File file = new File("Data.txt"); // java.io.File

            sc = new Scanner(file);     // java.util.Scanner
            int data;

            int i = 0;
            while (sc.hasNextLine()) {

                data = Integer.parseInt(sc.next());
                arr[i] = data;
                i++;

            }

        } catch (FileNotFoundException e) {

            e.printStackTrace();

        } finally {

            if (sc != null) sc.close();

        }

    }
}

