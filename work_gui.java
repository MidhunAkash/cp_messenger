import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
class work_gui extends JFrame implements ActionListener
{
    JFrame fr=new JFrame("Action");
    JPanel pan=new JPanel();
    JLabel devcon=new JLabel("Device Status--");
    JTextField st=new JTextField(13);
    JLabel act=new JLabel("What will you do?");
    JButton dr=new JButton("Install Drivers");
    JButton call =new JButton("Call");
    JButton sms=new JButton("SMS");
    //JButton contact=new JButton("Contacts");
    JButton ich=new JButton("Handle Incoming Call");
    work_gui()
    {

        setDesign();

        fr.setSize(300, 300);
        fr.setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        pan.add(devcon);
        st.setEditable(false);
        st.setText("Checking...");
        pan.add(st);
        pan.add(act);
        pan.add(dr);
        pan.add(call);
        pan.add(sms);
        //pan.add(contact);
        pan.add(ich);
        dr.addActionListener(this);
        call.addActionListener(this);
        sms.addActionListener(this);
        //contact.addActionListener(this);
        ich.addActionListener(this);
        pan.setBackground(Color.pink);
        fr.add(pan);
        fr.setVisible(true);
        devch();
    }

    public final void setDesign() {
        try {
            UIManager.setLookAndFeel(
                "com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch(Exception e) {  
        }
    }

    void devch()
    {
        st.setText("Checking...");
        try{
            if (new DeviceChecker().work())
            {
                st.setText("Connected");
            }
            else
            {
                st.setText("Not Connected");
            }
        }catch(Exception excep){}
    }

    public void actionPerformed(ActionEvent evt)
    {
        try
        {

            if (evt.getSource()==dr)
            {
                new drivers_gui();
            }
            if (evt.getSource()==call)
            {
                new PhoneCheck().work();
            }
            if (evt.getSource()==sms)
            {
                new SmsCheck().work();
            }
            if (evt.getSource()==ich)
            {
                new ichCheck().work();
            }

        }catch(Exception excep){}
    }
}