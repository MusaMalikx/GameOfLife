package UI;

import BL.GameLogic.GUI_implementation;
import BL.GameLogic.Grid;

import java.util.Scanner;

public class Console {
    int [][]arr;
    int rows;
    int columns;
    boolean start,reset,next,stop;
    int counter,delay,sliderCount,speederCount;
    GUI_implementation implementation;

    public Console(GUI_implementation obj)
    {
        start=reset=next=stop=false;
        sliderCount = 0;
        speederCount = 0;
        counter = 0;
        delay = 0;
        for (int i = 0; i < 60; i++) {
            for (int j = 0; j < 80; j++) {

                arr[i][j] = 0;

            }
        }
        arr=new int[60][80];
        implementation= new GUI_implementation();
        implementation= obj;
        rows=20;
        columns=40;
    }
    public void selectCell()
    {

        Scanner sc= new Scanner(System.in); //System.in is a standard input stream.

        System.out.print("Enter index x : ");
        int x= sc.nextInt();
        if(x>= 60)
        {
            System.out.println("max row index is : 60");
            return;
        }
        System.out.print("Enter index y : ");
        int y= sc.nextInt();
        if(y>=80)
        {
            System.out.println("max col index is : 80" );
            return;
        }
       arr[x][y]=1;

    }
}
