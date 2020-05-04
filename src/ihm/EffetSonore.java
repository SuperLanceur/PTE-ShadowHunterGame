package ihm;

import java.io.BufferedInputStream;
import java.io.InputStream;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class EffetSonore {
	
	 static boolean soundOK;
	 
	public InputStream fileSound1 =  getClass().getResourceAsStream("/ihm/ressources/musique/BEEP1.wav");
	public InputStream fileSound2 =  getClass().getResourceAsStream("/ihm/ressources/musique/BeepError.wav");
	
	public static void playSoundEffect(InputStream path) {
		
		if (soundOK == true) {
			
			try {

				InputStream soundPath = path;

				if (soundPath!=null) {

					InputStream bufferedIn = new BufferedInputStream(soundPath);
					
					AudioInputStream audioInput = AudioSystem.getAudioInputStream(bufferedIn);
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
