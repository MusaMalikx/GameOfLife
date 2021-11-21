package BL.GameLogic;

public class GUI_implementation implements  GUI_Interface {
    public GUI_implementation()
    {}
    public int [][] next(int arr[][])
    {
int col=40;
int row=20;
        Grid grid=new Grid(row,col);
        for(int i=0;i<row;i++)
        {
            for(int j=0;j<col;j++)
            {
                if(arr[i][j]==0)
                {
                    grid.setCellStatus(i,j,false);
                }
                else if(arr[i][j]==1)
                {
                    grid.setCellStatus(i,j,true);
                }

            }

        }
        Rules r=new Rules();
        r.ApplyRules(grid);
        int arr2[][]=new int[row][col];
        for(int i=0;i<row;i++)
        {
            for(int j=0;j<col;j++)
            {
                if(grid.getCellStatus(i,j)==false)
                {
                    arr2[i][j]=0;
                }
                else
                {
                    arr2[i][j]=1;
                }
            }
        }
        return arr2;

    }
   public void reset()
   {

   }


}
