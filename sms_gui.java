import java.awt.*; 
import java.awt.event.*;
import javax.swing.*;

public class sms_gui extends JPanel implements ActionListener {
    protected JTextField textField;
    protected JTextArea textArea;
    JLabel l1=new JLabel("To- (Number)");
    JLabel l2=new JLabel("Message:-");
    Icon icon=new ImageIcon(getClass().getResource("phone.gif"));
    JButton snd=new JButton(icon);
    JButton clr=new JButton("Clear");
    public sms_gui() {
        super(new GridBagLayout());
	setDesign();
        Icon icon=new ImageIcon(getClass().getResource("phone.gif"));
        textField = new JTextField(10);
        snd.addActionListener(this);
        clr.addActionListener(this);
        textArea = new JTextArea(20, 20);
        textArea.setEditable(true);
        JScrollPane scrollPane = new JScrollPane(textArea);

        GridBagConstraints c = new GridBagConstraints();
        c.gridwidth = GridBagConstraints.REMAINDER;

        c.fill = GridBagConstraints.HORIZONTAL;
        add(l1);
        add(textField, c);

        c.fill = GridBagConstraints.BOTH;
        c.weightx = 1.0;
        c.weighty = 1.0;
        add(l2);
        add(scrollPane, c);
        setDesign();
        setBackground(Color.cyan);
        add(snd);
        add(clr);
    }

    public void actionPerformed(ActionEvent evt) {

        Process proc;
        if (evt.getSource()==snd)
        {
            try{
                if(new DeviceChecker().work())
                {
                    String num = textField.getText();
                    String m=textArea.getText();

                    String m2="";
                    if(!(new numCheck().check(num)))
                    {
                        textField.setText("Enter Valid Number");
                    }
                    else
                    {
                        for (int tmp=0;tmp<m.length();tmp++)
                        {
                            // System.out.println((int)m.charAt(tmp));
                            if (m.charAt(tmp)==((char)10))
                            {
                                m2=m2+" ";
                            }
                            else 
                            {
                                m2=m2+m.charAt(tmp);
                            }

                        }

                        textField.setText("Sending");
                        //System.out.println("\f Sending message to "+num);
                        //System.out.println("Enter Message");
                        String cmd = "adb shell am start -a android.intent.action.SENDTO -d sms:91" + num + " --es sms_body \" " +m2 + "\" --ez exit_on_sent true";

                        Process ec=Runtime.getRuntime().exec(cmd);
                        ec.waitFor();
                        Thread.sleep(50);
                        ec=Runtime.getRuntime().exec("adb shell input keyevent 22");
                        ec.waitFor();
                        Thread.sleep(50);
                        ec=Runtime.getRuntime().exec("adb shell input keyevent 22");
                        ec.waitFor();
                        Thread.sleep(50);
                        ec=Runtime.getRuntime().exec("adb shell input keyevent 66");
                        ec.waitFor();
                        textField.setText("Message sent");
                        
                    }
                }
                else
                {
                    textField.setText("Connect Device and try again");
                }
            }catch(Exception exce){}

        }
        if (evt.getSource()==clr)
        {
            textField.setText("");
            textArea.setText("");
        }

    }

    private static void createAndShowGUI() {

        JFrame frame = new JFrame("SMS");
        frame.setSize(100,100);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.add(new sms_gui());
        frame.pack();
        frame.setVisible(true);
    }

    public final static void setDesign() {
        try { 
            UIManager.setLookAndFeel(
                "com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch(Exception e) {  
        }
    }

    public void main() {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
                public void run() {
                    createAndShowGUI();
                }
            });
    }
}

