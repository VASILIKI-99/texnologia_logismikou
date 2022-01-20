package commands;

import java.io.FileOutputStream;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;

import view.InfoData;

public class SaveDocument implements Commands {
	
	static String stext;
	static int saveflag;
	
	
	public SaveDocument(InfoData iData) {
		stext=iData.getText();
		saveflag=iData.getSaveflag();
	}
	public SaveDocument() {
		
	}
	
	
	public static void act()  {
					
		String path;
		JFileChooser chooser = new JFileChooser();
		chooser.setCurrentDirectory(new java.io.File("./"));
		
		FileNameExtensionFilter filter = new FileNameExtensionFilter("Word files", "docx");
		chooser.addChoosableFileFilter(filter);
		FileNameExtensionFilter filter1 = new FileNameExtensionFilter("Excel files", "xlsx");
		chooser.addChoosableFileFilter(filter1);
		
		
		chooser.setDialogTitle("Save File");
		
		

		if (chooser.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
		  //System.out.println("getCurrentDirectory(): " + chooser.getCurrentDirectory());
		  //System.out.println("getSelectedFile() : " + chooser.getSelectedFile());
		} else {
		  System.out.println("No Selection ");
		}
		//System.out.println(saveflag);
		
		
		path=chooser.getSelectedFile().getAbsolutePath();
		
		if(saveflag==0) {
			
			path+=".docx";

			
			
			
			String l2 = stext.replace("[", ""); 
			String l3 = l2.replace("]", "");
			String l4 = l3.replace(",", "");
						
			XWPFDocument document = null;
			FileOutputStream fileOutputStream = null;
			try {
	 
				document = new XWPFDocument();
				File fileToBeCreated = new File(path);
				fileOutputStream = new FileOutputStream(fileToBeCreated);
				XWPFParagraph p2 = document.createParagraph();
				XWPFRun r2 = p2.createRun();
	            r2.setText(l4);
				document.write(fileOutputStream);
				
				//System.out.println(s);
				System.out.println("Word Document Created Successfully !");
	 
			} catch (Exception e) {
				System.out.println("error in Word Doc");
			} finally {
				try {
					if (document != null) {
						document.close();
					}
					if (fileOutputStream != null) {
						fileOutputStream.close();
					}
				} catch (Exception ex) {
				}
			}
	 
		}

	if(saveflag==1) {
		
		path+=".xlsx";
		
		XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("Elements Excel");
        
        
        //System.out.println(stext);        
		
		String[] list;
		String[] list1;
		
		
		String l = stext.replace("[", ""); 
		String l1 = l.replace("]", "");
		list1 = l1.split("\\n");
		//System.out.println(list1);
			

        
		for(int i2=0;i2<list1.length;i2++) {

			if(list1[i2].equals(",")){
				 list = list1[i2].split(",");
			}else {
				list = list1[i2].split(" ");
			}
       
        Row row = sheet.createRow(i2);
        
        for(int i1=0;i1<list.length;i1++) {
        	Cell cell = row.createCell(i1);
        	cell.setCellValue(list[i1]);
        
        
        }
		}
        try (FileOutputStream outputStream = new FileOutputStream(path)) {
            workbook.write(outputStream);
            workbook.close();
        }catch(Exception e){
        	//System.out.println("den exw idea ti egine");
        }
    
		System.out.println(path);
	
        
	}
    }
		
		
		
		
        
	
  

}
		
		
		
	

