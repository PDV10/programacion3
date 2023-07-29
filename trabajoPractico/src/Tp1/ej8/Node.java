package Tp1.ej8;

public class Node<T> {

	private T info;
	public Node<T> prev,next;

	public Node() {
		this.info = null;
		this.prev = null;
		this.next = null;
	}
	
	public Node(T info, Node<T> prev,Node<T> next) {
		this.setInfo(info);
		this.setNext(prev);
		this.setNext(next);
	}
	

	public Node<T> getNext() {
		return next;
	}

	public Node<T> getPrev() {
		return prev;
	}

	public void setPrev(Node<T> prev) {
		this.prev = prev;
	}

	public void setNext(Node<T> next) {
		this.next = next;
	}

	public T getInfo() {
		return info;
	}

	public void setInfo(T info) {
		this.info = info;
	}
	
	@Override
	public String toString() {
		return this.getInfo().toString();
	}
}
