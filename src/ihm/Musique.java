package ihm;

import java.io.BufferedInputStream;
import java.io.InputStream;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;

public class Musique {

	public static Clip clip;
	public static long clipTimePosition = 0;
	
	public static boolean musiqueEnCours = false;
	static FloatControl volume ;

	public static void playMusique(InputStream path) {

		try {

			InputStream musicPath = path;

			if (musicPath != null) {
				InputStream bufferedIn = new BufferedInputStream(musicPath);

				AudioInputStream audioInput = AudioSystem.getAudioInputStream(bufferedIn);
				clip = AudioSystem.getClip();
				clip.open(audioInput);

				volume =  (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
				volume.setValue(-20.0f); // Reduit le volume de 20 decibels.

				clip.start();
				clip.loop(Clip.LOOP_CONTINUOUSLY);

			} else {
				System.out.println("le fichier audio n'est pas trouvé");
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public static void pauseMusique(Clip clip) {
		clipTimePosition = clip.getMicrosecondPosition();
		clip.stop();
	}

	public static void resumeMusique(Clip clip) {
		clip.setMicrosecondPosition(clipTimePosition);
		clip.start();
	}
	
	public static void volumeUp(Float valeur) {
		volume.setValue(volume.getValue() +valeur);
	}
	
	public static void volumeDown(Float valeur) {
		volume.setValue(volume.getValue() -valeur);
	}

}
