import java.util.LinkedList;
import java.util.Queue;

public class StackUsingQueues {

	public Queue<Integer> queue;
	public Queue<Integer> tempQueue;
	int top = 0;
	public StackUsingQueues() {
		queue = new LinkedList<Integer>();
		tempQueue = new LinkedList<Integer>();
	}
	public void push(int x) {
		queue.add(x);
		this.top = x;
	}
	
	public int pop() {
		int a = this.queue.peek();
		int tempTop = this.top;
		while (a != tempTop){
			this.push(this.queue.remove());	
			a= this.queue.peek();
		}
		return this.queue.remove();
	}
	
	public int top() {
		return this.top;
	}
	
	public boolean empty() {
	     return this.queue.isEmpty();
	}
	
	public static void main(String[] args) {
		StackUsingQueues stack = new StackUsingQueues();
		stack.push(1);
		stack.push(2);  
		stack.top();   // returns 2
		stack.pop();   // returns 2
		stack.pop(); 
		stack.empty();

	}

}
