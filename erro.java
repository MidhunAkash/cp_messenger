import javax.swing.*;
import java.awt.event.*;
class erro extends JFrame implements ActionListener
{
    JFrame fr=new JFrame("ERROR");
    JPanel p=new JPanel();
    JLabel jl=new JLabel("Error: Device Not Connected");
    JLabel ln=new JLabel(new ImageIcon("Err.png"));
    JButton ok=new JButton("OK");
    erro()
    {
        p.add(ln);
        p.add(jl);
        
        p.add(ok);

        fr.setSize(300, 120);
        fr.setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        fr.setVisible(true);
        fr.add(p);
        ok.addActionListener(this);
    }

    public void actionPerformed(ActionEvent evt)
    {
        if (evt.getSource()==ok)
        {
            fr.setVisible(false);
        }
    }
}