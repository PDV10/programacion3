package Tp1.ej5;

import java.util.Iterator;


public class mainEj5 {
	public static void main(String[] args) {
		MySimpleLinkedListIterable<Integer> lista = new MySimpleLinkedListIterable<>();
		
		
//		NodePila nodo = new NodePila<>();
//		NodePila nodo1 = new NodePila<>();
//		NodePila nodo2 = new NodePila<>();
		
//		NodePila nodoPila = new NodePila<>();
		
//		nodo.setInfo("nodo 1");
//		nodo1.setInfo("nodo 2");
//		nodo2.setInfo("nodo 3");
//		nodoPila.setInfo("nodo Pila");

//		nodo.setNext(nodo1);
//		nodo1.setNext(nodo2);
		
//		lista.insertFront("nodo 3");
//		lista.insertFront("nodo 2");
//		lista.insertFront("nodo 1");
//		lista.insertFront("nodo 3");
//		lista.insertFront("nodo 5");
//		lista.insertFront("nodo 4");
//		lista.insertFront("nodo 6");
//		
//		lista2.insertFront("nodo 1");
//		lista2.insertFront("nodo 2");
//		lista2.insertFront("nodo 5");
//		lista2.insertFront("nodo 4");
//		lista2.insertFront("nodo 36");
		
		lista.insertFront(1);
		lista.insertFront(2);
		lista.insertFront(3);
		lista.insertFront(4);
		lista.insertFront(5);
	
		System.out.println(lista);
		
		Iterator<Integer> iterador = lista.iterator();
		while(iterador.hasNext()) {
			System.out.println(" - " + iterador.next() + " - ");
		}
	}
}
