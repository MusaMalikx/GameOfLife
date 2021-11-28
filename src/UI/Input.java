package UI;

import javax.swing.*;
import java.awt.*;

public class Input extends JFrame {
    JButton btn;
    JTextField in;

    public Input(){

        this.setLayout(new FlowLayout());
        this.setTitle("Save State");
        this.setSize(new Dimension(500,90));
        this.btn = new JButton("Submit");
        this.in = new JTextField();
        this.in.setPreferredSize(new Dimension(250,40));
        this.in.setFont(new Font("Consolas",Font.PLAIN,14));
        this.in.setBackground(Color.black);
        this.in.setCaretColor(Color.white);
        this.in.setForeground(Color.red);
        this.in.setText("Enter the State Name");
        this.add(this.btn);
        this.add(this.in);
        this.setVisible(true);
    }
}
