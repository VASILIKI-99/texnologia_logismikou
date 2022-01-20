package commands;

import java.awt.event.ActionEvent;

import com.sun.speech.freetts.VoiceManager;

import view.InfoData;

public class DocumentToSpeech implements Commands {

	
	static String text;
	static float arraytch;
	public DocumentToSpeech(InfoData iData) {
		text=iData.getText();
		arraytch=iData.getPitch();
	}
	public DocumentToSpeech() {
		
	}
	
	
	public static void act() {
		TuneAudio tuneA= new TuneAudio();
		float array []= tuneA.act();
		
		//System.out.println(text);
		
		//System.out.println(array);
		
		com.sun.speech.freetts.Voice voice;//Creating object of Voice class
		System.setProperty("freetts.voices", "com.sun.speech.freetts.en.us.cmu_us_kal.KevinVoiceDirectory");
		voice = VoiceManager.getInstance().getVoice("kevin");//Getting voice
		if (voice != null) {
			voice.allocate();//Allocating Voice
		}
		try {
			voice.setRate(array[2]);//Setting the rate of the voice
			voice.setPitch(array[0]);//Setting the arraytch of the voice
			//Setting the volume of the voice
			voice.setVolume(array[1]);
			voice.speak(text);//Calling speak() method

		}
		catch(Exception e)
		{
		e.printStackTrace();
		}

		
	}
}
