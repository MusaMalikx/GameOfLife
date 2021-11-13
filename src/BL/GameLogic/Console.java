package GameLogic;
import java.util.*;
public class Console {

    public Console()
    {}
    public void selectCell(Grid grid)
    {

        Scanner sc= new Scanner(System.in); //System.in is a standard input stream.

        System.out.print("Enter index x : ");
        int x= sc.nextInt();
        if(x> grid.getRow())
        {
            System.out.println("max row index is : "+ grid.getRow() );
            return;
        }
        System.out.print("Enter index y : ");
        int y= sc.nextInt();
        if(x> grid.getRow())
        {
            System.out.println("max col index is : "+ grid.getCol() );
            return;
        }
        grid.setCellStatus(x,y,!grid.getCellStatus(x,y));

    }
    public void start(Grid grid)
    {
        Rules r;
        r=new Rules();
        r.ApplyRules(grid);

    }
    public void SpeedControl()
    {}
    public void zoomControl()
    {}
    public void printGrid(Grid grid)
    {
        grid.printGrid();
    }


}
