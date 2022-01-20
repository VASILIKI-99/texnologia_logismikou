package view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.table.DefaultTableModel;


import commands.CommandsFactory;


public class WindowText{
  
	private static String hist="";
    // JButton
//    private JButton b;
//    private static JTable excelTable;
//    private static JScrollPane scrollForExcelTable;
    private static JTextArea area, jthistory;
    //private JFrame frame;
    //private static List<List<String>> dataFromExcel;
    JTextPane jTextPane = new JTextPane();
//    private List<String> columnNamesFromExcel;
//    private List<List<String>> dataFromExcel;
    static String contents;
    static DefaultTableModel tableModel ;
	
	public static void makeWinText(String text,List<List<String>> dataFromExcel) {
		//ftiaxne parathuro 2
		 		
		
		JFrame frame = new JFrame();	 
		frame.setBounds(100, 100, 500, 500);	 		
		//frame.setLayout(null);
		frame.setVisible(true);
		frame.setTitle("Advanced Text To Speech App");
				
		

		JMenu menu1,menu2,menu3,menu4,menu5,menu6,menu7;  
        JMenuItem i1, i2, i3, i4, i5, i6, i7, i8, i9;  
		if (text!=" ") {
			
			
			
		       area=new JTextArea(text);  
		       area.setBounds(0,0, 500,440);  
		       frame.add(area); 
		       //frame.setLayout(null);
		        
		      String contents = area.getText();
		      System.out.println(contents);
		      //frame.setVisible(true);
		      
		      JScrollPane scrollPane = new JScrollPane(area);
		      scrollPane.setBounds(0,0,485,440);
		      frame.getContentPane().add(scrollPane, BorderLayout.CENTER);
		      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		      //frame.setSize(500, 440);
		      frame.setLocationRelativeTo(null);
		      //frame.setVisible(true);


		      
			} 
        JMenuBar mb=new JMenuBar();  
        menu1=new JMenu("File");  
       
        i1=new JMenuItem("Open");
        i1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Text2SpeechEditorView window = new Text2SpeechEditorView();
				window.createWindow();
				//hist+="Open_Document "+"\n";
				//CommandsFactory open =new CommandsFactory();
				//open.createCommand("openDocument");
			}
		});
        
        
       
        
        i2=new JMenuItem("Save as Word");  
        i2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				contents = area.getText();
				///System.out.println(contents);
				InfoData inf = new InfoData(contents);
				inf.setText(contents);
				inf.setSaveflag(0);
				CommandsFactory save =new CommandsFactory(inf);
				save.createCommand("saveDocument");
				hist+="Save_Document"+"\n";
				//System.out.println("kanw save");
				
			}
		});
        
        
        
        
        
        
        i3=new JMenuItem("Save as Excel");  
        i3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				
				contents = area.getText();
				String con = contents.replace(",", "");
				System.out.println(con);
				InfoData inf = new InfoData(con);
				inf.setText(con);
				inf.setSaveflag(1);
				CommandsFactory save =new CommandsFactory(inf);
				save.createCommand("saveDocument");
				
				
				//hist+="saveExcelDocument";
				//System.out.println("kanw saveExcel");
				
			}
		});
        
        
         
        menu1.add(i1); menu1.add(i2); menu1.add(i3);  
         
        mb.add(menu1);  
        frame.setJMenuBar(mb);  
       frame.setSize(400,400);  
        //frame.setLayout(null);  
       frame.setVisible(true);  
        
        
        
        menu2=new JMenu("Play");  
      
        
        
        
        
        i4=new JMenuItem("Play all file"); 
        i4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				contents = area.getText();
				System.out.println(contents);
				InfoData inf = new InfoData(contents);
				inf.setText(contents);
				
				CommandsFactory play =new CommandsFactory(inf);
				play.createCommand("documentToSpeech");
			    hist+="Play_all_file: "+ contents +"\n";
				//System.out.println("kanw play");
				
			}
		});
        
        
        i5=new JMenuItem("Play selected text"); 
        
        
        	i5.addActionListener(new ActionListener() {
        		
        		
        		public void actionPerformed(ActionEvent e) {
        		
        			String text = area.getSelectedText();
        			System.out.println("Text = " + text);
        	
        			InfoData inf = new InfoData(text);
        			inf.setText(text);
        			hist+="Select_Line: "+text +"\n" ;
        			CommandsFactory play =new CommandsFactory(inf);
        			play.createCommand("documentToSpeech");
			
        	
        	
        	}
        	});

        
        

        menu2.add(i4); menu2.add(i5);  
        mb.add(menu2);  
        
        
        
		menu7=new JMenu("History");  
		mb.add(menu7); 
		menu7.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	
		    	  CommandsFactory p =new CommandsFactory();
					//String h = p.gethistory();
					System.out.println(hist);
			}
		
		}); 
		
		JMenuItem showHistory = new JMenuItem("Show History");
		showHistory.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				 //CommandsFactory p =new CommandsFactory();
					//String h = p.gethistory();
					showhistory();
				
				
			}
		});
		
		menu7.add(showHistory);
		
        menu3=new JMenu("Volume");  
		mb.add(menu3);
		
		JSlider volume = new JSlider();
		volume.setValue(100);
		volume.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent event) {
				 float value = volume.getValue();
			        
				
				 System.out.println(value);
			        if(value>35) {
			        	value = value + 15;
			        }
					System.out.println(value);
					
					InfoData inf = new InfoData(value/80);
					inf.setVolume(value/80);
					inf.setFlag(1);
					
					CommandsFactory p =new CommandsFactory(inf);
					p.createCommand("tuneAudio");
					
					//System.out.println("kanw volume");
			        System.out.println(value);
		      }
		    });
		
		menu3.add(volume);
		
		
		
		
		
		menu4=new JMenu("Pitch");  
		mb.add(menu4);
		
		JSlider pitch = new JSlider();
		pitch.setValue(100);
		pitch.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent event) {
				 float value = pitch.getValue();
			        
			        
			        
					if(value>35) {
						value=value+200f;
					}
					
					//System.out.println(value);
					InfoData inf = new InfoData(value);
					inf.setPitch(value);
					inf.setFlag(0);
					
					CommandsFactory p =new CommandsFactory(inf);
					p.createCommand("tuneAudio");
					
					//System.out.println("kanw pitch");
			        //System.out.println(value);
		      }
		    });
		
		menu4.add(pitch);
		
		menu6=new JMenu("Speech Rate");  
		mb.add(menu6);
		
		JSlider speechR = new JSlider();
		speechR.setValue(100);
		speechR.addChangeListener(new ChangeListener() {
		      public void stateChanged(ChangeEvent event) {
		    	  
		    	  float value = speechR.getValue();
			        
		    	    //System.out.println(value);
					InfoData inf = new InfoData(value);
					inf.setSpeechR(value);
					inf.setFlag(2);
					
					CommandsFactory p =new CommandsFactory(inf);
					p.createCommand("tuneAudio");
					
					//System.out.println("kanw speech");
			        //System.out.println(value);
			        
			        
		      }
		    });
		
		menu6.add(speechR);
		
		
		
		menu5=new JMenu("Exit");  
		mb.add(menu5); 
		menu5.addChangeListener(new ChangeListener() {
		      public void stateChanged(ChangeEvent event) {
            	{
				System.exit(0);
			}
            }}
		); 
		

				
		




	}
	public static void showhistory() {
		
		JFrame framehistory = new JFrame();
		JMenuBar mbh=new JMenuBar(); 
		framehistory.setBounds(50,50,500,300);
		//framehistory.setLayout(null);
		framehistory.setVisible(true);
		framehistory.setTitle("History");
		
			jthistory=new JTextArea(hist);  
	        jthistory.setBounds(0,0, 500,440);  
	        framehistory.add(jthistory); 
	        framehistory.setLayout(null);
	        
			System.out.println(hist);
			 
			JMenu replayHistory = new JMenu("Replay History");  
			
			replayHistory.addChangeListener(new ChangeListener() {
			      public void stateChanged(ChangeEvent event) {
	            	{
	            		int i;
	            		String words ="";
	    				String[] list = hist.split("\\s+");
	    				for(i=0;i< list.length ;i++) {
	    					if((list[i].equals("Play_all_file:"))||(list[i].equals("Select_Line:"))||(list[i].equals("Open_Document"))||(list[i].equals("Save_Document"))) {
	    						//System.out.println(list[i]);
	    						
	    						words += "";
	    							    					      
	    					}
	    					else{
	    						words+= " "+list[i];
	    						//System.out.println(list[i]);
	    					}
	    					
	    					//System.out.println(words);
	    					
	    				}
	    				System.out.println(words);
						InfoData inf = new InfoData(words);
	    				inf.setText(words);
	    				
	    				CommandsFactory play1 =new CommandsFactory(inf);
	    				play1.createCommand("documentToSpeech");
	            		
				}
	            }}
			); 

			mbh.add(replayHistory);
			
			
			
			
			
			JMenu returnHistory = new JMenu("Return to Main Window");  
			
			returnHistory.addChangeListener(new ChangeListener() {
			      public void stateChanged(ChangeEvent event) {
	            	{
	            		//frame.setVisible(true);
	            		framehistory.setVisible(false);
				}
	            }}
			); 
			
			//returnHistory.setEnabled(false);
			//framehistory.add(mbh);
			mbh.add(returnHistory);
			framehistory.setJMenuBar(mbh);
			
			
			
			
			JMenu cleanUpHistory = new JMenu("Clean up History");  
			
			cleanUpHistory.addChangeListener(new ChangeListener() {
			      public void stateChanged(ChangeEvent event) {
	            	{

//	            		jthistory.selectAll();
//	            		jthistory.replaceSelection("");
	            		jthistory.setText(null);
	            		hist = "";
				}
	            }}
			); 
			
			//returnHistory.setEnabled(false);
			//framehistory.add(mbh);
			mbh.add(cleanUpHistory);
	        
	}
	
	
	
}

//gia excel an theloyme pinaka mesa
//if (text==" ") {
//DefaultTableModel tableModel = new DefaultTableModel(dataFromExcel.toArray(),0);
//for (List<String> row : dataFromExcel) {
//    tableModel.addRow(row.toArray(new String[0]));
//    System.out.println(row);
//    
//}
//
//excelTable = new JTable(tableModel);
//scrollForExcelTable = new JScrollPane(excelTable);
//
//System.out.println(" hello mbikaaa ");
//frame.add(scrollForExcelTable, null);
//frame.pack();
//
//frame.setVisible(true);
//
//
//}
