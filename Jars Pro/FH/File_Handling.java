import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;

public class File_Handling implements file {

    public File_Handling() {

    }

    public static String fileToString(String filePath) {
        String input = null;
        StringBuffer sb = new StringBuffer();
        try {
            Scanner sc = new Scanner(new File(filePath));

            while (sc.hasNextLine()) {
                input = sc.nextLine();
                sb.append(input);
            }

        } catch (Exception ex) {
            System.out.println(ex);
        }
        return sb.toString();
    }

    public String[] viewState() {
        String arr[] = new String[10];
        Scanner sc = null;

        try {

            File file = new File("Data.txt"); // java.io.File

            sc = new Scanner(file);     // java.util.Scanner
            String data;

            int i = 0;
            while (sc.hasNextLine()) {

                data = (sc.next());
                arr[i] = data;
                i++;

            }

        } catch (FileNotFoundException e) {

            e.printStackTrace();

        } finally {

            if (sc != null) sc.close();


        }
        return arr;

    }

    public void deleteState(String stateNum) {
        try {

            File file = new File("Data.txt"); // java.io.File

            File file2 = new File(stateNum + ".txt");

            file2.delete();

            String filePath = "Data.txt";
            String result = fileToString(filePath);

            //Replacing the word with desired one

            result = result.replaceAll("\\b" + " " + stateNum + "\\b", "");
            //Rewriting the contents of the file
            PrintWriter writer = new PrintWriter(new File(filePath));
            writer.append(result);
            writer.flush();

            writer.close();


        } catch (FileNotFoundException e) {

            e.printStackTrace();

        }

    }

    public int[][] loadState(String n) {

        Data gridSize = new Data();
        int col = gridSize.getCol();
        int row = gridSize.getRow();

        int arr[][] = new int[row][col];


        Scanner sc = null;

        try {

            File file = new File(n + ".txt"); // java.io.File

            sc = new Scanner(file);     // java.util.Scanner
            int data;


            for (int i = 0; i < row; i++) {


                for (int j = 0; j < col; j++) {

                    data = Integer.parseInt(sc.next());

                    arr[i][j] = data;
                }


            }

        } catch (FileNotFoundException e) {

            e.printStackTrace();

        } finally {

            if (sc != null) sc.close();

        }
        return arr;
    }

    public void saveState(int arr[][], String name) {


        Data gridSize = new Data();
        int col = gridSize.getCol();
        int row = gridSize.getRow();

        try {
            FileWriter myWriter = new FileWriter(name + ".txt");

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
            result = result + " " + name;
            PrintWriter writer = new PrintWriter(new File(filePath));
            writer.append(result);
            writer.flush();

            writer.close();

            myWriter.close();


        }
        catch(Exception ex)
        {
            System.out.println(ex);
        }
    }

    public static void main(String []args){

    }

}




