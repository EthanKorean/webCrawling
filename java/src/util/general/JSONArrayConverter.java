
package util.general;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

import org.json.JSONArray;

import util.general.model.OrderBy;

/**
 * JSONArray객체를 자바배열이나, Collection으로 변환하는 메소드모음
 * @author DaeHyeonKim
 */
public class JSONArrayConverter {
	
	
	/***********************************************************
	 *  List
	 ***********************************************************/
	
	public static List<String> toStringList(JSONArray jArray){
		List<String> list = new ArrayList<String>();
		for(int i=0; i < jArray.length();i++) {
			list.add(jArray.getString(i));
		}//end for
		return list;
	}//toStringList
	
	public static List<Integer> toIntegerList(JSONArray jArray){
		List<Integer> list = new ArrayList<Integer>();
		for(int i=0; i < jArray.length();i++) {
			list.add(jArray.getInt(i));
		}//end for
		return list;
	}//toIntegerList
	
	public static List<Double> toDoubleList(JSONArray jArray){
		List<Double> list = new ArrayList<Double>();
		for(int i=0; i < jArray.length();i++) {
			list.add(jArray.getDouble(i));
		}//end for
		return list;
	}//toDoubleList
	
	public static List<Float> toFloatList(JSONArray jArray){
		List<Float> list = new ArrayList<Float>();
		for(int i=0; i < jArray.length();i++) {
			list.add(jArray.getFloat(i));
		}//end for
		return list;
	}//toFloatList
	

	/***********************************************************
	 *  Array
	 ***********************************************************/
	
	public static String[] toStringArray(JSONArray jArray){
		String[] arr = new String[jArray.length()];
		for(int i=0; i < jArray.length();i++) {
			arr[i] =jArray.getString(i);
		}//end for
		return arr;
	}//toStringArray
	
	public static int[] toIntArray(JSONArray jArray){
		int[] arr = new int[jArray.length()];
		for(int i=0; i < jArray.length();i++) {
			arr[i] =jArray.getInt(i);
		}//end for
		return arr;
	}//toIntArray
	
	public static double[] toDoubleArray(JSONArray jArray){
		double[] arr = new double[jArray.length()];
		for(int i=0; i < jArray.length();i++) {
			arr[i] =jArray.getDouble(i);
		}//end for
		return arr;
	}//toDoubleArray
	
	public static float[] toFloatArray(JSONArray jArray){
		float[] arr = new float[jArray.length()];
		for(int i=0; i < jArray.length();i++) {
			arr[i] =jArray.getFloat(i);
		}//end for
		return arr;
	}//toFloatArray
	
	/***********************************************************
	 *  Queue
	 ***********************************************************/
	
	public static Queue<String> toStringQueue(JSONArray jArray){
		Queue<String> queue = new LinkedList<>();
		for(int i=0; i < jArray.length();i++) {
			queue.add(jArray.getString(i));
		}//end for
		return queue;
	}//toStringQueue
	
	public static Queue<Integer> toIntQueue(JSONArray jArray){
		Queue<Integer> queue = new LinkedList<>();
		for(int i=0; i < jArray.length();i++) {
			queue.add(jArray.getInt(i));
		}//end for
		return queue;
	}//toIntQueue
	
	public static Queue<Double> toDoubleQueue(JSONArray jArray){
		Queue<Double> queue = new LinkedList<>();
		for(int i=0; i < jArray.length();i++) {
			queue.add(jArray.getDouble(i));
		}//end for
		return queue;
	}//toDoubleQueue
	
	public static Queue<Float> toFloatQueue(JSONArray jArray){
		Queue<Float> queue = new LinkedList<>();
		for(int i=0; i < jArray.length();i++) {
			queue.add(jArray.getFloat(i));
		}//end for
		return queue;
	}//toFloatQueue
	
	/***********************************************************
	 *  PriorityQueue
	 ***********************************************************/
	
	public static PriorityQueue<String> toStringPriorityQueue(JSONArray jArray,OrderBy orderBy){
		PriorityQueue<String> priorityQueue=null;
		if(orderBy==OrderBy.ASCENDING) {
			priorityQueue = new PriorityQueue<>();
		}else {
			priorityQueue = new PriorityQueue<>(Collections.reverseOrder());
		}//end else
		
		for(int i=0; i < jArray.length();i++) {
			priorityQueue.add(jArray.getString(i));
		}//end for
		return priorityQueue;
	}//toStringPriorityQueue
	
	public static PriorityQueue<Integer> toIntPriorityQueue(JSONArray jArray,OrderBy orderBy){
		PriorityQueue<Integer> priorityQueue=null;
		if(orderBy==OrderBy.ASCENDING) {
			priorityQueue = new PriorityQueue<>();
		}else {
			priorityQueue = new PriorityQueue<>(Collections.reverseOrder());
		}//end else
		
		for(int i=0; i < jArray.length();i++) {
			priorityQueue.add(jArray.getInt(i));
		}//end for
		return priorityQueue;
	}//toIntPriorityQueue
	
	public static PriorityQueue<Double> toDoublePriorityQueue(JSONArray jArray,OrderBy orderBy){
		PriorityQueue<Double> priorityQueue=null;
		if(orderBy==OrderBy.ASCENDING) {
			priorityQueue = new PriorityQueue<>();
		}else {
			priorityQueue = new PriorityQueue<>(Collections.reverseOrder());
		}//end else
		
		for(int i=0; i < jArray.length();i++) {
			priorityQueue.add(jArray.getDouble(i));
		}//end for
		return priorityQueue;
	}//toDoublePriorityQueue
	
	public static PriorityQueue<Float> toFloatPriorityQueue(JSONArray jArray,OrderBy orderBy){
		PriorityQueue<Float> priorityQueue=null;
		if(orderBy==OrderBy.ASCENDING) {
			priorityQueue = new PriorityQueue<>();
		}else {
			priorityQueue = new PriorityQueue<>(Collections.reverseOrder());
		}//end else
		
		for(int i=0; i < jArray.length();i++) {
			priorityQueue.add(jArray.getFloat(i));
		}//end for
		return priorityQueue;
	}//toFloatPriorityQueue
	
	/***********************************************************
	 *  Stack
	 ***********************************************************/
	public static Stack<String> toStringStack(JSONArray jArray){
		Stack<String> stack = new Stack<>();
		for(int i=0; i < jArray.length();i++) {
			stack.add(jArray.getString(i));
		}//end for
		return stack;
	}//toStringQueue
	
	public static Stack<Integer> toIntStack(JSONArray jArray){
		Stack<Integer> stack = new Stack<>();
		for(int i=0; i < jArray.length();i++) {
			stack.add(jArray.getInt(i));
		}//end for
		return stack;
	}//toIntQueue
	
	public static Stack<Double> toDoubleStack(JSONArray jArray){
		Stack<Double> stack = new Stack<>();
		for(int i=0; i < jArray.length();i++) {
			stack.add(jArray.getDouble(i));
		}//end for
		return stack;
	}//toDoubleQueue
	
	public static Stack<Float> toFloatStack(JSONArray jArray){
		Stack<Float> stack = new Stack<>();
		for(int i=0; i < jArray.length();i++) {
			stack.add(jArray.getFloat(i));
		}//end for
		return stack;
	}//toFloatQueue
	
}//class
