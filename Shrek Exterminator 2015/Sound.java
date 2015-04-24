import java.applet.Applet;
import java.applet.AudioClip;

public class Sound 
{
	public static final AudioClip GAMEOVER = Applet.newAudioClip(Sound.class.getResource("scream.wav"));
	public static final AudioClip BACKGROUNDNOISE = Applet.newAudioClip(Sound.class.getResource("background.wav"));
}