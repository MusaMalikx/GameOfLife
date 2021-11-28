package UI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class View extends JFrame implements ActionListener {

    MainButton load,delete;

    public View(){
        this.setSize(1150,500);
        //this.pack();
        //this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setLayout(new FlowLayout());
        this.setTitle("View State");
        vew();
        this.setVisible(true);
    }
    public void vew(){
        load = new MainButton("LOAD",new Color(255, 165, 165),Color.darkGray);
        this.load.btn.addActionListener(this);
        delete = new MainButton("DELETE",new Color(236, 70, 70),Color.white);
        this.delete.btn.addActionListener(this);
        this.add(load.btn);
        this.add(delete.btn);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==load.btn){


        }
        if(e.getSource()==delete.btn){

        }
    }
}
