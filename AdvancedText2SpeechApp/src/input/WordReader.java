package input;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import org.apache.poi.xwpf.extractor.XWPFWordExtractor;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import view.WindowText;



public class WordReader implements DocumentReader {

public static void read(String path,String code) {
	String text = null ;
	//String t=null;
	List<List<String>> dataFromExcel=null;
	
	try  {
	
	
		XWPFDocument doc = new XWPFDocument(Files.newInputStream(Paths.get(path)));
		XWPFWordExtractor xwpfWordExtractor = new XWPFWordExtractor(doc);
		String docText = xwpfWordExtractor.getText();
		
		
		System.out.println(docText);
		text=docText;

	} 
	catch (Exception e) {
		e.printStackTrace();
	}
	//System.out.println("mpika reader");
	//WindowText wt = new WindowText();
	
	
	//System.out.println(t);
	
	if(code =="atbash") {
		WindowText wt = new WindowText();
		String text1 = encode(text);
		wt.makeWinText(text1,dataFromExcel);
		
	}if(code =="rot13") {
		WindowText wt = new WindowText();
		String text1 = rot13(text);
		wt.makeWinText(text1,dataFromExcel);
	
	}
	if(code=="")
	{
		WindowText wt = new WindowText();
		wt.makeWinText(text,dataFromExcel);
	}
	}
	
	public static String encode(String input) {
	
	String ciphertext="";
	
	for(char ch:input.toCharArray()) {
		if(ch>='A' && ch<='Z'){//if it is true ,display upper case
			ciphertext += (char) ('A' + ('Z' - ch));
		}
		else if(ch>='a' && ch<='z'){//if it is true ,display lower case
			ciphertext += (char) ('a' + ('z' - ch));
		}
		else if(Character.isWhitespace(ch)) {
			ciphertext+=ch;
		}
	}
	return ciphertext;
	
	
	
	}
	public static String rot13(String value) {
	//System.out.print("mpikaaa mesa stin rot");
	char[] values = value.toCharArray();
		for (int i = 0; i < values.length; i++) {
		char letter = values[i];
		
		
		
		if (letter >= 'a' && letter <= 'z') {
		// Rotate lowercase letters.
		
		
		
		if (letter > 'm') {
			letter -= 13;
		} else {
			letter += 13;
		}
	} else if (letter >= 'A' && letter <= 'Z') {
	// Rotate uppercase letters.
	
	
	
		if (letter > 'M') {
			letter -= 13;
		} else {
			letter += 13;
		}
		}
			values[i] = letter;
		}
		// Convert array to a new String.
	return new String(values);
	}

}