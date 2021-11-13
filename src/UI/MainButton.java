package UI;

import javax.swing.*;

public class MainButton {
    boolean click;
    JButton btn;

    public MainButton(String s){
        this.click=false;
        this.btn = new JButton(s);
    }

    public void setBool(boolean b){
        this.click = b;
    }

    public boolean getBool(){
        return this.click;
    }

}
