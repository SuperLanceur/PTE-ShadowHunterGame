package ihm;

import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class EffetSonore {
	
	 static boolean soundOK;
	
	public static void playSoundEffect(String path) {
		
		if (soundOK == true) {
			
			try {

				File soundPath = new File(path);

				if (soundPath.exists()) {

					AudioInputStream audioInput = AudioSystem.getAudioInputStream(soundPath);
					Clip clipSound = AudioSystem.getClip();
					clipSound.open(audioInput);
					clipSound.start();

				} else {
					System.out.println("le fichier audio n'est pas trouvé");
				}

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}


	}

	public static boolean isSoundOK() {
		return soundOK;
	}

	public static void setSoundOK(boolean soundOK) {
		EffetSonore.soundOK = soundOK;
	}




	
	

}
