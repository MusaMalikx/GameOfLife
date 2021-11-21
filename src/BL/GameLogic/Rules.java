package BL.GameLogic;

public class Rules {

    public Rules()
    {}
    void findNeighbours(Grid grid)
    {
        int neighbourCount=0;
        for(int i=0;i< grid.getRow();i++)
        {
            for(int j=0;j<grid.getCol();j++)
            {
                neighbourCount=0;
                for(int l=-1;l<2;l++)
                {
                    for(int m=-1;m<2;m++)
                    {
                        if(i+l>=0 && i+l< grid.getRow() && m+j>=0 && m+j< grid.getCol() )
                        {
                            if(grid.getCellStatus(i+l,m+j))
                            {
                                neighbourCount++;
                            }
                        }
                    }
                }
                if(grid.getCellStatus(i,j)) {
                    grid.setCellNeighbours(i, j, neighbourCount-1);
                }
                else
                {
                    grid.setCellNeighbours(i, j, neighbourCount);
                }
            }
        }

    }
    public void ApplyRules(Grid grid)
    {
        cell future[][] = new cell[grid.getRow()][grid.getCol()];


        for (int i = 0; i <grid.getRow(); i++)
        {
            for (int j = 0; j < grid.getCol(); j++)
            {
                future[i][j] = new cell();
            }
        }

        findNeighbours(grid);


        for(int i=0;i<grid.getRow();i++)
        {
            for(int j=0;j<grid.getCol();j++)
            {
                // Cell is lonely and dies

                if ((grid.getCellStatus(i,j) ) && (grid.getCellNeighbours(i,j) < 2)) {
                    future[i][j].setStatus(false);
                    future[i][j].setPosition(i,j);
                }
                    // Cell dies due to over population
                else if ((grid.getCellStatus(i,j) ) && (grid.getCellNeighbours(i,j) > 3)) {
                    future[i][j].setStatus(false);
                    future[i][j].setPosition(i,j);
                }
                    // A new cell is born
                else if ((!grid.getCellStatus(i,j)) && (grid.getCellNeighbours(i,j)  == 3)) {
                    future[i][j].setStatus(true);
                    future[i][j].setPosition(i,j);
                }
                    // Remains the same
                else
                {
                    future[i][j].setStatus(grid.getCellStatus(i,j));
                    future[i][j].setPosition(i,j);
                }
            }
        }
        for (int i = 0; i <grid.getRow(); i++)
        {
            for (int j = 0; j < grid.getCol(); j++)
            {
                grid.setCellStatus(i,j,future[i][j].isAlive());

            }
        }
    }

}
