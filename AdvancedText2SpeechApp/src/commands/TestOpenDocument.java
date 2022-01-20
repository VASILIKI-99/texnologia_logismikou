package commands;



import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import view.InfoData;


class TestOpenDocument {

@Test
void test() {
	//kaname save ena neo arxeio kai ustera to anoijame
	String text1="for open test pass successfully!";
	InfoData iData1 = new InfoData();
	iData1.setText(text1);
	//
	iData1.setSaveflag(0);
	
	SaveDocument sd1=new SaveDocument(iData1);
	sd1.act();
	
	
	
	String code1 ="atbash";
	OpenDocument od1 = new OpenDocument(code1);
	od1.act();


}



@Test
void test2() {
	//kaname save ena neo arxeio kai ustera to anoijame
	String text1="for open test pass successfully!";
	InfoData iData = new InfoData();
	iData.setText(text1);
	//
	iData.setSaveflag(0);
	
	SaveDocument sd=new SaveDocument(iData);
	sd.act();
	
	
	
	String code ="rot13";
	OpenDocument od = new OpenDocument(code);
	od.act();


}




}