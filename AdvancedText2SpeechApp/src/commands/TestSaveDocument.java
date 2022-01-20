package commands;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

import org.junit.jupiter.api.Test;
import org.apache.poi.xwpf.extractor.XWPFWordExtractor;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.junit.jupiter.api.Test;


import view.InfoData;

class TestSaveDocument {

	@Test
	void test() {
		String text="";
		
		String text1="test pass successfully!";		
		InfoData iData = new InfoData();
		iData.setText(text1);
		//an einai word h excel
		iData.setSaveflag(0);
		//dinw onoma testsave
		SaveDocument save = new SaveDocument(iData);
		save.act();
				
		try (XWPFDocument doc = new XWPFDocument(Files.newInputStream(Paths.get("./test.docx")))) {

			XWPFWordExtractor xwpfWordExtractor = new XWPFWordExtractor(doc);
			String docText = xwpfWordExtractor.getText();
	        text += docText;        
			
			
			
			} catch (IOException e) {
		// TODO Auto-generated catch block
				e.printStackTrace();
			}
		text = text.replace("\n", "");
		
		
		assertEquals(text1, text);
	
		System.out.println(text);
	}

	
}
