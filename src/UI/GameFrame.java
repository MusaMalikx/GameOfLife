package UI;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameFrame extends JFrame implements ChangeListener, ActionListener
{
    MainButton start,reset,next;
    int counter,delay;
    JLabel label;

    int rows;
    int columns;
    JSlider slider,speeder;
    JPanel GridPanel;
    Cell[][] c;

    Timer timer = new Timer(500, new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            counter++;
            label.setText(Integer.toString(counter));
        }
    });

    public GameFrame(){
        counter = 0;
        delay = 0;
        label = new JLabel("");
        label.setFont(new Font("Consolas",Font.PLAIN,14));

        start = new MainButton("START");
        start.btn.addActionListener(this);

        next = new MainButton("NEXT");
        next.btn.addActionListener(this);

        reset = new MainButton("RESET");
        reset.btn.addActionListener(this);

        label.setText(Integer.toString(this.counter));

        slider = new JSlider(0,50,25);
        speeder = new JSlider(0,50,25);

        speeder.setPreferredSize(new Dimension(100,50));
        speeder.setBackground(Color.yellow);

        speeder.setPaintTrack(true);
        speeder.setMajorTickSpacing(10);
        speeder.addChangeListener(this);

        slider.setPreferredSize(new Dimension(100,50));
        slider.setBackground(Color.pink);

        slider.setPaintTrack(true);
        slider.setMajorTickSpacing(10);
        slider.addChangeListener(this);

        slider.addChangeListener(this);
        speeder.addChangeListener(this);

        //this.rows = Integer.parseInt(r);
        this.rows = 20;
        //this.columns = Integer.parseInt(c);
        this.columns = 40;

        this.UI_FRAME();
    }

    public GameFrame(String r, String co){

        counter = 0;
        delay = 0;
        label = new JLabel("");

        start = new MainButton("START");
        start.btn.addActionListener(this);

        next = new MainButton("NEXT");
        next.btn.addActionListener(this);

        reset = new MainButton("RESET");
        reset.btn.addActionListener(this);

        label.setText(Integer.toString(this.counter));

        slider = new JSlider(0,50,25);
        speeder = new JSlider(0,50,25);

        speeder.setPreferredSize(new Dimension(100,50));
        speeder.setBackground(Color.yellow);

        speeder.setPaintTrack(true);
        speeder.setMajorTickSpacing(10);
        speeder.addChangeListener(this);

        slider.setPreferredSize(new Dimension(100,50));
        slider.setBackground(Color.pink);
        //slider.setPaintTicks(true);
        //slider.setMinorTickSpacing(2);

        slider.setPaintTrack(true);
        slider.setMajorTickSpacing(10);
        slider.addChangeListener(this);

        slider.addChangeListener(this);
        speeder.addChangeListener(this);

        this.rows = Integer.parseInt(r);
        //this.rows = 100;
        this.columns = Integer.parseInt(co);
        //this.columns = 100;

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
        GridPanel = new JPanel();

        Jrpanel1.setPreferredSize(new Dimension(13,13));
        Jrpanel2.setPreferredSize(new Dimension(13,13));
        Jrpanel3.setPreferredSize(new Dimension(13,13));
        Jrpanel4.setPreferredSize(new Dimension(13,13));
        GridPanel.setPreferredSize(new Dimension(100,100));

        Jrpanel1.setBackground(Color.darkGray);
        Jrpanel2.setBackground(Color.darkGray);
        Jrpanel3.setBackground(Color.darkGray);
        Jrpanel4.setBackground(Color.darkGray);

        panel1.setBackground(Color.red);
        panel2.setBackground(Color.pink);
        panel3.setLayout(new BorderLayout());
        panel3.setBackground(Color.white);

        panel1.setPreferredSize(new Dimension(100,100));
        panel2.setPreferredSize(new Dimension(100,100));
        panel3.setPreferredSize(new Dimension(100,100));

        this.add(panel1,BorderLayout.NORTH);
        this.add(panel2,BorderLayout.SOUTH);
        this.add(panel3,BorderLayout.CENTER);

        panel3.add(Jrpanel1,BorderLayout.NORTH);
        panel3.add(Jrpanel2,BorderLayout.WEST);
        panel3.add(Jrpanel3,BorderLayout.EAST);
        panel3.add(Jrpanel4,BorderLayout.SOUTH);
        panel3.add(GridPanel,BorderLayout.CENTER);

        this.UI_GRID();

        speeder.addChangeListener(this);
        slider.addChangeListener(this);

        panel2.add(speeder);
        panel2.add(slider);

        panel2.add(start.btn);
        panel2.add(reset.btn);
        panel2.add(next.btn);
        panel2.add(label);

        this.setVisible(true);
    }

    public void UI_GRID(){
        GridPanel.setLayout(new GridLayout(this.rows,this.columns));

        c = new Cell [this.rows][];

        for (int i = 0; i < this.columns; i++) {
            c = new Cell [i][this.columns];
        }
        for (int i = 0; i < this.rows; i++) {
            for (int j = 0; j < this.columns; j++) {
                c[i][j] = new Cell(i,j);
                GridPanel.add(c[i][j].getBtn());
            }
        }
    }

    public void UpdateUI_Grid(int r, int co){
        this.rows = r;
        this.columns = co;
        GridPanel.setLayout(new GridLayout(this.rows,this.columns));

        c = new Cell [this.rows][];

        for (int i = 0; i < this.columns; i++) {
            c = new Cell [i][this.columns];
        }
//        GridPanel.removeAll();
//        GridPanel.setLayout(new GridLayout(2,4));
        for (int i = 0; i < this.rows; i++) {
            for (int j = 0; j < this.columns; j++) {
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

    public void StartGame(){
        timer.start();
    }

    public void StopGame(){
        timer.stop();
    }

    public void NextGame(){
        counter++;
        label.setText(Integer.toString(counter));
    }

    public void ResetGame(){
        timer.stop();
        this.counter = 0;
        label.setText(Integer.toString(counter));
        start.click = false;
        start.btn.setText("START");

        for (int i = 0; i < this.rows; i++) {
            for (int j = 0; j < this.columns; j++) {
                //c[i][j] = new Cell(i,j);
                c[i][j].getBtn().setBackground(Color.lightGray);
            }
        }

    }

    @Override
    public void stateChanged(ChangeEvent e) {
        if(e.getSource() == speeder){
            System.out.println(speeder.getValue());
            if(speeder.getValue() > 25){
                int check = 50 - speeder.getValue();
                this.delay = check * 10 ;
                this.timer.setDelay(this.delay);
            }
            else if(speeder.getValue() < 25){
                int check = 50 - speeder.getValue();
                this.delay = check * 20 ;
                this.timer.setDelay(this.delay);
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==start.btn){
            if(!start.click){
                start.click = true;
                start.btn.setText("STOP");
                this.StartGame();
            }
            else{
                start.click = false;
                start.btn.setText("START");
                this.StopGame();
            }
        }
        if(e.getSource()==next.btn){
            this.NextGame();
        }
        if(e.getSource()==reset.btn){
            this.ResetGame();
        }
    }
}
