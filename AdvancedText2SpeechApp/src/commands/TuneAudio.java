package commands;

import view.InfoData;

public class TuneAudio implements Commands {
	private static float pitch,volume,speechR;
	private static int flag;
	
	
	private static InfoData iData;
	public TuneAudio() {
		
	}
	public TuneAudio(InfoData iData) {
		this.iData=iData;
		pitch=iData.getPitch();
		volume=iData.getVolume();
		speechR=iData.getSpeechR();
		flag=iData.getFlag();
	}
	
	static float Array []= {100,1,100};
	
	
	public static float[] act() {
		
		if(flag==0) {
			Array[0]=p();
			//Array[1]=1;
			//Array[2]=100;
			return Array;
		}else if(flag==1){
			//Array[0]=100;
			Array[1]=v();
			//Array[2]=100;
			return Array;
		}else{
			//Array[0]=100;
			//Array[1]=1;
			Array[2]=speechRate();
			return Array;
		}
		
		
		
		
	}
	public static float p() {
		return TuneAudio.pitch;
	}
	public static float v() {
		return TuneAudio.volume;
	}
	public static float speechRate() {
		return TuneAudio.speechR;
	}
	
}
