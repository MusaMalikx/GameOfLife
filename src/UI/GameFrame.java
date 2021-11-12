package UI;

import javax.swing.*;
import java.awt.*;

public class GameFrame extends JFrame {

    int rows;
    int columns;

    public GameFrame(String r, String c){
        this.rows = Integer.parseInt(r);
        this.columns = Integer.parseInt(c);
        this.UI_Grid();
    }

    public void UI_Grid(){

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(700,500);
        this.setLayout(new BorderLayout());
        this.setTitle("Game of Life Clone");
//(new GridLayout(this.rows,this.columns))
//        for (int i = 0; i < this.rows; i++) {
//            for (int j = 0; j < this.columns; j++) {
//                JButton btn = new JButton("");
//                btn.setBackground(Color.lightGray);
//                btn.setBorder(BorderFactory.createEtchedBorder());
//                this.add(btn);
//            }
//        }

        JPanel panel1 = new JPanel();
        //JPanel panel2 = new JPanel();
        //JPanel panel3 = new JPanel();
        JPanel panel4 = new JPanel();
        JPanel panel5 = new JPanel();

        panel5.setLayout(new GridLayout(this.rows,this.columns));

        panel1.setBackground(Color.red);
        //panel2.setBackground(Color.green);
        //panel3.setBackground(Color.yellow);
        panel4.setBackground(Color.pink);
        //panel5.setBackground(Color.pink);

        panel1.setPreferredSize(new Dimension(100,100));
        //panel2.setPreferredSize(new Dimension(100,100));
        //panel3.setPreferredSize(new Dimension(100,100));
        panel4.setPreferredSize(new Dimension(100,100));
        panel5.setPreferredSize(new Dimension(100,100));

        this.add(panel1,BorderLayout.NORTH);
        //this.add(panel2,BorderLayout.WEST);
        //this.add(panel3,BorderLayout.EAST);
        this.add(panel4,BorderLayout.SOUTH);
        this.add(panel5,BorderLayout.CENTER);

        for (int i = 0; i < this.rows; i++) {
            for (int j = 0; j < this.columns; j++) {
                JButton btn = new JButton("");
                btn.setBackground(Color.lightGray);
                btn.setBorder(BorderFactory.createEtchedBorder());
                panel5.add(btn);
            }
        }

        this.setVisible(true);

    }

}
