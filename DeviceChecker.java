import java.io.*;
import java.util.*;
public class DeviceChecker
{
    public boolean work()throws Exception
    { 
        Process ec=Runtime.getRuntime().exec("cmd /c adb devices  > dev.txt");
        ec.waitFor();
        FileReader file=new FileReader("dev.txt");
        BufferedReader br=new BufferedReader(file);
        String text="";
        String dev="";
        int i=0;
        while((text=br.readLine())!=null)
        {
            i++;
            dev=dev+text+"\r";
        }
        br.close();
        int devc=0;
        for (i=0;i<dev.length();i++)
        {
            try{
                String k=(dev.substring(i,(i+6)));
                String l=(dev.substring(i,(i+7)));
                if (k.equalsIgnoreCase("device")&&(!(l.equalsIgnoreCase("devices"))))

                {
                    devc=devc+1;

                }
            } catch(Exception e)
            {}

        }

        if (devc==1)
        {

            return true;}

        else 
            new erro();
        return false;    
    }
}