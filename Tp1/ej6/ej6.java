package Tp1.ej6;

import Tp1.MySimpleLinkedList;
import Tp1.Node;
import Tp1.ej3.Pila;

public class ej6 {
	public static void main(String[] args) {
		MySimpleLinkedList<Integer> lista = new MySimpleLinkedList<>();
		MySimpleLinkedList<Integer> lista2 = new MySimpleLinkedList<>();
		
		
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
		lista.insertFront(4);
		lista.insertFront(3);
		lista.insertFront(5);
		
		lista2.insertFront(4);
		lista2.insertFront(5);
		lista2.insertFront(7);
		lista2.insertFront(8);
		lista2.insertFront(3);
		
//		lista.top();
		//System.out.println(lista.get(0));
	//	lista.imprimir();
	//	System.out.println("Lista invertida: ");
	//	lista.reverse();
		System.out.println(compararListas(lista,lista2));
	//	System.out.println(lista.indexOf("nodo 9"));
	
	}
	
	//MAL
	public static <T> MySimpleLinkedList<T> compararListas(MySimpleLinkedList<T> lista1,MySimpleLinkedList<T> lista2){
		MySimpleLinkedList<Integer> listaFinal = new MySimpleLinkedList<>();
		
		for (int i = 0; i < lista1.size; i++) {
			for (int j = 0; j < lista2.size; j++) {
				if(lista1.get(i) == lista2.get(j)) {
					listaFinal.insertFront(lista1.get(i));
				}
			}
		}
		
		//ordenarLista(listaFinal); 
		return listaFinal;
	}

//	private static void ordenarLista(MySimpleLinkedList<Integer> listaFinal) {
//		Node aux = listaFinal.first;
//		int mayor;
//		while(aux != null ){
//			if(aux.getInfo() != 3) {
//				
//			}
//			aux = aux.getNext();
//		}
//	}
}
