package UI;
import java.lang.Thread;
import java.awt.event.KeyEvent;
import BL.GameLogic.GUI_implementation;
import BL.GameLogic.file;
import BL.GameLogic.Data;
import BL.GameLogic.Grid;
import BL.GameLogic.Grid_Controller;
import BL.GameLogic.Rules;
import File.File_Handling;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

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

        int col=(int)implementation.getCol().get("col");
        int row=(int)implementation.getRow().get("row");
        arr=new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {

                arr[i][j] = 0;

            }
        }


        file_controller=new File_Handling();
        rows=row/3;
        columns=col/2;
    }
    public void selectCell()
    {

        Scanner sc= new Scanner(System.in); //System.in is a standard input stream.

        System.out.print("Enter index x : ");
        int x= sc.nextInt();
        if(x >= (int)implementation.getRow().get("row"))
        {
            System.out.println("max row index is : 60");
            return;
        }
        System.out.print("Enter index y : ");
        int y= sc.nextInt();
        if(y>=(int)implementation.getCol().get("col"))
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
                    start=false;
                    break;
                }
                   int col=(int)implementation.getCol().get("col");
                   int row=(int)implementation.getRow().get("row");
                   int arr2[][] = new int[row][col];

                   //-------------------------------------------------/
                   arr2 = implementation.JSONTOArray(implementation.next(implementation.ArrayToJSON(arr)));
                   //-------------------------------------------------/

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



next=true;

        int col=(int)implementation.getCol().get("col");
        int row=(int)implementation.getRow().get("row");

                    int arr2[][] = new int[row][col];

                    //--------------------------------------------/
        arr2 = implementation.JSONTOArray(implementation.next(implementation.ArrayToJSON(arr)));
        //------------------------------------------/

        for (int i = 0; i < row; i++) {
                        for (int j = 0; j < col; j++) {

                            arr[i][j] = arr2[i][j];

                        }

                    }
                    try {
                        Thread.sleep(speederCount*1000);
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

        int col=(int)implementation.getCol().get("col");
        int row=(int)implementation.getRow().get("row");
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
        if(x>= (int)implementation.getRow().get("row"))
        {
            System.out.println("max row index is : 60");
            return;

        }
        rows=x;
        System.out.print("Enter no of Columns to display (max 80) : ");
        int y=sc.nextInt();
        if(y>= (int)implementation.getCol().get("col"))
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


                Thread GameLoop=new Thread(new Runnable() {
                    @Override
                    public void run() {

                        for(;;) {
                            next();
                            printGrid();


                            if (stop == true) {
                                stop = false;
                                return;
                            }
                        }                    }
                });
                GameLoop.start();

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

        file_controller.saveState(Str_ArrayToJSON(arr,x));
        //file_controller.saveState(arr,x);
    }
    public void viewState()throws Exception
    {
        String arr2[]=new String[10];

        //---------------------------------------/
        arr2 = JSONToStrArray(file_controller.viewState());
        //arr2=file_controller.viewState();
        //--------------------------------------/

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

        //----------------------------------------------/
        file_controller.deleteState(StringToJSON(x));
        //file_controller.deleteState(x);
        //----------------------------------------------/

    }
    public void loadState()throws Exception
    {
        Scanner sc= new Scanner(System.in); //System.in is a standard input stream.

        System.out.print("\nEnter State to load: ");
        String x= sc.next();

        //-----------------------------------------/
        arr = JSONTOArray(file_controller.loadState(StringToJSON(x)));
        //arr= file_controller.loadState (x);
        //-----------------------------------------/

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
