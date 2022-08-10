import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.FileReader;
public class Phone extends JFrame implements ActionListener {

    JPanel[] row = new JPanel[5];
    JButton[] button = new JButton[19];
    String[] buttonString = {"7", "8", "9", "",
            "4", "5", "6", "",
            "1", "2", "3", "",
            "", "", "Clear", "End Call",
            "", "Call", "0"};

    int[] dimW = {300,45,100,90};
    int[] dimH = {35, 40};
    Dimension displayDimension = new Dimension(dimW[0], dimH[0]);
    Dimension regularDimension = new Dimension(dimW[1], dimH[1]);
    Dimension rColumnDimension = new Dimension(dimW[2], dimH[1]);
    Dimension zeroButDimension = new Dimension(dimW[3], dimH[1]);

    JTextArea display = new JTextArea(1,20);
    Font font = new Font("Times new Roman", Font.BOLD, 14);

    Phone() {

        super("Phone");

        setDesign();

        setSize(380, 250);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        GridLayout grid = new GridLayout(5,5);
        setLayout(grid);

        FlowLayout f1 = new FlowLayout(FlowLayout.CENTER);
        FlowLayout f2 = new FlowLayout(FlowLayout.CENTER,1,1);
        for(int i = 0; i < 5; i++)
            row[i] = new JPanel();
        row[0].setLayout(f1);
        for(int i = 1; i < 5; i++)
            row[i].setLayout(f2);
        for(int i = 0; i < 19; i++) {
            
            button[i] = new JButton();
            if (i==12)
                continue;
            button[i].setText(buttonString[i]);
            button[i].setFont(font);
            button[i].addActionListener(this);
        }
        button[15].setBackground(Color.red);
        button[17].setBackground(Color.green);
        button[3].setBackground(Color.cyan);
        // button[3].setText("A");
        //button[7].setBackground(Color.red);
        // button[7].setText("d");
        //button[11].setBackground(Color.green);
        // button[11].setText("i");
        button[12].setBackground(Color.gray);
        button[12].setText("CP Project");
        button[13].setBackground(Color.pink);
        //button[16].setBackground(Color.yellow);
        // button[16].setText("& Biswa");
        display.setFont(font);
        display.setEditable(false);
        display.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        display.setPreferredSize(displayDimension);
        for(int i = 0; i < 14; i++)
            {if(i==12)
                continue;
            button[i].setPreferredSize(regularDimension);
        }
        for(int i = 14; i < 18; i++)
            button[i].setPreferredSize(rColumnDimension);
        button[18].setPreferredSize(zeroButDimension);
        row[0].add(display);
        add(row[0]);

        for(int i = 0; i < 4; i++)
            row[1].add(button[i]);
        row[1].add(button[14]);
        add(row[1]);

        for(int i = 4; i < 8; i++)
            row[2].add(button[i]);
        row[2].add(button[15]);
        add(row[2]);

        for(int i = 8; i < 11; i++)

            row[3].add(button[i]);
        add(row[3]);

        row[4].add(button[18]);
        for(int i = 12; i < 14; i++)
        {if (i==13)
            {continue;}
            row[4].add(button[i]);}
        row[4].add(button[17]);
        add(row[4]);
        setVisible(true);
        display.setEditable(true);
    }    

    public void clear() {
        //  System.out.println("\f");
        try {
            display.setText("");

        } catch(NullPointerException e) { 
        }
        display.setEditable(true);
    }
    public int binarySearch(String[] arr, String x)
    {
        int l = 0, r = arr.length - 1;
        while (l <= r) {
            int m = l + (r - l) / 2;
 
            int res = x.compareTo(arr[m]);
 
            // Check if x is present at mid
            if (res == 0)
                return m;
 
            // If x greater, ignore left half
            if (res > 0)
                l = m + 1;
 
            // If x is smaller, ignore right half
            else
                r = m - 1;
        }
 
        return -1;
    }
    public static int linearSearch(String[] arr, String key){    
        for(int i=0;i<arr.length;i++){    
            if(key.equals(arr[i])){    
                return i;
            }    
        }    
        return -1;    
    }  

    public void getResult() throws Exception{
        display.setEditable(false);
        String num = (display.getText());
        BufferedReader reader = new BufferedReader(new FileReader("contacts.txt"));
        StringBuilder stringBuilder = new StringBuilder();
        String line = null;
        String ls = System.getProperty("line.separator");
        while ((line = reader.readLine()) != null) {
            stringBuilder.append(line);
            stringBuilder.append(ls);
        }
stringBuilder.deleteCharAt(stringBuilder.length() - 1);
reader.close();

String content = stringBuilder.toString();
//System.out.println(content);
String contacts[] = content.split(",");
String names[] = new String[contacts.length];
String numbers[] = new String[contacts.length];
//System.out.println(contacts.length);
for(int i = 0; i < contacts.length; i++) {
    String temp[] = contacts[i].split("-");
    names[i] = temp[0].trim();
    numbers[i] = temp[1].trim();
    //System.out.println("Name: " + names[i] + " Number:" + numbers[i]);
}
for(int i = 0; i<names.length; i++)   
{  
for (int j = i+1; j<names.length; j++)   
{  
//compares each elements of the array to all the remaining elements  
if(names[i].compareTo(names[j])>0)   
{  
//swapping array elements  
String temp = names[i];
String temp2 = numbers[i];
names[i] = names[j];  
numbers[i] = numbers[j];
names[j] = temp;
numbers[j] = temp2;
}  
}  
}  
// for(int i = 0; i < contacts.length; i++) {
//     System.out.println("Name: " + names[i] + " Number:" + numbers[i]);
// }
String name = "unknown number";
if(!(new numCheck().check(num))){
    int nameIndex = binarySearch(names,num.trim());
    if(nameIndex != -1){
        name = names[nameIndex];
        num = numbers[nameIndex];
    }
} else{
    int numberIndex = linearSearch(numbers,num.trim());
    if(numberIndex != -1){
        name = names[numberIndex];
    }
}
//System.out.println(num.trim()+""+(binarySearch(names,num.trim()))+""+binarySearch(numbers,num.trim()));
// if(binarySearch(names,num.trim()) !=-1 || binarySearch(numbers,num.trim()) !=-1){
//     int nameIndex = binarySearch(names,num.trim());
//     int numberIndex = binarySearch(numbers,num.trim());
//     if(nameIndex != -1){
//         name = names[nameIndex];
//         num = numbers[nameIndex];
//     } else {
//         name = names[numberIndex];
//     }
//     System.out.println("Calling "+name+"\n"+num);
// }
        if ("unknown number".equals(name)?!(new numCheck().check(num)):false)
        {
            display.setText("Enter a valid number");
        }
        else
        {
            try{
                if(new DeviceChecker().work())
                {
                    String cmd="adb shell am start -a android.intent.action.CALL tel:"+num;
                    //  System.out.println("\f");
                    // System.out.println("Calling "+num+"...");
                    Process p=Runtime.getRuntime().exec(cmd);
                    display.setText("Calling "+name+"\n"+num);
                    p.waitFor();
                }
                else
                {
                    display.setText("Device not connected");
                }
            }catch(Exception ex){}

        }
    }

    public void endCall() throws Exception
    {
        Process ec=Runtime.getRuntime().exec("adb shell input keyevent 6");
        ec.waitFor();
        ec=Runtime.getRuntime().exec("adb shell input keyevent 3");
        ec.waitFor();
        display.setText("Call Ended");
        display.setEditable(false);
        // System.out.println("\f");
        // System.out.println("Call Ended");
    }

    public final static void setDesign() {
        try {
            UIManager.setLookAndFeel(
                "com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch(Exception e) {  
        }
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == button[0])
            display.append("7");
        if(ae.getSource() == button[1])
            display.append("8");
        if(ae.getSource() == button[2])
            display.append("9");
        if(ae.getSource() == button[4])
            display.append("4");
        if(ae.getSource() == button[5])
            display.append("5");
        if(ae.getSource() == button[6])
            display.append("6");
        if(ae.getSource() == button[8])
            display.append("1");
        if(ae.getSource() == button[9])
            display.append("2");
        if(ae.getSource() == button[10])
            display.append("3");
        if(ae.getSource() == button[15])
        { try
            {endCall();}
            catch (Exception e)
            {}}    

        if(ae.getSource() == button[17])
        { try
            {getResult();}
            catch (Exception e)
            {}}
        if(ae.getSource() == button[18])
            display.append("0");
        if(ae.getSource() == button[14])
            clear();

    }

    void none()
    {
        //System.out.println();
    }

}
