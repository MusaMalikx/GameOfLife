package UI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Cell extends JFrame implements ActionListener {

    boolean click;
    JButton btn;
    int x;
    int y;

    public Cell(int x, int y){
        btn = new JButton("");
        btn.setBackground(Color.lightGray);
        btn.setBorder(BorderFactory.createLoweredBevelBorder());
        btn.addActionListener(this);
        this.x = x;
        this.y = y;
    }

    JButton getBtn(){
        return this.btn;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == btn){
            this.btn.setBackground(Color.yellow);
            this.click = true;
        }
    }
}
