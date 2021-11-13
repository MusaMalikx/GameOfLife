package GameLogic;

public class Driver {
    public static void main(String args[])
    {


        Console c;
        c=new Console();
        Grid b=new Grid(10,20);
        for(int i=0;i<5;i++)
        {
            c.selectCell(b);
        }
            c.printGrid(b);
            c.start(b);
            c.printGrid(b);


    }
}
