package BL.GameLogic;

import org.json.simple.JSONObject;

public interface GUI_Interface {
   public void reset();
    public JSONObject next(JSONObject arr);
    public JSONObject getCol();
    public JSONObject getRow();


}
