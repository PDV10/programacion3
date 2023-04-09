package Tp1.ej5;

import java.util.Iterator;

import Tp1.Node;

public class MySimpleLinkedListIterable<T> implements Iterable<T> {
	public Node<T> first;
	public int size;

	public MySimpleLinkedListIterable() {
		this.first = null;
		this.size = 0;
	}

	public void insertFront(T info) {
		Node<T> tmp = new Node<T>(info, null);
		tmp.setNext(this.first);
		this.first = tmp;
		size++;
	}

	public <T> T extractFront() {
		if (this.first != null) {
			T info = (T) this.first.getInfo();
			this.first = this.first.getNext();
			size--;
			return info;
		} else {
			return null;
		}
	}

	public boolean isEmpty() {
		return this.first == null;
	}

	public int getSize() {
		return size;
	}

	public T get(int i) {
		Node aux = this.first;
		int cont = 0;
		
		while(aux != null && cont < i) {
			aux = aux.getNext();
			cont++;
		}
		
		return (T)aux.getInfo();
	}
	
	public int indexOF(T o) {
		int i = 0;
		Node aux = first;
		while(aux != null && aux.getInfo() != o) {
			i++;
			aux = aux.getNext();
		}
		
		if(aux == null) {
			return -1;
		}
		return i;			
	}

	@Override
	public String toString() {
		String r = "";
		Node aux = first;
		
		while(aux != null) {
			r += " - " + aux.getInfo() + " - \n";
			aux = aux.getNext();
		}
		return  r;
	}

	@Override
	public Iterator<T> iterator() {
	
		return null;
	}
}
