package util.general;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONObject;

/**
 * File을 읽어들이는 Util
 * @author DaeHyeonKim
 */
public class FileReadUtil {

	/*
	 * binary file
	 * */
	public static byte[] readBinary(String path) throws IOException{
		return readBinary(new File(path));
	}//readBinary
	
	public static byte[]  readBinary(File target) throws IOException{
		return readBinary(new FileInputStream(target));
	}//readBinary
	
	public static byte[]  readBinary(InputStream is) throws IOException{
		byte[] bytes=null;
		ByteArrayOutputStream byteStream =null;
		try {
			byteStream = new ByteArrayOutputStream(); 
			byte[] buffer = new byte[is.available()];
			int result=0;
			while((result=is.read(buffer)) != -1) {
				byteStream.write(buffer,0,result);
			}//end while
			bytes=byteStream.toByteArray();
		}finally {
			if(is!=null) {
				is.close();
			}//end if
			if(byteStream!=null) {
				byteStream.close();
			}//end if
		}//end finally
		return bytes;
	}//readBinary
	
	/*
	 * text file to String
	 * */
	public static String readTextToString(String path) throws IOException {
		return readTextToString(new File(path));
	}//readTextToString
	
	public static String readTextToString(File target) throws IOException {
		return readTextToString(new BufferedReader(new FileReader(target)));
	}//readTextToString
	
	public static String readTextToString(InputStream is) throws IOException {
		return new String(readBinary(is));
	}//readTextToString
	
	
	public static String readTextToString(BufferedReader reader) throws IOException {
		StringBuilder sb = new StringBuilder();
		try {
			String line="";
			while((line=reader.readLine()) !=null) {
				sb.append(line);
			}//end while
		}finally {
			if(reader!=null) {
				reader.close();
			}//end if
		}//end finally
		return sb.toString();
	}//readTextToString
	
	
	/*
	 * text file to List
	 * */
	public static List<String> readTextToList(String path) throws IOException {
		return readTextToList(new File(path));
	}//readTextToList
	
	public static List<String> readTextToList(File target) throws IOException {
		return readTextToList(new BufferedReader(new FileReader(target)));
	}//readTextToList

	public static List<String> readTextToList(BufferedReader reader) throws IOException {
		List<String> list = new ArrayList<String>();
		try {
			String line="";
			while((line=reader.readLine()) !=null) {
				list.add(line);
			}//end while
		}finally {
			if(reader!=null) {
				reader.close();
			}//end if
		}//end finally
		return list;
	}//readTextToList
	
	
	/*
	 * text file to Array
	 * */
	public static String[] readTextToArray(String path) throws IOException {
		return readTextToArray(new File(path));
	}//readTextToArray

	public static String[] readTextToArray(File target) throws IOException {
		return readTextToList(new BufferedReader(new FileReader(target))).toArray(new String[0]);
	}//readTextToArray
	
	
	/*
	 * json file
	 * */
	public static JSONObject readJSON(String path) throws IOException{
		return readJSON(new File(path));
	}//readJSON
	
	public static JSONObject readJSON(File target) throws IOException{
		return readJSON(new BufferedReader(new FileReader(target)));
	}//readJSON
	
	public static JSONObject readJSON(InputStream is) throws IOException,NullPointerException{
		byte[] bytes = readBinary(is);
		return new JSONObject(new String(bytes));
	}//readJSON
	
	public static JSONObject readJSON(BufferedReader reader) throws IOException,NullPointerException{
		String str = readTextToString(reader);
		return new JSONObject(str);
	}//readJSON
	
}//class