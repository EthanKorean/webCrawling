package util.general.model;

public enum DateTimeFormat {
	DATE_FORMAT1("yyyyMMdd"),
	DATE_FORMAT2("yyyy MM dd"),
	DATE_FORMAT3("yyyy.MM.dd"),
	DATE_FORMAT4("yyyy-MM-dd"),
	
	TIME_FORMAT1("hhmmss"),
	TIME_FORMAT2("hh mm ss"),
	TIME_FORMAT3("hh.mm.ss"),
	TIME_FORMAT4("hh:mm:ss"),
	
	DATE_TIME_FORMAT1("yyyy MM dd hh:mm:ss"),
	DATE_TIME_FORMAT2("yyyy.MM.dd hh:mm:ss");
	
	private String format;

	private DateTimeFormat(String format) {
		this.format = format;
	}//DateFormatModel

	public String getFormat() {
		return format;
	}//getFormat
	
}//enum
