package input;


public class DocumentReaderFactory {
	public String path;
	
	public DocumentReader createReader(String type,String path,String code) {
		
		if (type.equals("docx")) {
			WordReader wr = new WordReader();
			wr.read(path,code);
		}
		if(type.equals("xlsx")) {
			
			ExcelReader excel = new ExcelReader();
			excel.read(path,code);
		}
		return null;
	}
}
