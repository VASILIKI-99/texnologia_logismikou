package commands;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import view.InfoData;

class TestDocumentToSpeech {

	@Test
	void test() {
		String text1="test pass successfully! For document to speech test2";
		InfoData iData = new InfoData();
		iData.setText(text1);
		//an einai doc h excel
		//iData.setP(100);
		//dinw onoma testsave
		DocumentToSpeech ds= new DocumentToSpeech(iData);
		ds.act();
		
	}

}
