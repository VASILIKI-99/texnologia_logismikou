package commands;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import view.InfoData;

class TestTuneAudio {

	@Test
	void test1() {
		InfoData iData = new InfoData();
		iData.setPitch(30);
		//iData.setVolume(77);
		//iData.setSpeechR(77);
		//iData.setFlag(0);
	
	
		TuneAudio tn = new TuneAudio(iData);
		tn.act();
	
	
	
		assertEquals(30,iData.getPitch());
	
	
	}@Test
	void test2() {
		InfoData iData = new InfoData();
		//iData.setP(30);
		//iData.setVolume(77);
		iData.setSpeechR(77);
		//iData.setFlag(0);
	
	
		TuneAudio tn = new TuneAudio(iData);
		tn.act();
	
	
	
		assertEquals(77,iData.getSpeechR());
	
	
	}@Test
	void test3() {
		InfoData iData = new InfoData();
		//iData.setP(30);
		iData.setVolume(50);
		//iData.setSpeechR(77);
		iData.setFlag(1);
	
	
		TuneAudio tn = new TuneAudio(iData);
		tn.act();
	
	
	
		assertEquals(50,iData.getVolume());
	
	
	}
}
