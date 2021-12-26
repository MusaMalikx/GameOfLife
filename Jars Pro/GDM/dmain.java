public class dmain {
        public static void main(String []args){
            GUI_implementation obj=new GUI_implementation();

            DatabaseHandler obj2 = new DatabaseHandler();
            GameFrame gf = new GameFrame(obj,obj2);
        }
}
