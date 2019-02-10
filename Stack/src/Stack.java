import java.io.BufferedReader;
import java.io.Console;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.omg.CORBA.portable.ValueBase;

public class Stack<T> {
	Node<T> head;
	List<Node<T>> list;
	 public Stack() {
		head = null;
		list = new ArrayList<Node<T>>();
	}
	 public void push(T x){		 
		 Node<T> newNode = new Node<T>(x,null);
		 if(list.isEmpty()){
			 head = newNode;
			 list.add(newNode);	
			 return;
		 }
		 Node<T> lastNode = this.top();
		 lastNode.nextPointer = newNode;
		 list.add(newNode);		 
	 }
		 
	 public List<T> GetStackItems() {
		 List<T> valuesList = new ArrayList<T>();
		for (Node<T> t : this.list) {
			valuesList.add(t.nodeValue);
		}
		return valuesList;
	}
	 public Node<T> pop() {
		 Node<T> lastNode = this.top();
		 Node<T> lastButOneNode = null;
		 Node<T> temp  = this.head;		
		 while(temp.nextPointer.nextPointer != null){
			 lastButOneNode = temp;
			 temp = temp.nextPointer;			 
		 }	
		 list.remove(lastNode);
		 if(lastButOneNode != null){
			 lastButOneNode.nextPointer = null;
		 }
		 return lastNode;
	}
	 
	 public Node<T> top() {
		 Node<T> temp  = this.head;		
		 while(temp.nextPointer != null){
			 temp = temp.nextPointer;
		 }		
		 return temp;
	}
	 
	 public int getMin(){
		 Node<T> temp  = this.head;	
			 int min = Integer.valueOf((temp.nodeValue.toString()));
			 
			 
			 while(temp.nextPointer != null){
				 if(Integer.valueOf((temp.nodeValue.toString())) < min){
					 min = Integer.valueOf(temp.nodeValue.toString());
				 }
				 temp = temp.nextPointer;
			 }
			 return min; 
		 
		 
	 }
	 public static void main (String args[]) throws IOException, NullPointerException{
		 Stack<Integer> stack = new Stack<Integer>();
		 System.out.println("Enter the element to push and 'c' to cancel");
		 BufferedReader reader = 
                 new BufferedReader(new InputStreamReader(System.in));
      
      // Reading data using readLine
           
		 while(true){
			 
			 String inp = reader.readLine();
			 if(inp.equals("c")){
				 break;
			 }
			
			 System.out.println(inp);
			try {
				int inputInt = Integer.parseInt(inp);
				stack.push(inputInt);	
			} 
			catch (Exception e) 
			{				
				e.printStackTrace();
			}
			 		 
		 }
		 System.out.println("Enter p to pop element");
		 while(reader.readLine().equals("p")){
			 stack.pop();	
			 for (Integer value : stack.GetStackItems()) {
				System.out.println(value);
			}
			 
		 }
		 System.out.println("Enter min to get min. element");
		 if(reader.readLine().equals("m")){
			 System.out.println(stack.getMin());			 		 
		 }
	 }
}
