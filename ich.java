import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
class ich extends JFrame implements ActionListener
{
    JFrame fr=new JFrame("Incoming Call");

    JPanel p=new JPanel();
    JButton rcv=new JButton("Accept");
    JButton rej=new JButton("Reject");
    JButton ec=new JButton("End Call");
    JButton dr=new JButton("Bike Mode");
    JLabel lne=new JLabel("                            ");
    JLabel rcvl=new JLabel("Click to accept incoming call");
    JLabel rejl=new JLabel("Click to  reject call");
    JLabel drl=new JLabel("Click to reject call as you are driving");
    JLabel ecl=new JLabel("Click to end On-Going call");
    ich()
    { 

        super("Phone");
        setDesign();
        fr.setSize(350, 200);
        fr.setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        fr.setVisible(true);
        rcv.setBackground(Color.green);
        rcv.setForeground(Color.blue);
        rej.setBackground(Color.red);
        rej.setForeground(Color.cyan);
        ec.setBackground(Color.pink);
        ec.setForeground(Color.darkGray);
        p.add(rcvl);
        p.add(rcv);
        p.add(lne);
        p.add(rejl);
        p.add(rej);
        p.add(drl);
        p.add(dr);
        p.add(lne);
        p.add(ecl);
        p.add(ec);
        p.setBackground(Color.pink);
        fr.add(p);
        rcv.addActionListener(this);
        rej.addActionListener(this);
        ec.addActionListener(this);
        dr.addActionListener(this);  
    }

    public void actionPerformed(ActionEvent e)
    {
        Process proc;
        if (e.getSource()==rcv)
        {
            try
            {
                proc=Runtime.getRuntime().exec("adb shell input keyevent 5");
                proc.waitFor();

            }
            catch (Exception ex){}
        }
        if (e.getSource()==rej)
        {
            try
            {
                proc=Runtime.getRuntime().exec("adb shell input keyevent 6");
                proc.waitFor();
                proc=Runtime.getRuntime().exec("adb shell input keyevent 3");
                proc.waitFor();

            }
            catch (Exception ex){}
        }
        if (e.getSource()==ec)
        {
            try
            {
                proc=Runtime.getRuntime().exec("adb shell input keyevent 6");
                proc.waitFor();
                proc=Runtime.getRuntime().exec("adb shell input keyevent 3");
                proc.waitFor();

            }
            catch (Exception ex){}
        }
        if (e.getSource()==dr)
        {
            try
            {
                new Drive().work();
            }
            catch (Exception ex){}
        }

    }

    public final void setDesign() {
        try {
            UIManager.setLookAndFeel(
                "com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch(Exception e) {  
        }
    }

    void none()
    {

    } 
}
