package view;

import java.util.ArrayList;




public class InfoData {
	
	private String title;
	private String text;
	private float pitch,volume,sr;
	private int num,saveflag;
	public InfoData() {
		
	}
	public InfoData(String text) {
		this.text=text;
	}
	public InfoData(float pitch) {
		this.pitch=pitch;
	}

	public String getTitle() {
		return this.title;
	}
	
	public void setText(String stext) {
		this.text=stext; 
	}
	public String getText() {
		return this.text;
	}
	public void setPitch(float pitch) {
		this.pitch=pitch; 
	}
	public float getPitch() {
		return this.pitch;
	}
	public void setVolume(float volume) {
		this.volume = volume;
	}
	public float getVolume() {
		return this.volume;
	}
	public void setFlag(int num) {
		this.num =num;
	}
	public int getFlag() {
		return this.num;
	}
	public void setSpeechR(float sr) {
		this.sr=sr; 
	}
	public float getSpeechR() {
		return this.sr;
	}
	public void setSaveflag(int saveflag) {
		this.saveflag =saveflag;
	}
	public int getSaveflag() {
		return this.saveflag;
	}

}
