package UI;
import BL.GameLogic.GUI_implementation;
import Database.DatabaseHandler;
import File.File_Handling;

public class GUI {

        public static void main(String[] args)throws Exception
        {
          GUI_implementation obj=new GUI_implementation();
          File_Handling obj2=new File_Handling();

           Console c=new Console(obj,obj2);
            c.GO();

            DatabaseHandler db = new DatabaseHandler();


      //  GameFrame gf = new GameFrame(obj,obj2);
    }
}
