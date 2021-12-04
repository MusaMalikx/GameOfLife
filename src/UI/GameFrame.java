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
import BL.GameLogic.file;
import File.File_Handling;
import java.lang.Exception;

public class GameFrame extends JFrame implements ChangeListener, ActionListener
{
    private MainButton start,reset,next,stop,save,view, load ,delete;
    private int counter,delay,sliderCount,speederCount;
    private JLabel label;
    //private JFrame F,I,L,D;
    private GUI_implementation implementation;
    private file file_controller;
    private int [][]arr;
    private int rows;
    private int columns;
    private JSlider slider,speeder;
    private JPanel GridPanel;
    private Cell[][] c;
    private JButton check,submit,li,di;
    private JLabel StateNames[];

    Timer timer = new Timer(500, new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            counter++;
            label.setText(Integer.toString(counter));
        }
    });

    public GameFrame(GUI_implementation obj,file obj2){
        arr=new int[60][80];
        implementation= new GUI_implementation();
        implementation= obj;
//        I = new JFrame();
//        L = new JFrame();
//        D = new JFrame();
        sliderCount = 0;
        speederCount = 0;
        counter = 0;
        delay = 0;
        file_controller=new File_Handling();
        file_controller=obj2;
         StateNames=new JLabel[10];
        for(int i=0;i<10;i++)
        {
            StateNames[i]=new JLabel();
        }
        label = new JLabel("");
        label.setFont(new Font("Consolas",Font.PLAIN,14));

        //F=new JFrame();

        ImageIcon playIcon = new ImageIcon(Objects.requireNonNull(getClass().getResource("/Images/start.png")));//.getImage().getScaledInstance(20, 20, java.awt.Image.SCALE_SMOOTH));
        start = new MainButton("START",new Color(23, 215, 160),Color.darkGray);
        start.getBtn().addActionListener(this);

        ImageIcon stopIcon = new ImageIcon(getClass().getResource("/Images/stop.png"));//new ImageIcon("F:\\Project\\GameOfLife\\src\\Images\\next.png").getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT));
        stop = new MainButton("STOP",new Color(255, 81, 81),Color.darkGray);
        stop.getBtn().setVisible(false);
        stop.getBtn().addActionListener(this);

        ImageIcon nextIcon = new ImageIcon(Objects.requireNonNull(getClass().getResource("/Images/next.png")));//new ImageIcon("F:\\Project\\GameOfLife\\src\\Images\\next.png").getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT));
        next = new MainButton("NEXT");
        next.getBtn().addActionListener(this);

        ImageIcon resetIcon = new ImageIcon(Objects.requireNonNull(getClass().getResource("/Images/reset.png")));
        reset = new MainButton("RESET");
        reset.getBtn().addActionListener(this);

        save = new MainButton("SAVE",new Color(100, 201, 207),Color.darkGray);
        save.getBtn().addActionListener(this);

        view = new MainButton("VIEW",new Color(100, 201, 207),Color.darkGray);
        view.getBtn().addActionListener(this);
        load = new MainButton("LOAD",new Color(255, 165, 165),Color.darkGray);

        delete = new MainButton("DELETE",new Color(236, 70, 70),Color.white);

        label.setText(Integer.toString(this.counter));

        slider = new JSlider(0,15,7);
        speeder = new JSlider(0,25,13);



        speeder.setPreferredSize(new Dimension(130,50));
        speeder.setBorder(new RoundBtn(12));

        slider.setPreferredSize(new Dimension(130,50));
        slider.setBorder(new RoundBtn(12));

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
        centerPanel.add(this.save.getBtn());
        centerPanel.add(this.view.getBtn());

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

        JLabel l1 = new JLabel();
        JLabel l2 = new JLabel();
        //l.setIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource("/Images/top.PNG"))));
        l1.setText("John Conway's");
        l1.setFont(new Font("Consolas",Font.ITALIC,25));
        l1.setForeground(Color.white);
        panel1.add(l1);
        l2.setText("Game of Life");
        l2.setFont(new Font("Century",Font.PLAIN,65));
        l2.setForeground(Color.white);
        panel1.add(l2);

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

        JPanel btnPanel = new JPanel();
        JPanel slidePanel = new JPanel();
        JPanel midPanel = new JPanel();

        panel2.add(midPanel,BorderLayout.CENTER);

        btnPanel.add(start.getBtn());
        btnPanel.add(stop.getBtn());
        btnPanel.add(reset.getBtn());
        btnPanel.add(next.getBtn());
        btnPanel.add(label);

        //countPanel.add(label);

        JLabel la1 = new JLabel();
        JLabel la2 = new JLabel();

        JLabel la3 = new JLabel();

        la1.setText("Speed");
        la1.setFont(new Font("Consolas",Font.PLAIN,15));
        la2.setText("Zoom");
        la2.setFont(new Font("Consolas",Font.PLAIN,15));
        la3.setText("  ");
//
//        la1.add(speeder);
//        la2.add(slider);
        slidePanel.add(la1);
        slidePanel.add(speeder);
        slidePanel.add(la3);
        slidePanel.add(la2);
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

    }

    public void PrintCellLocation(){
        for (int i = 0; i < this.rows; i++) {
            for (int j = 0; j < this.columns; j++) {
                System.out.println(c[i][j].getX() + " " + c[i][j].getY() + "  ");
            }
            System.out.println('\n');
        }
    }

    public void StartGame() {

    Thread GameLoop=new Thread(new Runnable() {
            @Override
            public void run() {
                for (int l=0;;l++) {
                    if(stop.getBool()==true)
                    {
                        break;
                    }
                    for (int i = 0; i < 60; i++) {
                        for (int j = 0; j < 80; j++) {

                            arr[i][j] = 0;

                        }
                    }

                    for (int i = 0; i < rows; i++) {
                        for (int j = 0; j < columns; j++) {
                            if (c[i][j].getClick() == false) {
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
                                c[i][j].setClick(false);
                                c[i][j].getBtn().setBackground(Color.white);
                            }
                            else
                            {
                                c[i][j].setClick(true);
                                c[i][j].getBtn().setBackground(Color.yellow);
                            }
                        }
                    }
                    try {
                        Thread.sleep(delay);
                    }catch (Exception e) {

                    // catching the exception
                    System.out.println(e);
                    }
            //  GridPanel.revalidate();
                        GridPanel.repaint();
                    }
                }
            }
        );
        timer.start();
        GameLoop.start();
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
                            if (c[i][j].getClick() == false) {
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
                                c[i][j].setClick(false);
                                c[i][j].getBtn().setBackground(Color.white);
                            }
                            else if(arr2[i][j]==1)
                            {
                                c[i][j].setClick(true);
                                c[i][j].getBtn().setBackground(Color.yellow);
                            }
                        }
                    }
                    try {
                        Thread.sleep(delay);
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
        start.setBool(false);
        stop.setBool(true);
        start.getBtn().setVisible(true);
        stop.getBtn().setVisible(false);

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
                    c[i][j].setClick(false);
                    c[i][j].getBtn().setBackground(Color.white);
                }
                else if(arr[i][j]==1)
                {
                    c[i][j].setClick(true);
                    c[i][j].getBtn().setBackground(Color.yellow);
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
        if(e.getSource()==start.getBtn()){
            start.setBool(true);
            stop.setBool(false);
            start.getBtn().setVisible(false);
            stop.getBtn().setVisible(true);
            this.StartGame();


        }
        if(e.getSource()==stop.getBtn()){
            stop.setBool(true);
            start.setBool(false);
            start.getBtn().setVisible(true);
            stop.getBtn().setVisible(false);
            this.StopGame();
        }
        if(e.getSource()==next.getBtn()){
            next.setBool(true);
            this.NextGame();
        }
        if(e.getSource()==reset.getBtn()){
            reset.setBool(true);
            this.ResetGame();
        }
        if(e.getSource()==check){

            About a = new About();
        }
        if(e.getSource() == save.getBtn()){
            JFrame I = new JFrame();
            I.setLayout(new FlowLayout());
            I.setTitle("Save State");
            I.setSize(new Dimension(500,90));
            this.submit = new JButton("SAVE");
            this.submit.setBackground(new Color(17, 101, 48));
            this.submit.setForeground(Color.white);
            //this.submit.setBorder(new RoundBtn(2));
            //this.submit.setSize(30,30);
            this.submit.setFont(new Font("Consolas",Font.PLAIN,18));
            //this.submit.setPreferredSize(new Dimension(100,40));
            JTextField input = new JTextField();
            input.setPreferredSize(new Dimension(250,40));
            input.setFont(new Font("Consolas",Font.PLAIN,14));
            input.setBackground(Color.black);
            input.setCaretColor(Color.white);
            input.setForeground(Color.red);
            I.add(input);
            input.addActionListener(this);
            I.add(this.submit);
            this.submit.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if(e.getSource() == submit){
                        System.out.println("Submit");
                        System.out.println(input.getText());
                        //save
                        try {
                            for (int i = 0; i < rows; i++) {
                                for (int j = 0; j < columns; j++) {
                                    if (c[i][j].getClick() == false) {
                                        arr[i][j] = 0;
                                    } else {
                                        arr[i][j] = 1;
                                    }
                                }
                            }

                            file_controller.saveState(arr, input.getText());
                        }
                        catch(Exception ex)
                        {
                            System.out.println(ex);
                        }

                        I.dispose();

                    }
                }
            });
            I.setVisible(true);
     }
        if(e.getSource()==view.getBtn()){
            JFrame F = new JFrame();

            F.setSize(450,500);
            F.setTitle("View State");

            JPanel panel1 = new JPanel();
            panel1.setBackground(new Color(247,247,247));
            JPanel panel2 = new JPanel();
            panel2.setBackground(new Color(254, 251, 243));

            JPanel panel3 = new JPanel();
            panel3.setBackground(Color.WHITE);
            panel3.setPreferredSize(new Dimension(13,13));

            F.add(panel1,BorderLayout.NORTH);
            F.add(panel2,BorderLayout.CENTER);
            F.add(panel3,BorderLayout.WEST);

//            panel1.setPreferredSize(new Dimension(100,100));
//            panel2.setPreferredSize(new Dimension(100,100));

            panel2.setLayout(new BoxLayout(panel2,BoxLayout.Y_AXIS));

            panel1.setLayout(new FlowLayout());
            panel1.add(this.load.getBtn());

            load.getBtn().addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    System.out.println("Load");

                    //--------------------------------
                    JFrame L=new JFrame();
                    L.setLayout(new FlowLayout());
                    L.setTitle("Load State");
                    L.setSize(new Dimension(500,90));
                    li = new JButton("LOAD");
                    li.setBackground(new Color(143, 193, 212));
                    li.setPreferredSize(new Dimension(100,40));
                    li.setFont(new Font("Consolas",Font.PLAIN,18));
                    JTextField lo = new JTextField();
                    lo.setPreferredSize(new Dimension(250,40));
                    lo.setFont(new Font("Consolas",Font.PLAIN,14));
                    lo.setBackground(Color.black);
                    lo.setCaretColor(Color.white);
                    lo.setForeground(Color.red);
                    // this.in.setText("Enter the State Name");
                    L.add(lo);
                    //Load TextField
                    lo.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            System.out.println("Load TextField");
                        }
                    });
                    L.add(li);
                    //Load Button
                    li.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {

                            System.out.println("Load Button");
                            System.out.println(lo.getText());
                            //load
                            try {
                                arr = file_controller.loadState(lo.getText());
                                for (int i = 0; i < rows; i++) {
                                    for (int j =0; j < columns; j++) {
                                        if(arr[i][j]==0)
                                        {
                                            c[i][j].setClick(false);
                                            c[i][j].getBtn().setBackground(Color.white);
                                        }
                                        else if(arr[i][j]==1)
                                        {
                                            c[i][j].setClick(true);
                                            c[i][j].getBtn().setBackground(Color.yellow);
                                        }
                                    }


                                }
                            }
                            catch (Exception ex)
                            {
                                System.out.println(ex);
                            }

                            L.dispose();
                            F.dispose();
                        }
                    });
                    L.setVisible(true);
                    //--------------------------------
                }
            });

            panel1.add(this.delete.getBtn());

            delete.getBtn().addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    System.out.println("Delete");

                    //--------------------------------
                    JFrame D = new JFrame();
                    D.setLayout(new FlowLayout());
                    D.setTitle("Delete State");
                    D.setSize(new Dimension(500,90));
                    di = new JButton("DELETE");
                    di.setBackground(new Color(255, 107, 107));
                    di.setPreferredSize(new Dimension(100,40));
                    di.setFont(new Font("Consolas",Font.PLAIN,18));
                    JTextField de = new JTextField();
                    de.setPreferredSize(new Dimension(250,40));
                    de.setFont(new Font("Consolas",Font.PLAIN,14));
                    de.setBackground(Color.black);
                    de.setCaretColor(Color.white);
                    de.setForeground(Color.red);
                    // this.in.setText("Enter the State Name");
                    D.add(de);
                    //Load TextField
                    de.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            System.out.println("Delete TextField");
                        }
                    });
                    D.add(di);
                    //Load Button
                    di.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            System.out.println("Delete Button");
                            System.out.println(de.getText());
                            //delete
                            try {
                                 file_controller.deleteState(de.getText());
                            }
                            catch (Exception ex)
                            {
                                System.out.println(ex);
                                System.out.println("Delete fail");
                            }
                            F.dispose();
                            D.dispose();
                        }
                    });
                    D.setVisible(true);
                    //--------------------------------
                }
            });


            String arr2[]=new String[10];

            try {


                arr2 = file_controller.viewState();
                for (int i = 0; i < 10; i++) {
                    if (arr2[i] == null) {
                        break;
                    }
                    System.out.println(arr2[i] + "\n");
                    StateNames[i]=new JLabel();
                    StateNames[i].setText(arr2[i]);
                    StateNames[i].setFont(new Font("Consolas",Font.PLAIN,20));
                    panel2.add(StateNames[i]);
                }
            }
            catch (Exception ex)
            {
                System.out.println(ex);
            }

            F.setVisible(true);
        }

    }
}
