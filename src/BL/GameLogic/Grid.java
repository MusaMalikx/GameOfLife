package GameLogic;
import java.util.Arrays;

public class Grid {

    private  cell grid[][];
    private int row;
    private int col;


    public Grid()
    {
        row=col=0;
    }
    public Grid(int r, int c)
    {
        row=r;
        col=c;
        grid = new cell[row][col];
        for (int i = 0; i <row; i++)
        {
            for (int j = 0; j < col; j++)
            {
                grid[i][j] = new cell();
            }
        }

        int i=0,j=0;


        for (i=0; i < row; i++)
        {
            for(j=0; j<col; j++)
            {
                grid[i][j].setStatus(false);
                grid[i][j].setPosition(i,j);
                grid[i][j].setNeighbours(0);
            }

        }
    }
    
    public int getRow()
    {
        return row;
    }
    public int getCol()
    {
        return col;
    }
    public cell[][] getGrid() {
        return grid;
    }
    cell getCell(int x,int y)
    {
        return grid[x][y];
    }

    public void printGrid()
    {
    for(int i=0;i<row;i++)
    {
        for(int j=0;j<col;j++)
        {
            grid[i][j].printCell();
            System.out.print(" ");
        }
    System.out.print('\n');
    }
    }
    public boolean getCellStatus(int x,int y)
    {
        return grid[x][y].isAlive();
    }
    public void setCellStatus(int x,int y,boolean val)
    {
        grid[x][y].setStatus(val);
    }
    public int getCellNeighbours(int x,int y)
    {
        return grid[x][y].getNeighboursCount();
    }
    public void setCellNeighbours(int x,int y,int val)
    {
         grid[x][y].setNeighbours(val);
    }

}