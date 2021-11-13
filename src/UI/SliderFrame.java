package UI;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;

public class SliderFrame implements ChangeListener {

    JSlider slider,speeder;
    int rows,columns,SpeederVal,SliderVal;

    SliderFrame(){

        this.rows = 0;
        this.columns = 0;
        this.SpeederVal = 0;
        this.SliderVal = 0;

        slider = new JSlider(0,50,25);
        speeder = new JSlider(0,50,25);

        speeder.setPreferredSize(new Dimension(100,50));
        speeder.setBackground(Color.yellow);
        //slider.setPaintTicks(true);
        //slider.setMinorTickSpacing(2);

        speeder.setPaintTrack(true);
        speeder.setMajorTickSpacing(10);
        speeder.addChangeListener(this);
        //panel2.add(speeder);

        slider.setPreferredSize(new Dimension(100,50));
        slider.setBackground(Color.pink);
        //slider.setPaintTicks(true);
        //slider.setMinorTickSpacing(2);

        slider.setPaintTrack(true);
        slider.setMajorTickSpacing(10);
        slider.addChangeListener(this);

        slider.addChangeListener(this);
        speeder.addChangeListener(this);

    }

    void setRows(int r){
        this.rows = r;
    }

    void setColumns(int c){
        this.columns = c;
    }

    int getRows(){
        return this.rows;
    }

    int getColumns(){
        return this.columns;
    }

    int getSpeederVal(){
        return this.SpeederVal;
    }

    int getSliderVal(){
        return this.SliderVal;
    }

    @Override
    public void stateChanged(ChangeEvent e) {
//        if(e.getSource()==slider){
//            this.SliderVal = slider.getValue();
//            System.out.println(slider.getValue());
//            if(slider.getValue() > 50){
//                int check = slider.getValue() - 2;
//                this.rows -= check;
//                this.columns -= check;
//                System.out.println("Rows "+ this.rows);
//                System.out.println("Columns "+this.columns);
//            }
//            //his.UI_GRID();
//        }
//        if(e.getSource()==speeder){
//            this.SpeederVal = speeder.getValue();
//            System.out.println(speeder.getValue());
//        }
    }
}
