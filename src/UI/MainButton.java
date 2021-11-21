package UI;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class MainButton {
    boolean click;
    JButton btn;

    public MainButton(String s,ImageIcon icon){
        this.click = false;
        this.btn = new JButton(s);
        btn.setSize(25,20);

        Image img = icon.getImage();
        Image imgScale = img.getScaledInstance(btn.getWidth(),btn.getHeight(),Image.SCALE_SMOOTH);
        ImageIcon i = new ImageIcon(imgScale);
        btn.setIcon(i);

        this.btn.setBorder(new RoundBtn(8));
        this.btn.setBackground(Color.CYAN);
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
