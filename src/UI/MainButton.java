package UI;

import javax.swing.*;
import java.awt.*;

public class MainButton {
    boolean click;
    JButton btn;

    public MainButton(String s,ImageIcon icon){
        this.click = false;
        this.btn = new JButton(s,icon);
        //btn.setSize(new Dimension(5,5));
    }


    public void setBool(boolean b){
        this.click = b;
    }

    public boolean getBool(){
        return this.click;
    }

}
