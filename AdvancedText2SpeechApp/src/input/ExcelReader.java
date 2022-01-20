package input;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedInputStream;
import java.io.File;  
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;  
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import view.WindowText;

 
public class ExcelReader implements DocumentReader {
	static String text="";
	public String path;
	private static List<List<String>> dataFromExcel;

	
	public static void read(String path,String code)   {

		 FileInputStream excelFile;

	        //columnNamesFromExcel = new ArrayList<>();
	        dataFromExcel = new ArrayList<>();
	        try {
	            excelFile = new FileInputStream(new File(path));
	            Workbook workbook = new XSSFWorkbook(excelFile);
	            Sheet datatypeSheet = workbook.getSheetAt(0);
	            Iterator<Row> iterator = datatypeSheet.iterator(); //We use an iterator to get all rows

	            while (iterator.hasNext()) {
	                Row currentRow = iterator.next();
	                Iterator<Cell> cellIterator = currentRow.iterator();

	                List <String> dataRow = new ArrayList<>();
	                
	                
	                
	                while (cellIterator.hasNext()) {
	                    Cell currentCell = cellIterator.next();
	                        if (currentCell.getCellType() == CellType.STRING) {
	                            dataRow.add(currentCell.getStringCellValue());
	                        } else if (currentCell.getCellType() == CellType.NUMERIC) {
	                            dataRow.add(String.valueOf(currentCell.getNumericCellValue()));
	                       
	                    }
	                    
	                }
	                if (currentRow.getRowNum() >= 0) { //Row 0 is the header, if we add the first row, it will add an empty array because we didn't add anything to it before, so we skip it
	                    dataFromExcel.add(dataRow);
	                    text+=dataRow+"\n";
	                }
	                System.out.println();
	                
	            }
	        } catch (FileNotFoundException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        } catch (IOException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        }
	        WindowText rt = new WindowText();
	        

	    
	if(code =="atbash") {
		String text1 = atbash(text);
		rt.makeWinText(text1,dataFromExcel);
		
	}if(code =="rot13") {
		String text1 = rot13(text);
		rt.makeWinText(text1,dataFromExcel);
		
	}else if(code=="") {
		rt.makeWinText(text,dataFromExcel);
		
	}
	}

//encode atbash
 public static String atbash(String input) {
    	
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
 //encode rot13
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

				
		
		
		
		

	 