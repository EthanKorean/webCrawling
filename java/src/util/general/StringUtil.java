package util.general;

import java.text.SimpleDateFormat;
import java.util.Date;

import util.general.model.DateTimeFormat;
import util.general.model.NewLine;


public class StringUtil {
	
    public static final String EMPTY = "";
    
    public static String getCurDateTime(DateTimeFormat dtf ){
        return new SimpleDateFormat(dtf.getFormat()).format(new Date());
    }//getCurDate

    public static boolean isNullOrEmpty(String data){
        return (data==null||EMPTY.equals(data.trim()));
    }//isNullOrEmpty
    
    public static String replaceNewLine(NewLine origin, NewLine target, String text) {
    	return text.replaceAll(origin.str(), target.str());
    }//replaceToHTMLNewLine
}//class
