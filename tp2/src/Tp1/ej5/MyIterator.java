package Tp1.ej5;

import java.util.Iterator;

import Tp1.Node;

public class MyIterator<T> implements Iterator<T>{
	
	private Node<T> cursor; // MyIterator se hace responsable del cursor
	
	//creamos un contructor en el que pasamos el nodo al que el cursor tiene que comenzar apuntando
	public MyIterator(Node<T> first){
		cursor = first;
	}
	
	@Override
	public boolean hasNext() { // hasNext pregunta si existe un proximo elemento para retornar 
		
		return this.cursor != null; //siempre y cuando sea distinto de null
	}
	
	public int valor() {
		return (int) cursor.getInfo();				
	}

	@Override
	public T next() { 	// retorna el elemento al cual esta apuntando el cursor en ese momento
						//  y luego lo avanza un paso siguiente para apuntar al proximo
		
		// primero nos quedamos con la info
		T info = this.cursor.getInfo();
		// luego avanza el cursor al proximo
		this.cursor = cursor.getNext();
 		return info;
	}

}
