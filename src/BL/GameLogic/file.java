package BL.GameLogic;

import org.json.simple.JSONObject;

public interface file {

    public JSONObject viewState()throws Exception;
    public JSONObject loadState(JSONObject n)throws Exception;
    public void deleteState(JSONObject ob)throws Exception;
    public void saveState(JSONObject ob)throws Exception;

}
