package UI;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;

public class GameFrame extends JFrame implements ChangeListener {

    JButton start,reset,stop,clear;
    int rows;
    int columns;
    JSlider slider;

    public GameFrame(String r, String c){

        start = new JButton("START");
        reset = new JButton("RESET");
        stop = new JButton("STOP");
        clear = new JButton("CLEAR");
        slider = new JSlider(0,100,50);

        this.rows = Integer.parseInt(r);
        this.columns = Integer.parseInt(c);
        this.UI_Grid();
    }

    public void UI_Grid(){

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(900,600);
        this.setLayout(new BorderLayout());
        this.setTitle("Game of Life Clone");

        JPanel panel1 = new JPanel();
        JPanel panel2 = new JPanel();
        JPanel panel3 = new JPanel();

        JPanel Jrpanel1 = new JPanel();
        JPanel Jrpanel2 = new JPanel();
        JPanel Jrpanel3 = new JPanel();
        JPanel Jrpanel4 = new JPanel();
        JPanel Jrpanel5 = new JPanel();

        Jrpanel1.setPreferredSize(new Dimension(13,13));
        Jrpanel2.setPreferredSize(new Dimension(13,13));
        Jrpanel3.setPreferredSize(new Dimension(13,13));
        Jrpanel4.setPreferredSize(new Dimension(13,13));
        Jrpanel5.setPreferredSize(new Dimension(100,100));

        Jrpanel5.setLayout(new GridLayout(this.rows,this.columns));

        Jrpanel1.setBackground(Color.darkGray);
        Jrpanel2.setBackground(Color.darkGray);
        Jrpanel3.setBackground(Color.darkGray);
        Jrpanel4.setBackground(Color.darkGray);
        //Jrpanel5.setBackground(Color.yellow);

        panel3.setLayout(new BorderLayout());
//new GridLayout(this.rows,this.columns)
        panel1.setBackground(Color.red);
        panel2.setBackground(Color.pink);
        panel3.setBackground(Color.white);

        panel1.setPreferredSize(new Dimension(100,100));
        panel2.setPreferredSize(new Dimension(100,100));
        panel3.setPreferredSize(new Dimension(100,100));

        JLabel label = new JLabel();
        ImageIcon top = new ImageIcon("top.PNG");
        label.setIcon(top);
        panel1.setLayout(null);
        panel1.add(label);

        this.add(panel1,BorderLayout.NORTH);
        this.add(panel2,BorderLayout.SOUTH);
        this.add(panel3,BorderLayout.CENTER);

        panel3.add(Jrpanel1,BorderLayout.NORTH);
        panel3.add(Jrpanel2,BorderLayout.WEST);
        panel3.add(Jrpanel3,BorderLayout.EAST);
        panel3.add(Jrpanel4,BorderLayout.SOUTH);
        panel3.add(Jrpanel5,BorderLayout.CENTER);

        for (int i = 0; i < this.rows; i++) {
            for (int j = 0; j < this.columns; j++) {
                JButton btn = new JButton("");
                btn.setBackground(Color.lightGray);
                btn.setBorder(BorderFactory.createEtchedBorder());
                Jrpanel5.add(btn);
            }
        }

        slider.setPreferredSize(new Dimension(150,20));

        panel2.add(slider);
        panel2.add(start);
        panel2.add(reset);
        panel2.add(clear);
        panel2.add(stop);

        this.setVisible(true);

    }

    @Override
    public void stateChanged(ChangeEvent e) {

    }
}
