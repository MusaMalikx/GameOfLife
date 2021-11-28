package UI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Input extends JFrame implements ActionListener {
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
       // this.in.setText("Enter the State Name");
        this.add(this.btn);
        this.btn.addActionListener(this);
        this.add(this.in);
        this.in.addActionListener(this);
        this.setVisible(true);
    }


    public String getTextFeild()
    {
        return this.in.getText();
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==btn)
        {
          //  System.out.println(this.in.getText());

        }
    }

}
