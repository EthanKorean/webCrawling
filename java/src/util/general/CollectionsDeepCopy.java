package util.general;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

/**
 * Collection객체 deep copy하는 함수모음
 * @author DaeHyeonKim
 */
public class CollectionsDeepCopy {
	
	public static <T> List<T> copy(List<T> origin){
		List<T> copyList = new ArrayList<T>();
		for(int i =0; i < origin.size();i++) {
			copyList.add(origin.get(i));
		}//end for
		return copyList;
	}//copy
	
	public static <T> Queue<T> copy(Queue<T> origin){
		List<T> list = copy(new ArrayList<T>(origin));
		Queue<T> copyQueue = new LinkedList<T>(list);
		return copyQueue;
	}//copy
	
	public static <T> PriorityQueue<T> copy(PriorityQueue<T> origin){
		List<T> list = copy(new ArrayList<T>(origin));
		PriorityQueue<T> copyQueue = new PriorityQueue<T>(list);
		return copyQueue;
	}//copy
	
	public static <T> Stack<T> copy(Stack<T> origin){
		List<T> list = new ArrayList<T>(origin);
		Stack<T> copyStack = new Stack<T>();
		for(int i =0; i < list.size();i++) {
			copyStack.add(list.get(i));
		}//end for
		return copyStack;
	}//copy
	
}//class
