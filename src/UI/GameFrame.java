package UI;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class GameFrame extends JFrame implements ChangeListener{


    //JButton start,reset,stop,clear;
    SliderFrame slide;
    ButtonFrame btns;
    int rows;
    int columns;
//    JSlider slider;
//    JSlider speeder;
    JPanel GridPanel;
    //int GridArray[][];
    Cell[][] c;

    public GameFrame(){
//        start = new JButton("START");
//        reset = new JButton("RESET");
//        stop = new JButton("STOP");
//        clear = new JButton("CLEAR");
        btns = new ButtonFrame();
        slide = new SliderFrame();
//        slider = new JSlider(0,100,50);
//        speeder = new JSlider(0,100,50);
        //this.rows = Integer.parseInt(r);
        this.rows = 20;
        //this.columns = Integer.parseInt(c);
        this.columns = 40;

        c = new Cell [this.rows][];

        for (int i = 0; i < this.columns; i++) {
            c = new Cell [i][this.columns];
        }

        slide.setColumns(this.columns);
        slide.setRows(this.rows);
        this.UI_FRAME();
    }

    public GameFrame(String r, String co){

//        start = new JButton("START");
//        reset = new JButton("RESET");
//        stop = new JButton("STOP");
//        clear = new JButton("CLEAR");
        btns = new ButtonFrame();
        slide = new SliderFrame();
//        slider = new JSlider(0,100,50);
//        speeder = new JSlider(0,100,50);

        this.rows = Integer.parseInt(r);
        //this.rows = 100;
        this.columns = Integer.parseInt(co);
        //this.columns = 100;

        c = new Cell [this.rows][];

        for (int i = 0; i < this.columns; i++) {
            c[i] = new Cell [this.columns];
        }

        slide.setColumns(this.columns);
        slide.setRows(this.rows);
        this.UI_FRAME();
    }

    public void UI_FRAME(){

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1200,700);
        this.setLayout(new BorderLayout());
        this.setTitle("Game of Life Clone");

        JPanel panel1 = new JPanel();
        JPanel panel2 = new JPanel();
        JPanel panel3 = new JPanel();

        JPanel Jrpanel1 = new JPanel();
        JPanel Jrpanel2 = new JPanel();
        JPanel Jrpanel3 = new JPanel();
        JPanel Jrpanel4 = new JPanel();
        //JPanel Jrpanel5 = new JPanel();
        GridPanel = new JPanel();

        Jrpanel1.setPreferredSize(new Dimension(13,13));
        Jrpanel2.setPreferredSize(new Dimension(13,13));
        Jrpanel3.setPreferredSize(new Dimension(13,13));
        Jrpanel4.setPreferredSize(new Dimension(13,13));
        GridPanel.setPreferredSize(new Dimension(100,100));

        //Jrpanel5.setLayout(new GridLayout(this.rows,this.columns));

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

//        JLabel label = new JLabel();
//        ImageIcon top = new ImageIcon("top.PNG");
//        label.setIcon(top);
//        panel1.setLayout(null);
//        panel1.add(label);

//        BufferedImage myPicture = ImageIO.read("top.PNG"));
//        JLabel picLabel = new JLabel(new ImageIcon(myPicture));
//        //add(picLabel);
//        panel1.add(picLabel);

        this.add(panel1,BorderLayout.NORTH);
        this.add(panel2,BorderLayout.SOUTH);
        this.add(panel3,BorderLayout.CENTER);

        panel3.add(Jrpanel1,BorderLayout.NORTH);
        panel3.add(Jrpanel2,BorderLayout.WEST);
        panel3.add(Jrpanel3,BorderLayout.EAST);
        panel3.add(Jrpanel4,BorderLayout.SOUTH);
        panel3.add(GridPanel,BorderLayout.CENTER);

        this.UI_GRID();
//        for (int i = 0; i < this.rows; i++) {
//            for (int j = 0; j < this.columns; j++) {
//                JButton btn = new JButton("");
//                btn.setBackground(Color.lightGray);
//                btn.setBorder(BorderFactory.createEtchedBorder());
//                Jrpanel5.add(btn);
//            }
//        }

//        speeder.setPreferredSize(new Dimension(100,50));
//        speeder.setBackground(Color.yellow);
//        //slider.setPaintTicks(true);
//        //slider.setMinorTickSpacing(2);
//
//        speeder.setPaintTrack(true);
//        speeder.setMajorTickSpacing(10);
//        speeder.addChangeListener(this);
//        panel2.add(speeder);
//
//        slider.setPreferredSize(new Dimension(100,50));
//        slider.setBackground(Color.pink);
//        //slider.setPaintTicks(true);
//        //slider.setMinorTickSpacing(2);
//
//        slider.setPaintTrack(true);
//        slider.setMajorTickSpacing(10);
//        slider.addChangeListener(this);
//        //slider.setPaintLabels(true);
        slide.speeder.addChangeListener(this);
        slide.slider.addChangeListener(this);
        panel2.add(slide.speeder);
        panel2.add(slide.slider);
//        panel2.add(start);
//        panel2.add(reset);
//        panel2.add(clear);
//        panel2.add(stop);
        panel2.add(btns.start.btn);
        panel2.add(btns.reset.btn);
        //panel2.add(btns.stop.btn);
        panel2.add(btns.next.btn);
        panel2.add(btns.label);

        this.setVisible(true);
        //this.PrintCellLocation();
    }

    public void UI_GRID(){
        GridPanel.setLayout(new GridLayout(this.rows,this.columns));
        for (int i = 0; i < this.rows; i++) {
            for (int j = 0; j < this.columns; j++) {
//                JButton btn = new JButton("");
//                btn.setBackground(Color.lightGray);
//                btn.setBorder(BorderFactory.createEtchedBorder());
//                System.out.println(btn.getLocation());
                c[i][j] = new Cell(i,j);
                GridPanel.add(c[i][j].getBtn());
            }
        }
    }

    public void PrintCellLocation(){
        for (int i = 0; i < this.rows; i++) {
            for (int j = 0; j < this.columns; j++) {
                System.out.println(c[i][j].x + " " + c[i][j].y + "  ");
            }
            System.out.println('\n');
        }
    }

    @Override
    public void stateChanged(ChangeEvent e) {
        if(e.getSource() == slide.speeder){
            System.out.println(slide.speeder.getValue());
            if(slide.speeder.getValue() > 25){
                int check = 50 - slide.speeder.getValue();
                btns.delay = check * 10 ;
                btns.timer.setDelay(btns.delay);
            }
            else if(slide.speeder.getValue() < 25){
                int check = 50 - slide.speeder.getValue();
                btns.delay = check * 20 ;
                btns.timer.setDelay(btns.delay);
            }
        }
    }
}
