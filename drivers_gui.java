import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class drivers_gui extends JFrame implements ActionListener
{
    JFrame fr=new JFrame("Install Drivers");
    JPanel pan=new JPanel();
    JLabel ins=new JLabel("Select your mobile manufacturer");
    JLabel chin=new JLabel("Chinese mobiles are not supported generally");
    JLabel bbox=new JLabel("Mobile must have BusyBox installed");
    JButton sams=new JButton ("Samsung");
    JButton adr=new JButton("Other Companies");
    drivers_gui()
    {
        super("Phone");
        setDesign();
        fr.setSize(270, 150);
        fr.setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        fr.setVisible(true);
        pan.add (ins);
        pan.add(chin);
        pan.add(bbox);
        pan.add(sams);
        pan.add(adr);
        fr.add(pan);
        sams.addActionListener(this);
        adr.addActionListener(this);
    }

    public final void setDesign() {
        try {
            UIManager.setLookAndFeel(
                "com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch(Exception e) {  
        }
    }

    public void actionPerformed(ActionEvent evt)
    {
        try{
            Process ec;
            if (evt.getSource()==sams)
            {
                ec=Runtime.getRuntime().exec("Sam.bat");
                ec.waitFor();
            }
            if (evt.getSource()==adr)
            {
                ec=Runtime.getRuntime().exec("Ad.bat");
                ec.waitFor();
            }

        }catch(Exception excep){}
    }
}