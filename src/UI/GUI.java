package UI;
import BL.GameLogic.GUI_implementation;
import File.File_Handling;

public class GUI {

        public static void main(String[] args)throws Exception
        {
//            int a=0;
//            a=10;
          GUI_implementation obj=new GUI_implementation();

            File_Handling obj2=new File_Handling();
        //GameFrame gf = new GameFrame(obj);
        //TextFields tx = new TextFields();
           //Console c=new Console(obj,obj2);
            //c.GO();

        GameFrame gf = new GameFrame(obj,obj2);
        //TextFields tx = new TextFields();
          //  Console c=new Console(obj);
           // c.GO();

    }
}
