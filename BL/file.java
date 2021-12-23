public interface file {

    public String[] viewState();
    public int[][] loadState(String name);
    public void deleteState(String name);
    public void saveState(int arr[][],String name);

}
