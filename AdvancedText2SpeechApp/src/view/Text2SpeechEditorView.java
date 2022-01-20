package view;


import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.*;
import commands.CommandsFactory;



public class Text2SpeechEditorView  {
	
	private JFrame frame,frame1;
	private InfoData iData;
	//private ArrayList<String> commands;																																																
	
	//main
	public static void main(String[] args) {
		  

		EventQueue.invokeLater(new Runnable() {
		public void run() {
			try {
				Text2SpeechEditorView window = new Text2SpeechEditorView();
				//window.frame.setVisible(true);
			} catch (Exception e) {
				e.printStackTrace();
			}
			}
		});
	



		}
	
	public Text2SpeechEditorView() {
		createWindow();
	}
	

	 
	 public void createWindow(){
		 
		 JFrame frame = new JFrame();
		 
		 frame.setBounds(100, 100, 500, 500);
		 frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 
		 frame.setLayout(null);
	     frame.setVisible(true);
		 frame.setTitle("Advanced Text To Speech App");
	
		 JButton myButton1 = new JButton("Open File");
		 JButton myButton2 = new JButton("Exit");
		 
		 
		 //open file 
		  frame.add(myButton1);
		  
		  myButton1.setBounds(100,120,300,60);//x,y,platos,upsos
		  myButton1.setFocusable(false);
		  myButton1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					
					//anoigma home directory gis kwdikopoihmeno h oxi
					chooseEncode();
					frame.setVisible(false);
					
				}
		  });
		  
		  //exit
		  frame.add(myButton2);
		 
		  myButton2.setBounds(100,250,300,60);//x,y,platos,upsos
		  myButton2.setFocusable(false);
		  myButton2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					System.exit(0);
				}
			});
		  
		 }
	 
	 
	 	public void chooseEncode() {
	 		
	 		frame1 =new JFrame();
	 		frame1.setTitle("Advanced Text To Speech App");
	 		frame1.setBounds(100, 100, 400, 300);
			frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame1.getContentPane().setLayout(null);
			frame1.setVisible(true);
			JLabel Choose = new JLabel("Select:");
			Choose.setBounds(150,50,250,16);
			//Choose.setPreferredSize(new Dimension(500, 300));
			frame1.getContentPane().add(Choose);
			
			
			JButton withencode = new JButton("Encode File");
			
			withencode.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					WindowEncode();
					
				}
			});
			withencode.setBounds(35,100,150,60);//x,y,platos,upsos
			withencode.setFocusable(false);
			frame1.add(withencode);
			
			
			JButton without = new JButton("Simple File");
			without.setBounds(200,100,150,60);//x,y,platos,upsos
			without.setFocusable(false);
			without.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					CommandsFactory open =new CommandsFactory();
					open.createCommand("openDocument");
				}
			});
			
			frame1.add(without);
			
			JButton btnBack = new JButton("Back");
			btnBack.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					frame1.setVisible(false);
					frame.setVisible(true);
					
				}
			});
			btnBack.setBounds(259,230,89,23);
			frame1.getContentPane().add(btnBack);
						
			
	 	}
	 	
	 	public void WindowEncode() {
	 		
	 		JFrame frame2 = new JFrame();
			 
			 frame2.setBounds(100, 100, 400, 300);
			 frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			 
			 frame2.setLayout(null);
		     frame2.setVisible(true);
			 frame2.setTitle("Advanced Text To Speech App");
		
			 JButton m1 = new JButton("Atbash");
			 JButton m2 = new JButton("Rot13");
			 
			 m1.setBounds(35,100,150,60);
			 m2.setBounds(200,100,150,60);
			 
			 
			 m1.setFocusable(false);
			 m1.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						CommandsFactory open =new CommandsFactory();
						open.createCommand("openDocumentAtbash");
					}
				});
				
				frame2.add(m1);
				
				
				m2.setFocusable(false);
				m2.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						CommandsFactory open =new CommandsFactory();
						open.createCommand("openDocumentRot13");
					}
				});
				
				frame2.add(m2);
			 
			 JButton btnBack = new JButton("Back");
				btnBack.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						frame2.setVisible(false);
						//frame.setVisible(true);
						
					}
				});
				btnBack.setBounds(259,230,89,23);
				frame2.getContentPane().add(btnBack);
			 
	 	}
	 


}
