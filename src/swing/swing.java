package swing;
import javax.swing.*;

public class swing {
    public void Example() {
        JFrame f=new JFrame();//creating instance of JFrame

        JButton b=new JButton("Hello World!");//creating instance of JButton
        b.setBounds(130,200,200, 40);//x axis, y axis, width, height

        f.add(b);//adding button in JFrame

        f.setSize(400,500);//400 width and 500 height
        f.setLayout(null);//using no layout managers
        f.setVisible(true);//making the frame visible
    }
}
