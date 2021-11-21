package BL.GameLogic;

public class cell {
   
    int x,y;
   boolean Alive;
   int neighbourCount;

   public cell()
   {
       x=y=neighbourCount=-1;
       Alive=false;
   }
   public cell(int X,int Y,boolean alive)
   {
      x=X;
      y=Y;
      Alive=alive;   
   }
    public void setPosition(int X,int Y)
    {
        x=X;
        y=Y;

    }
   public boolean isAlive()
   {
        return Alive;
   }
   public void setStatus(boolean val)
   {
        Alive=val;

   }
   public void setNeighbours(int x)
   {
neighbourCount=x;       
   }
   public int getNeighboursCount()
   {
       return neighbourCount;
   }
   public void printCell()
   {
if(Alive)
{
    System.out.print("o");
}
else
{
    System.out.print(".");
}
   }


}
