package UI;

import java.awt.event.KeyEvent;
import BL.GameLogic.GUI_implementation;
import BL.GameLogic.file;
import BL.GameLogic.Data;
import BL.GameLogic.Grid;
import BL.GameLogic.Grid_Controller;
import BL.GameLogic.Rules;
import File.File_Handling;

import java.util.Scanner;

public class Console {
    int [][]arr;
    int rows;
    int columns;
    boolean start,reset,next,stop;
    int counter,delay,sliderCount,speederCount;
    GUI_implementation implementation;
    file file_controller;

    public Console(GUI_implementation obj,file obj2)
    {
        start=reset=next=stop=false;
        sliderCount = 0;
        speederCount = 0;
        counter = 0;
        delay = 0;
        implementation= new GUI_implementation();
        implementation= obj;

        int col=implementation.getCol();
        int row=implementation.getRow();
        arr=new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {

                arr[i][j] = 0;

            }
        }


        file_controller=new File_Handling();
        rows=20;
        columns=40;
    }
    public void selectCell()
    {

        Scanner sc= new Scanner(System.in); //System.in is a standard input stream.

        System.out.print("Enter index x : ");
        int x= sc.nextInt();
        if(x>= implementation.getRow())
        {
            System.out.println("max row index is : 60");
            return;
        }
        System.out.print("Enter index y : ");
        int y= sc.nextInt();
        if(y>=implementation.getCol())
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
                   int col=implementation.getCol();
                   int row=implementation.getRow();
                   int arr2[][] = new int[row][col];

                   arr2 = implementation.next(arr);
                   for (int i = 0; i < row; i++) {
                       for (int j = 0; j < col; j++) {

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

        int col=implementation.getCol();
        int row=implementation.getRow();

                    int arr2[][] = new int[row][col];
                    arr2 = implementation.next(arr);
                    for (int i = 0; i < row; i++) {
                        for (int j = 0; j < col; j++) {

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

        int col=implementation.getCol();
        int row=implementation.getRow();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {

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
        if(x>= implementation.getRow())
        {
            System.out.println("max row index is : 60");
            return;

        }
        rows=x;
        System.out.print("Enter no of Columns to display (max 80) : ");
        int y=sc.nextInt();
        if(y>= implementation.getCol())
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
        System.out.print("0. Select Cell    1. Start    2. Stop      3.Next     4. Reset     5. Delay :"+ delay+ "    6. Zoom    7. Quit\n8. Save State     9. View State   10. Delete State    11. Load State");
    }

    public void GO() throws Exception{

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
            else if(x==8)
            {
                saveState();
            }
            else if(x==9)
            {
                viewState();
            }
            else if(x==10)
            {
               deleteState();
            }
            else if(x==11)
            {
                loadState();
            }
        }
    }
    public void saveState()throws Exception
    {

        Scanner sc= new Scanner(System.in); //System.in is a standard input stream.

        System.out.print("\nEnter State name: ");
        String x= sc.next();
        file_controller.saveState(arr,x);
    }
    public void viewState()throws Exception
    {
        String arr2[]=new String[10];
        arr2=file_controller.viewState();
        for(int i=0;i<10;i++)
        {
            if(arr2[i]==null)
            {
                break;
            }
            System.out.println(arr2[i]+"\n");
        }
    }
    public void deleteState()throws Exception
    {
        Scanner sc= new Scanner(System.in); //System.in is a standard input stream.

        System.out.print("\nEnter State to Delete: ");
        String x= sc.next();
        file_controller.deleteState(x);
    }
    public void loadState()throws Exception
    {
        Scanner sc= new Scanner(System.in); //System.in is a standard input stream.

        System.out.print("\nEnter State to load: ");
        String x= sc.next();
       arr= file_controller.loadState (x);
    }



}
