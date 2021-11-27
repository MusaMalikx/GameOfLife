package BL.GameLogic;

public interface file {
    public void viewState();
    public int[][] loadState(int n)throws Exception;
    public void deleteState(int stateNum);
    public void saveState(int arr[][])throws Exception;

}
