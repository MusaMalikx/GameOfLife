package UI;
import java.lang.Thread;
import BL.GameLogic.GUI_implementation;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;
import 

public class GameFrame extends JFrame implements ChangeListener, ActionListener
{
    MainButton start,reset,next,stop,view,save;
    int counter,delay,sliderCount,speederCount;
    JLabel label;
    GUI_implementation implementation;

    int [][]arr;
    int rows;
    int columns;
    JSlider slider,speeder;
    JPanel GridPanel;
    Cell[][] c;
    JButton check;

    Timer timer = new Timer(500, new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            counter++;
            label.setText(Integer.toString(counter));
        }
    });

    public GameFrame(GUI_implementation obj){
        arr=new int[60][80];
        implementation= new GUI_implementation();
        implementation= obj;
        sliderCount = 0;
        speederCount = 0;
        counter = 0;
        delay = 0;
        label = new JLabel("");
        label.setFont(new Font("Consolas",Font.PLAIN,14));
        //label.setHorizontalTextPosition(JLabel.RIGHT);
        //BufferedImage image = ImageIO.read(getClass().getResource("../Images/start.png"));

        ImageIcon playIcon = new ImageIcon(Objects.requireNonNull(getClass().getResource("/Images/start.png")));//.getImage().getScaledInstance(20, 20, java.awt.Image.SCALE_SMOOTH));

//        Image img = playIcon.getImage();
//        Image imgScale = img.getScaledInstance(start.btn.getWidth(),start.btn.getHeight(),Image.SCALE_SMOOTH);
//        ImageIcon i = new ImageIcon(imgScale);


        start = new MainButton("START",new Color(23, 215, 160),Color.darkGray);
        start.btn.addActionListener(this);
        ImageIcon stopIcon = new ImageIcon(getClass().getResource("/Images/stop.png"));//new ImageIcon("F:\\Project\\GameOfLife\\src\\Images\\next.png").getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT));
        stop = new MainButton("STOP",new Color(255, 81, 81),Color.darkGray);
        stop.btn.setVisible(false);
        stop.btn.addActionListener(this);

        ImageIcon nextIcon = new ImageIcon(Objects.requireNonNull(getClass().getResource("/Images/next.png")));//new ImageIcon("F:\\Project\\GameOfLife\\src\\Images\\next.png").getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT));
        next = new MainButton("NEXT");
        next.btn.addActionListener(this);

        ImageIcon resetIcon = new ImageIcon(Objects.requireNonNull(getClass().getResource("/Images/reset.png")));

        reset = new MainButton("RESET");
        reset.btn.addActionListener(this);

        save = new MainButton("SAVE",new Color(100, 201, 207),Color.darkGray);
        save.btn.addActionListener(this);

        view = new MainButton("VIEW",new Color(100, 201, 207),Color.darkGray);
        view.btn.addActionListener(this);

        label.setText(Integer.toString(this.counter));
        //label.setIcon(new ImageIcon(new ImageIcon("F:\\Project\\GameOfLife\\src\\Images\\start.png").getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT)));

        slider = new JSlider(0,15,7);
        speeder = new JSlider(0,25,13);



        //..........
//        slider.setPaintTrack(true);
//        slider.setPaintTicks(true);
//        slider.setPaintLabels(true);
//
//        // set spacing
//        slider.setMajorTickSpacing(5);
        //slider.setMinorTickSpacing(1);
//..........................................
//        speeder.setPaintTrack(true);
//        speeder.setPaintTicks(true);
//        speeder.setPaintLabels(true);
//
//        // set spacing
//        speeder.setMajorTickSpacing(8);
        //slider.setMinorTickSpacing(1);



        //.............



        speeder.setPreferredSize(new Dimension(130,50));
        speeder.setBorder(new RoundBtn(12));
        //speeder.setBackground(Color.white);

//        speeder.setPaintTrack(true);
//        speeder.setMajorTickSpacing(10);
//        speeder.addChangeListener(this);

        slider.setPreferredSize(new Dimension(130,50));
        slider.setBorder(new RoundBtn(12));
//        slider.setBackground(Color.white);
//
//        slider.setPaintTrack(true);
//        slider.setMajorTickSpacing(3);
//        slider.addChangeListener(this);

        slider.addChangeListener(this);
        speeder.addChangeListener(this);

        //this.rows = Integer.parseInt(r);
        this.rows = 60;
        //this.columns = Integer.parseInt(c);
        this.columns = 80;

        this.UI_FRAME();
    }

    public void UI_FRAME(){

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1150,650);
        //this.pack();
        //this.setExtendedState(JFrame.MAXIMIZED_BOTH);
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

        JPanel Srpanel1 = new JPanel();
        Srpanel1.setLayout(new BorderLayout());

        JPanel centerPanel = new JPanel();
        centerPanel.add(this.save.btn);
        centerPanel.add(this.view.btn);

        Jrpanel1.setPreferredSize(new Dimension(13,13));
        Jrpanel2.setPreferredSize(new Dimension(13,13));
        Jrpanel3.setPreferredSize(new Dimension(13,13));
        Jrpanel4.setPreferredSize(new Dimension(13,13));
        GridPanel.setPreferredSize(new Dimension(100,100));

        Srpanel1.add(Jrpanel1,BorderLayout.SOUTH);
        Srpanel1.add(centerPanel,BorderLayout.CENTER);

        Jrpanel1.setBackground(Color.darkGray);
        Jrpanel2.setBackground(Color.darkGray);
        Jrpanel3.setBackground(Color.darkGray);
        Jrpanel4.setBackground(Color.darkGray);

        panel1.setBackground(new Color(44, 39, 46));
        //panel2.setBackground(Color.pink);
        panel2.setLayout(new BorderLayout());
        panel3.setLayout(new BorderLayout());
        panel3.setBackground(Color.darkGray);

        panel1.setPreferredSize(new Dimension(100,100));
        //panel2.setPreferredSize(new Dimension(100,110));
        //panel3.setPreferredSize(new Dimension(100,100));

        this.add(panel1,BorderLayout.NORTH);
        this.add(panel2,BorderLayout.SOUTH);
        this.add(panel3,BorderLayout.CENTER);


        //ImageIcon ico = new ImageIcon("F:\\Project\\GameOfLife\\src\\Images\\top.png");

        JLabel l = new JLabel();
        //l.setPreferredSize(new Dimension(100,100));
        l.setIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource("/Images/top.PNG"))));

        panel1.add(l);

        panel3.add(Srpanel1,BorderLayout.NORTH);
        panel3.add(Jrpanel2,BorderLayout.WEST);
        panel3.add(Jrpanel3,BorderLayout.EAST);
        panel3.add(Jrpanel4,BorderLayout.SOUTH);
        panel3.add(GridPanel,BorderLayout.CENTER);

        this.UI_GRID();
        this.rows = 20;
        this.columns = 40;
        this.UpdateUI_Grid();

        speeder.addChangeListener(this);
        slider.addChangeListener(this);



        //panel2.add(speeder);
        //panel2.add(slider);

        //Icon icon = new ImageIcon("start.png");
//        Box b = Box.createHorizontalBox();
//        JLabel l = new JLabel();
//        //l.setIcon(new ImageIcon("F:\\Project\\GameOfLife\\src\\Images\\start.png"));
//        l.setIcon(new ImageIcon(new ImageIcon("F:\\Project\\GameOfLife\\src\\Images\\start.png").getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT)));
//        b.add(l);
//        b.add(start.btn);
//        panel2.add(b);
        JPanel btnPanel = new JPanel();
        JPanel slidePanel = new JPanel();
        JPanel midPanel = new JPanel();
        //JPanel countPanel = new JPanel();

        panel2.add(midPanel,BorderLayout.CENTER);
        //panel2.add(countPanel,BorderLayout.EAST);

        btnPanel.add(start.btn);
        btnPanel.add(stop.btn);
        btnPanel.add(reset.btn);
        btnPanel.add(next.btn);
        btnPanel.add(label);

        //countPanel.add(label);

        slidePanel.add(speeder);
        slidePanel.add(slider);

        midPanel.setLayout(new BorderLayout());
        midPanel.add(btnPanel,BorderLayout.NORTH);
        midPanel.add(slidePanel,BorderLayout.SOUTH);
        //midPanel.add(label,BorderLayout.EAST);

        //panel2.add(slidePanel,BorderLayout.SOUTH);

        check = new JButton("i");
        check.setFont(new Font("Consolas",Font.PLAIN,14));
        //check.setHorizontalAlignment(panel2.getWidth());
        panel2.add(check, BorderLayout.EAST);
        check.addActionListener(this);

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

    public void UpdateUI_Grid(){
        //this.rows = r;
        //this.columns = co;
        System.out.println("Row "+ this.rows+" Col "+this.columns);
        GridPanel.setLayout(new GridLayout(this.rows,this.columns));
        //GridPanel.repaint();

        GridPanel.removeAll();
        //Cell[][]ci;

        for (int i = 0; i < this.rows; i++) {
            for (int j = 0; j < this.columns; j++) {
                c[i][j] = new Cell(i,j);
                GridPanel.add(c[i][j].getBtn());
            }
        }

        GridPanel.revalidate();
        GridPanel.repaint();

        //System.out.println("Hello Dear");
    }

    public void PrintCellLocation(){
        for (int i = 0; i < this.rows; i++) {
            for (int j = 0; j < this.columns; j++) {
                System.out.println(c[i][j].x + " " + c[i][j].y + "  ");
            }
            System.out.println('\n');
        }
    }


    public void StartGame() {

    Thread GameLoop=new Thread(new Runnable() {
            @Override
            public void run() {

                for (int l=0;;l++)
        {
            if(stop.getBool()==true)
            {
                break;
            }
            for (int i = 0; i < 60; i++) {
                for (int j = 0; j < 80; j++) {

                    arr[i][j] = 0;

                }
            }

        //int arr[][] = new int[rows][columns];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (c[i][j].click == false) {
                    arr[i][j] = 0;
                } else {
                    arr[i][j] = 1;
                }
            }
        }
        int arr2[][]=new int [rows][columns];
        arr2=implementation.next(arr);

            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < columns; j++) {
                    if(arr2[i][j]==0)
                    {
                        c[i][j].click=false;
                        c[i][j].btn.setBackground(Color.white);
                    }
                    else
                    {
                        c[i][j].click=true;
                        c[i][j].btn.setBackground(Color.yellow);
                    }
                }
            }
            try {
                Thread.sleep(speeder.getValue()*200);
            }catch (Exception e) {

            // catching the exception
            System.out.println(e);
        }
            //  GridPanel.revalidate();
            GridPanel.repaint();

    }
                //counter++;
                //label.setText(Integer.toString(counter));
        //timer.start();

            }
        });
timer.start();
GameLoop.start();
//       for (int l=0;l<5;l++)
//        {
//            if(stop.getBool()==true)
//            {
//                break;
//            }
//
//        int arr[][] = new int[rows][columns];
//        for (int i = 0; i < rows; i++) {
//            for (int j = 0; j < columns; j++) {
//                if (c[i][j].click == false) {
//                    arr[i][j] = 0;
//                } else {
//                    arr[i][j] = 1;
//                }
//            }
//        }
//        int arr2[][]=new int [rows][columns];
//        arr2=implementation.next(arr);
//
//            for (int i = 0; i < rows; i++) {
//                for (int j = 0; j < columns; j++) {
//                    if(arr2[i][j]==0)
//                    {
//                        c[i][j].click=false;
//                        c[i][j].btn.setBackground(Color.white);
//                    }
//                    else
//                    {
//                        c[i][j].click=true;
//                        c[i][j].btn.setBackground(Color.yellow);
//                    }
//                }
//            }
//            try {
//                Thread.sleep(1000);
//            }catch (Exception e) {
//
//            // catching the exception
//            System.out.println(e);
//        }
//            //  GridPanel.revalidate();
//            GridPanel.repaint();
//
//    }
//        timer.start();

    }

    public void StopGame(){
        timer.stop();
    }

    public void NextGame(){
        Thread GameLoop=new Thread(new Runnable() {
            @Override
            public void run() {


                  //  int arr[][] = new int[60][80];
                for (int i = 0; i < 60; i++) {
                    for (int j = 0; j < 80; j++) {

                            arr[i][j] = 0;

                    }
                }
                    for (int i = 0; i < rows; i++) {
                        for (int j = 0; j < columns; j++) {
                            if (c[i][j].click == false) {
                                arr[i][j] = 0;
                            } else {
                                arr[i][j] = 1;
                            }
                        }
                    }
                    int arr2[][]=new int [60][80];
                    arr2=implementation.next(arr);

                    for (int i = 0; i < rows; i++) {
                        for (int j =0; j < columns; j++) {
                            if(arr2[i][j]==0)
                            {
                                c[i][j].click=false;
                                c[i][j].btn.setBackground(Color.white);
                            }
                            else if(arr2[i][j]==1)
                            {
                                c[i][j].click=true;
                                c[i][j].btn.setBackground(Color.yellow);
                            }
                        }
                    }
                    try {
                        Thread.sleep(speeder.getValue()*500);
                    }catch (Exception e) {

                        // catching the exception
                        System.out.println(e);
                    }
                    //  GridPanel.revalidate();
                    GridPanel.repaint();

                }



        });
        GameLoop.start();
        counter++;
        label.setText(Integer.toString(counter));
    }

    public void ResetGame(){
        timer.stop();
        this.counter = 0;
        label.setText(Integer.toString(counter));
        start.click = false;
        start.btn.setText("START");

        slider.setValue(7);
        speeder.setValue(13);

        this.rows = 20;
        this.columns = 40;
        this.UpdateUI_Grid();
        for (int i = 0; i < 60; i++) {
            for (int j = 0; j < 80; j++) {

                arr[i][j] = 0;

            }
        }
        for (int i = 0; i < this.rows; i++) {
            for (int j = 0; j < this.columns; j++) {
                //c[i][j] = new Cell(i,j);
                c[i][j].getBtn().setBackground(Color.white);
            }
        }

    }

    public void updateCells() {
       // int arr[][] = new int[60][80];
        for (int i = 0; i < rows; i++) {
            for (int j =0; j < columns; j++) {
                if(arr[i][j]==0)
                {
                    c[i][j].click=false;
                    c[i][j].btn.setBackground(Color.white);
                }
                else if(arr[i][j]==1)
                {
                    c[i][j].click=true;
                    c[i][j].btn.setBackground(Color.yellow);
                }
            }


        }
    }

    @Override
    public void stateChanged(ChangeEvent e) {
        if(e.getSource() == speeder){
            System.out.println(speeder.getValue());
            if(speeder.getValue() > speederCount){
                int check = 25 - speeder.getValue();
                this.delay = check * 10 ;
                this.timer.setDelay(this.delay);
                System.out.println("Greater");
            }
            else if(speeder.getValue() < speederCount){
                int check = 25 - speeder.getValue();
                this.delay = check * 20 ;
                this.timer.setDelay(this.delay);
                System.out.println("Lesser");
            }
            speederCount = speeder.getValue();
        }
        if(e.getSource()==slider) {
            if(slider.getValue() > sliderCount) {
                System.out.println("Slider Value " + slider.getValue() + " Rows : " + this.rows + " Columns : " + this.columns);
                this.rows -= 1;
                this.columns -= 2;
                if(this.rows < 20 && this.columns < 40 ) {
                    this.UpdateUI_Grid();
                    updateCells();
                }
                else{
                    this.rows = 20;
                    this.columns = 40;
                    this.UpdateUI_Grid();
                    updateCells();

                }
            }
            if(slider.getValue() < sliderCount) {
                System.out.println("Slider Value " + slider.getValue() + " Rows : " + this.rows + " Columns : " + this.columns);
                this.rows += 1;
                this.columns += 2;
                if(this.rows < 60 && this.columns < 80 ) {
                    this.UpdateUI_Grid();
                    updateCells();
                }
                else{
                    this.rows = 60;
                    this.columns = 80;
                    this.UpdateUI_Grid();
                    updateCells();
                }
            }
            sliderCount = slider.getValue();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==start.btn){
            start.click=true;
            stop.click=false;
            start.btn.setVisible(false);
            stop.btn.setVisible(true);
            this.StartGame();


        }
        if(e.getSource()==stop.btn){
            stop.click=true;
            start.click=false;
            start.btn.setVisible(true);
            stop.btn.setVisible(false);
            this.StopGame();
        }
        if(e.getSource()==next.btn){
            next.click=true;
            this.NextGame();
        }
        if(e.getSource()==reset.btn){
            reset.click=true;
            this.ResetGame();
        }
        if(e.getSource()==check){

            About a = new About();
        }
        if(e.getSource() == save.btn){
            Input i = new Input();
        }
        if(e.getSource()==view.btn){
            View v = new View();
        }
    }
}
