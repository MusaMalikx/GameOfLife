package BL.GameLogic;

public interface file {
    public int[] viewState()throws Exception;
    public int[][] loadState(int n)throws Exception;
    public void deleteState(int stateNum)throws Exception;
    public void saveState(int arr[][])throws Exception;

}
