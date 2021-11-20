package UI;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class About extends JFrame {

    public About(){
        //this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1150,650);
        //this.pack();
        //this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setLayout(new FlowLayout());
        this.setTitle("About Info");
        //this.setVisible(true);

        Images();
        this.setVisible(true);
    }

    public void Images() {
        Member("/Members/malik.jpg");
        Member("/Members/suleiman.jpg");
    }

    public void Member(String str){
        ImageIcon ico = new ImageIcon(getClass().getResource(str));
        JLabel l = new JLabel();
        l.setSize(new Dimension(400,250));
        Image img = ico.getImage();
        Image imgScale = img.getScaledInstance(l.getWidth(),l.getHeight(),Image.SCALE_SMOOTH);
        ImageIcon i = new ImageIcon(imgScale);
        //l.setPreferredSize(new Dimension(100,100));
        //ico.getImage().getScaledInstance(100,200,Image.SCALE_SMOOTH);
        l.setIcon(i);
        //l.setPreferredSize(new Dimension(100,100));
        this.add(l);
    }
}
