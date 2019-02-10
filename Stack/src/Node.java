 public class Node<T> {
	T nodeValue;
	Node<T> nextPointer;
	public Node(T value, Node<T> next) {
		nodeValue = value;
		nextPointer = next;
	}
}
