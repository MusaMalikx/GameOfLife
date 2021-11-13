package UI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonFrame implements ActionListener {

    MainButton start,reset,next;
    int counter;
    JLabel label;

    Timer timer = new Timer(500, new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            counter++;
            label.setText(Integer.toString(counter));
        }
    });

    public ButtonFrame(){

        counter = 0;

        label = new JLabel("");

        start = new MainButton("START");
        start.btn.addActionListener(this);

//        stop = new MainButton("STOP");
//        stop.btn.setEnabled(false);
//        stop.btn.addActionListener(this);

        next = new MainButton("NEXT");
        next.btn.addActionListener(this);

        reset = new MainButton("RESET");
        reset.btn.addActionListener(this);

        label.setText(Integer.toString(this.counter));

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
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==start.btn){
            if(!start.click){
                start.click = true;
                //start.btn.setEnabled(false);
                start.btn.setText("STOP");
                this.StartGame();
            }
            else{
                start.click = false;
                start.btn.setText("START");
                this.StopGame();
            }
//            stop.btn.setEnabled(true);
//            start.btn.setEnabled(false);
//            this.StartGame();
        }
        if(e.getSource()==next.btn){
            this.NextGame();
        }
        if(e.getSource()==reset.btn){
            this.ResetGame();
        }
    }
}
