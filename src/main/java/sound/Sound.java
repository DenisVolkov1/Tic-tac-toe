package sound;


import java.applet.Applet;
import java.applet.AudioClip;
import java.io.File;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

public class Sound {
    URL winURL = this.getClass().getClassLoader().getResource("snd/win.wav");
    URL clickClickURL = this.getClass().getClassLoader().getResource("snd/click03.wav");
    URL clickURL = this.getClass().getClassLoader().getResource("snd/click06.wav");

    private AudioClip clickWin;
    private AudioClip clickClick;
    private AudioClip click;
    {
        clickWin = Applet.newAudioClip(winURL);
        clickClick = Applet.newAudioClip(clickClickURL);
        click = Applet.newAudioClip(clickURL);
    }

    public void startPlayWin(){
        clickWin.play();
    }
    public void startPlayClick() {
        clickClick.play();
    }
    public void click() {
        click.play();
    }




}
