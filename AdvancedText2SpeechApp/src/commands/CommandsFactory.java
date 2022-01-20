package commands;


import view.InfoData;

public class CommandsFactory {
	
	private InfoData iData;
	
	
	public CommandsFactory() {
		
	}
	
	public CommandsFactory(InfoData i) {
		this.iData=i;
	}
	
	public Commands createCommand(String type) {
		
		if (type.equals("documentToSpeech")) {
			
			DocumentToSpeech dts=  new DocumentToSpeech(iData);
			dts.act();
		}
		
		
		if (type.equals("openDocument")) {
			
			OpenDocument opend = new OpenDocument("");
			opend.act();
		}
		if (type.equals("openDocumentAtbash")) {
			
			OpenDocument opend = new OpenDocument("atbash");
			opend.act();
		}
		if (type.equals("openDocumentRot13")) {
			
			OpenDocument opend = new OpenDocument("rot13");
			opend.act();
		}
		
		if (type.equals("saveDocument")) {
			
			 //System.out.println("kanw save");
			//System.out.println(iData.getText());
			 SaveDocument sav= new SaveDocument(iData);
			 sav.act();
		}
		
		if(type.equals("tuneAudio")) {
			
			TuneAudio t =new TuneAudio(iData);
			t.act();
		}

		
		
		return null;
		
	}

	


}
