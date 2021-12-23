public class main {
    public static void main(String []args){
        GUI_implementation obj=new GUI_implementation();
        DatabaseHandler obj2 = new DatabaseHandler();

        Console c=new Console(obj,obj2);
        c.GO();

    }
}
