package  BL.GameLogic;;
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
    public void SpeedControl(Grid_Controller controller)
    {
        Scanner sc= new Scanner(System.in); //System.in is a standard input stream.

        System.out.print("Enter Speed (max 10) : ");
        int x= sc.nextInt();
        controller.setSpeed(x);
    }
    public void zoomControl(Grid_Controller controller)
    {
        Scanner sc= new Scanner(System.in); //System.in is a standard input stream.

        System.out.print("Enter zoom (max 10) : ");
        int x= sc.nextInt();
        controller.setZoom(x);
    }
    public void printGrid(Grid grid, Grid_Controller cont)
    {
        cell temp[][]= new cell[grid.getRow()][grid.getCol()];;
        for (int i = 0; i <grid.getRow(); i++)
        {
            for (int j = 0; j < grid.getCol(); j++)
            {
                temp[i][j] = new cell();
            }
        }

        for (int i = 0; i <grid.getRow(); i++)
        {
            for (int j = 0; j < grid.getCol(); j++)
            {
                grid.setCellStatus(i,j,temp[i][j].isAlive());

            }
        }

        int zoom=cont.getZoom();
        zoom =zoom/2;
        for(int i=0+zoom;i< grid.getRow()-zoom;i++)
        {
            for(int j=0+zoom;j< grid.getCol()-zoom;j++)
            {
                temp[i][j].printCell();
                System.out.print(" ");
            }
            System.out.print('\n');
        }

    }


}
