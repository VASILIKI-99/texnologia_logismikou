package commands;



import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;
import view.InfoData;



import input.*;



public class OpenDocument implements Commands {

	private InfoData iData;
	public static String extension;
	private static String code=null;
	
	
	public OpenDocument() {
		this.iData = iData;
	}
	
	public OpenDocument(String code) {
		this.code=code;	
	}
	
	
	public static void act() {
	
		
		
		
		JFileChooser jfc = new JFileChooser();
		jfc.setCurrentDirectory(new java.io.File("./"));
		String path = null;
		
		//jfc.setAcceptAllFileFilterUsed(false);
		FileNameExtensionFilter filter = new FileNameExtensionFilter("word files", "docx");
		jfc.addChoosableFileFilter(filter);
		FileNameExtensionFilter filter1 = new FileNameExtensionFilter("excel files", "xlsx");
		jfc.addChoosableFileFilter(filter1);
		//FileNameExtensionFilter filter2 = new FileNameExtensionFilter("All files");
		//jfc.addChoosableFileFilter(filter2);
		//jfc.showOpenDialog(null);
		
		int returnValue = jfc.showOpenDialog(null);
		
		
		
		// int returnValue = jfc.showSaveDialog(null);
		//System.out.println(selectedFile.getAbsolutePath());
		
		
		if (returnValue == JFileChooser.APPROVE_OPTION) {
		
		File selectedFile = jfc.getSelectedFile();
		path = selectedFile.getAbsolutePath();
		//System.out.println(selectedFile.getAbsolutePath());
		
		
		extension = getFileExtension(path);
		
		//System.out.println(extension);
		if(extension.equals("docx")) {
			DocumentReaderFactory docRead = new DocumentReaderFactory();
			docRead.createReader(extension,path,code);
		}
		else if(extension.equals("xlsx")){
			DocumentReaderFactory docRead = new DocumentReaderFactory();
			docRead.createReader(extension,path, code);
		}
		
		
		
		}
	}
	public static String getFileExtension(String fullName) {
		//checkNotNull(fullName);
		String fileName = new File(fullName).getName();
		int dotIndex = fileName.lastIndexOf('.');
		return (dotIndex == -1) ? "" : fileName.substring(dotIndex + 1);
	}
}