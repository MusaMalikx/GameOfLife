package BL.GameLogic;

public interface file {

    public String[] viewState()throws Exception;
    public int[][] loadState(String name)throws Exception;
    public void deleteState(String name)throws Exception;
    public void saveState(int arr[][],String name)throws Exception;

}
