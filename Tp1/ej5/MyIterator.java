package Tp1.ej5;

import java.util.Iterator;

public class MyIterator<T> implements Iterator<T>{
	MySimpleLinkedListIterable<T> lista = new MySimpleLinkedListIterable<T>();
	
	@Override
	public boolean hasNext() {
		
		return false;
	}

	@Override
	public T next() {
	//	this.lista.
		return null;
	}

}
