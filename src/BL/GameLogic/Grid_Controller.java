package GameLogic;

import java.util.Objects;

public class Grid_Controller {
    int zoom;
    int delay;

    public Grid_Controller()
    {
        zoom=0;
        delay=0;
    }
    public int getDelay() {
        return delay;
    }

    public int getZoom() {
        return zoom;
    }

    public void setSpeed(int delay) {
        this.delay = delay;
    }

    public void setZoom(int zoom) {
        this.zoom = zoom;
    }




}
