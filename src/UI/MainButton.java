package UI;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class MainButton {
    boolean click;
    JButton btn;

    public MainButton(String s){
        this.click = false;
        this.btn = new JButton(s);
        btn.setSize(25,20);

//        Image img = icon.getImage();
//        Image imgScale = img.getScaledInstance(btn.getWidth(),btn.getHeight(),Image.SCALE_SMOOTH);
//        ImageIcon i = new ImageIcon(imgScale);
//        btn.setIcon(i);

        btn.setSize(50,40);
        this.btn.setPreferredSize(new Dimension(90,40));
        //this.btn.setBorder(new RoundBtn(8));
        this.btn.setFont(new Font("Consolas",Font.PLAIN,18));
        this.btn.setBackground(Color.cyan);
        //btn.setSize(new Dimension(5,5));
    }

    public MainButton(String s, Color c, Color f){
        this.click = false;
        this.btn = new JButton(s);
        btn.setSize(50,40);

//        Image img = icon.getImage();
//        Image imgScale = img.getScaledInstance(btn.getWidth(),btn.getHeight(),Image.SCALE_SMOOTH);
//        ImageIcon i = new ImageIcon(imgScale);
//        btn.setIcon(i);

        //this.btn.setBorder(new RoundBtn(8));
        this.btn.setPreferredSize(new Dimension(90,40));
        this.btn.setBackground(c);
        this.btn.setForeground(f);
        this.btn.setFont(new Font("Consolas",Font.PLAIN,18));
        //btn.setSize(new Dimension(5,5));
    }

    public void setBool(boolean b){
        this.click = b;
    }

    public boolean getBool(){
        return this.click;
    }

}

class RoundBtn implements Border {
    private int r;

    RoundBtn(int r) {
        this.r = r;
    }

    public Insets getBorderInsets(Component c) {
        return new Insets(this.r + 1, this.r + 1, this.r + 2, this.r);
    }

    public boolean isBorderOpaque() {
        return true;
    }

    public void paintBorder(Component c, Graphics g, int x, int y, int width, int height)
    {
        g.drawRoundRect(x, y, width - 1, height - 1, r, r);
    }
}
