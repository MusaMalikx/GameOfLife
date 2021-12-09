package UI;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class About extends JFrame {

    public About(){
        this.setSize(1150,350);
        this.setLayout(new FlowLayout());
        this.setTitle("About Info");
        Images();
        this.setVisible(true);
    }

    public void Images() {

        Member("/Members/maida.jpg","Maida Tariq");
        Member("/Members/suleiman.jpg","Sulaiman Javed");
        Member("/Members/musa.jpg","Musa Malik");
        Member("/Members/burhan.jpg","Burhan Kiyani");
        Member("/Members/hamza.jpg","Ameer Hamza");
        Member("/Members/rafay.jpg","Rafay Izaan");

    }

    public void Member(String str, String n){
        ImageIcon ico = new ImageIcon(getClass().getResource(str));
        JLabel l = new JLabel();
        l.setSize(new Dimension(170,250));
        Image img = ico.getImage();
        Image imgScale = img.getScaledInstance(l.getWidth(),l.getHeight(),Image.SCALE_SMOOTH);
        ImageIcon i = new ImageIcon(imgScale);
        //l.setPreferredSize(new Dimension(100,100));
        //ico.getImage().getScaledInstance(100,200,Image.SCALE_SMOOTH);
        l.setIcon(i);
        l.setText(n);
        l.setHorizontalTextPosition(JLabel.CENTER);
        l.setVerticalTextPosition(JLabel.BOTTOM);
        l.setFont(new Font("Consolas",Font.ITALIC,15));
        //l.setPreferredSize(new Dimension(100,100));
        this.add(l);
    }
}
