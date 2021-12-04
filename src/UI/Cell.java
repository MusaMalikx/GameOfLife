package UI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Cell extends JFrame implements ActionListener {

    private boolean click;
    private JButton btn;
    private int x;
    private int y;

    public Cell(int x, int y){
        btn = new JButton("");
        btn.setBackground(Color.white);
        //btn.setBorder(BorderFactory.createLoweredBevelBorder());
        btn.addActionListener(this);
        this.x = x;
        this.y = y;
    }

    JButton getBtn(){
        return this.btn;
    }

    public boolean getClick(){
        return this.click;
    }

    public void setClick(boolean b){
        this.click = b;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == btn){
            if(!this.click){
                this.btn.setBackground(Color.yellow);
                this.click = true;
            }
            else{
                this.btn.setBackground(Color.white);
                this.click = false;
            }
        }
    }
}
