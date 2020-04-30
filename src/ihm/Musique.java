package ihm;

import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

import ihm.controller.ParametreController;

public class Musique {

	public static Clip clip;
	public static long clipTimePosition = 0;

	public static void playMusique(String path) {

		try {

			File musicPath = new File(path);
			
			if (musicPath.exists()) {

				AudioInputStream audioInput = AudioSystem.getAudioInputStream(musicPath);
				clip = AudioSystem.getClip();
				clip.open(audioInput);
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

}
