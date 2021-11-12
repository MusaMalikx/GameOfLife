package swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI extends JFrame implements ActionListener {

    JButton rowsbutton;
    JTextField rows;
    JButton colsbutton;
    JTextField cols;

    JButton playButton;

    public GUI(){
        this.TextFields();
    }

    public void TextFields(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new FlowLayout());

        rowsbutton = new JButton("Submit Rows");
        rowsbutton.addActionListener(this);

        rows = new JTextField();
        rows.setPreferredSize(new Dimension(250,40));
        rows.setFont(new Font("Consolas",Font.PLAIN,14));
        rows.setBackground(Color.black);
        rows.setCaretColor(Color.white);
        rows.setForeground(Color.red);
        rows.setText("Enter Number of Rows");

        colsbutton = new JButton("Submit Columns");
        colsbutton.addActionListener(this);

        cols = new JTextField();
        cols.setPreferredSize(new Dimension(250,40));
        cols.setFont(new Font("Consolas",Font.PLAIN,14));
        cols.setBackground(Color.black);
        cols.setCaretColor(Color.white);
        cols.setForeground(Color.red);
        cols.setText("Enter Number of Columns");

        this.add(rowsbutton);
        this.add(rows);

        this.add(colsbutton);
        this.add(cols);

        playButton = new JButton("Play Game");
        playButton.addActionListener(this);
        playButton.setEnabled(false);
        playButton.setBackground(Color.red);

        this.add(playButton);

        this.pack();
        this.setVisible(true);
    }

    public void ErrorPopUp(String s){
        JOptionPane.showMessageDialog(null,"You have Given Wrong Input in "+ s,"Error Dialog Box",JOptionPane.ERROR_MESSAGE);
    }

    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==rowsbutton){

            boolean row_check = false;

            try {
                int Value = Integer.parseInt(rows.getText());
            } catch (NumberFormatException check) {
                this.ErrorPopUp("Rows");
                row_check = true;
            }

            if(!row_check){
                rowsbutton.setEnabled(false);
                rows.setEditable(false);
                System.out.println(rows.getText());
            }

            if(!rowsbutton.isEnabled() && !colsbutton.isEnabled()){
                playButton.setEnabled(true);
                playButton.setBackground(Color.green);
            }
        }

        if(e.getSource()==colsbutton){

            boolean col_check = false;

            try {
                int Value = Integer.parseInt(rows.getText());
            } catch (NumberFormatException check) {
                this.ErrorPopUp("Columns");
                col_check = true;
            }

            if(!col_check){
                colsbutton.setEnabled(false);
                cols.setEditable(false);
                System.out.println(cols.getText());
            }

            if(!rowsbutton.isEnabled() && !colsbutton.isEnabled()){
                playButton.setEnabled(true);
                playButton.setBackground(Color.green);
            }
        }

        if(e.getSource()==playButton){
            if(!rowsbutton.isEnabled() && !colsbutton.isEnabled()){
                this.dispose();
            }

        }

    }
}
