package util.general.model;

public enum NewLine {

	WINDOWS("\r\n"), UNIX("\n"), MAC("\r"), HTML("<br/>"); 
	
	private String str;
	
	NewLine(String str){
		this.str=str;
	}//NewLine
	
	public String str() {
		return str;
	}//toString
	
}//enum
