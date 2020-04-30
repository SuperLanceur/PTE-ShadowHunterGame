package ihm;

import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class EffetSonore {
	
	 boolean soundOK;
	
	public EffetSonore() {
		this.soundOK = false;
	}
	
	public void playSoundEffect(String path) {
		
		if (this.soundOK == true) {
			
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

	public boolean isSoundOK() {
		return soundOK;
	}

	public void setSoundOK(boolean soundOK) {
		this.soundOK = soundOK;
	}


	
	

}
