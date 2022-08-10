//import javax.sound.sampled.*;
//import javafx.scene.media.*;
import java.io.*;
class Drive
{  
    void work()throws Exception
    {

        Process p=  Runtime.getRuntime().exec("adb shell input keyevent 5");
        p.waitFor();
        playAudio();
        Thread.sleep(11000);
        p.waitFor();
        p=  Runtime.getRuntime().exec("adb shell input keyevent 6");
        p.waitFor();
        p=  Runtime.getRuntime().exec("adb shell input keyevent 3");
        p.waitFor();
    }

    void playAudio()throws Exception
    {
 //       com.sun.javafx.application.PlatformImpl.startup(()->{});
        // String bip = "dvoice.mp3";
        // Media hit = new Media(new File(bip).toURI().toString());
        // MediaPlayer mediaPlayer = new MediaPlayer(hit);
        // mediaPlayer.play();
    }
}