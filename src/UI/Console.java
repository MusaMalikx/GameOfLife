package UI;

import java.awt.event.KeyEvent;
import BL.GameLogic.GUI_implementation;
import BL.GameLogic.Grid;
import BL.GameLogic.Grid_Controller;
import BL.GameLogic.Rules;

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
        arr=new int[60][80];
        for (int i = 0; i < 60; i++) {
            for (int j = 0; j < 80; j++) {

                arr[i][j] = 0;

            }
        }

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
    public void start()
    {
        if(start==true)
        {
            return;
        }
       Thread GameLoop=new Thread(new Runnable() {
           @Override
           public void run() {

               start=true;
               for (;; ) {
                if(stop==true)
                {
                    stop=false;
                    break;
                }

                   int arr2[][] = new int[60][80];
                   arr2 = implementation.next(arr);
                   for (int i = 0; i < 60; i++) {
                       for (int j = 0; j < 80; j++) {

                           arr[i][j] = arr2[i][j];

                       }

                   }
                   try {
                       Thread.sleep(speederCount*500);
                   }catch (Exception e) {

                       // catching the exception
                       System.out.println(e);
                   }
               counter++;
               }
           }
       });
start=false;
    }
    public void next()
    {
        if(next==true)
        {
            return;
        }


next=true;


                    int arr2[][] = new int[60][80];
                    arr2 = implementation.next(arr);
                    for (int i = 0; i < 60; i++) {
                        for (int j = 0; j < 80; j++) {

                            arr[i][j] = arr2[i][j];

                        }

                    }
                    try {
                        Thread.sleep(speederCount*500);
                    }catch (Exception e) {

                        // catching the exception
                        System.out.println(e);
                    }

                    counter++;
        next=false;
    }


    public void stop()
    {
        stop=true;
    }
    public void reset()
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
        rows=20;
        columns=40;
    }
    public void SpeedControl()
    {
        Scanner sc= new Scanner(System.in); //System.in is a standard input stream.

        System.out.print("Enter Delay (max 10) : ");

        int x= sc.nextInt();

        speederCount=x;
    }
    public void zoomControl()
    {
        Scanner sc= new Scanner(System.in); //System.in is a standard input stream.

        System.out.print("Enter no of rows to display (max 60) : ");
        int x= sc.nextInt();
        if(x>=60)
        {
            System.out.println("max row index is : 60");
            return;

        }
        rows=x;
        System.out.print("Enter no of Columns to display (max 80) : ");
        int y=sc.nextInt();
        if(y>=80)
        {
            System.out.println("max col index is : 80");
            return;

        }

        columns=y;
    }

    public void printGrid()
    {
        for(int i=0;i<rows;i++)
        {
            for (int j = 0; j < columns; j++) {
                if(arr[i][j]==0)
                {
                    System.out.print("* ");
                }
                else if(arr[i][j]==1)
                {
                    System.out.print("o ");
                }

            }
            System.out.print('\n');
        }
        System.out.print("0. Select Cell    1. Start    2. Stop      3.Next     4. Reset     5. Delay :"+ delay+ "    6. Zoom    7. Quit");
    }

    public void GO() {

        while(true)
        {
            printGrid();
            Scanner sc= new Scanner(System.in); //System.in is a standard input stream.

            System.out.print("\nChose : ");

            int x= sc.nextInt();
            if(x==0)
            {
                selectCell();
            }
            else if(x==1)
            {

                next();

            }
            else if(x==2)
            {
                start=false;
                stop();
            }
            else if(x==3)
            {
                next();
            }
            else if(x==4)
            {
               reset();
            }
            else if(x==5)
            {
                SpeedControl();
            }
            else if(x==6)
            {
                zoomControl();
            }
            else if(x==7)
            {
                break;
            }
        }
    }
}
