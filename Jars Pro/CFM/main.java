public class main {
    public static void main(String []args){
        GUI_implementation obj=new GUI_implementation();
        File_Handling obj2=new File_Handling();

        Console c=new Console(obj,obj2);
        c.GO();

    }
}
