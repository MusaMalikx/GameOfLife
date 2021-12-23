package BL.GameLogic;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class GUI_implementation implements  GUI_Interface {
    public GUI_implementation()
    {}
    public JSONObject next(JSONObject o)
    {
        //----------------------------/
        int[][] arr = JSONTOArray(o);
        //----------------------------/
        //arr.get
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

        //----------------------------/
        //return arr2;
        return ArrayToJSON(arr2);
        //----------------------------/

    }


   public void reset()
   {

   }

    public JSONObject getCol(){
        Data gridSize=new Data();
        JSONObject ja = new JSONObject();
        ja.put("col",gridSize.getCol());
        return ja;
        //return  gridSize.getCol();
    }

    public JSONObject getRow(){
        Data gridSize=new Data();
        JSONObject ja = new JSONObject();
        ja.put("row",gridSize.getRow() );
        return ja;
        //return  gridSize.getRow();
    }

    public JSONObject ArrayToJSON(int[][] arr){
        JSONObject o = new JSONObject();
        //ar.add(arr);
        //o.put("Array",ar);

        JSONArray jsonArray = new JSONArray();
        for (int[] ca : arr) {
            JSONArray arr1 = new JSONArray();
            for (int c : ca) {
                arr1.add(c); // or some other conversion
            }
            jsonArray.add(arr1);
        }

        o.put("Array",jsonArray);

        return o;

    }

    public int[][] JSONTOArray(JSONObject o){
        JSONArray aar = (JSONArray)o.get("Array");
        //System.out.println(aar.get(0));
        //System.out.println(aar.get(0).length);
        //System.out.println(aar.size());

        int arr2[][] = new int[aar.size()][];

        for (int i = 0; i < aar.size(); i++) {
            //System.out.println(aar.get(i));
            JSONArray a = (JSONArray)aar.get(i);
            //System.out.println(a.size());
            arr2[i] = new int[a.size()];
            for (int j = 0; j < a.size(); j++) {
                arr2[i][j] = (int)a.get(j);
            }
        }

        return arr2;
    }

}
