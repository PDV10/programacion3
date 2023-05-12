package tp3;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;


public class MyIterator<T> implements Iterator<T>{
	
	private Arco cursor;
	
	public MyIterator(Arco arco){
		cursor = arco;
	}
	
	@Override
	public boolean hasNext() { 
		return this.cursor!= null; 
	}
	
	public int valor() {
		return cursor.getVerticeOrigen();				
	}

	public T next() { 	
		int info =  this.valor();
//		this.cursor = cursor.getNext();
 		return info;
	}
}
