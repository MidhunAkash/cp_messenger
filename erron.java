import javax.swing.*;
import java.awt.event.*;
public class erron extends JFrame implements ActionListener
{
    JFrame fr=new JFrame("ERROR");
    JPanel p=new JPanel();
    JLabel jl=new JLabel("Error: Enter a valid number");
    JLabel ln=new JLabel(new ImageIcon("Err.png"));
    JButton ok=new JButton("OK");
    erron()
    {
        p.add(ln);
        p.add(jl);
        
        p.add(ok);
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