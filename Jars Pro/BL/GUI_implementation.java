public class GUI_implementation implements GUI_Interface {
    public GUI_implementation()
    {}
    public int [][] next(int arr[][])
    {
        Data gridSize=new Data();
int col=gridSize.getCol();
int row=gridSize.getRow();
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

    public int getCol(){
        Data gridSize=new Data();
        return  gridSize.getCol();
    }

    public int getRow(){
        Data gridSize=new Data();
        return  gridSize.getRow();
    }

    public static void main(String[] args){
                
    }

}
