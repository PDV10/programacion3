package Tp1.ej6;

import java.util.Iterator;

import Tp1.MySimpleLinkedList;
import Tp1.Node;
import Tp1.ej3.Pila;
import Tp1.ej5.MySimpleLinkedListIterable;

public class ej6<T> {
	public static void main(String[] args) {
		MySimpleLinkedListIterable<Integer> lista = new MySimpleLinkedListIterable<>();
		MySimpleLinkedListIterable<Integer> lista2 = new MySimpleLinkedListIterable<>();
		
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
		
		lista.insertFront(100);
		lista.insertFront(68);
		lista.insertFront(48);
		lista.insertFront(11);
		lista.insertFront(10);
//		
//		lista2.insertFront(4);
//		lista2.insertFront(10);
//		lista2.insertFront(47);
//		lista2.insertFront(48);
//		lista2.insertFront(62);

//		lista.insertarOrdenado(3); 
//		lista.insertarOrdenado(8);
//		lista.insertarOrdenado(2);
//	    lista.insertarOrdenado(7);
//		lista.insertarOrdenado(9);

		System.out.println(lista);
//		System.out.println(lista2);
//		System.out.println(listaEnComunOrdenada(lista,lista2));
		//System.out.println(compararListasOrdenadas(lista,lista2));
		//System.out.println(lista.obtnerMayorActual());
	}
	
	//MAL es O(n^2)
//	public static <T> MySimpleLinkedList<T> compararListas(MySimpleLinkedListIterable<Integer> lista,MySimpleLinkedListIterable<Integer> lista2){
//		MySimpleLinkedList<Integer> listaFinal = new MySimpleLinkedList<>();
//		
//		for (int i = 0; i < lista.size; i++) {
//			for (int j = 0; j < lista2.size; j++) {
//				if(lista.get(i) == lista2.get(j)) {
//					//listaFinal.insertFront(lista.get(i));
//				}
//			}
//		}
//		
//		//ordenarLista(listaFinal); 
//		return (MySimpleLinkedList<T>) listaFinal;
//	}
//	
//	
	// solucion con iterator 
	public static <T> MySimpleLinkedListIterable<Integer> compararListasOrdenadas(MySimpleLinkedList<Integer> lista1,MySimpleLinkedListIterable<Integer> lista2){
		MySimpleLinkedListIterable<Integer> listaFinal = new MySimpleLinkedListIterable<>();
		
		Iterator<Integer> it1 = lista1.iterator();
		Iterator<Integer> it2 = lista2.iterator();
		int i =0;
		
		while(it1.hasNext() && it2.hasNext()) {
			if(it1.valor() > it2.valor()) {
				it1.next();
			}
			
			else if(it2.valor() > it1.valor()) {
				it2.next();
			}
			
			else if(it1.valor() == it2.valor()) {
				listaFinal.insertFront(it1.valor());
				it1.next();
				it2.next();
			}
		}
			
		
		return listaFinal;
	}

	
	// solucion con iterator con listas desordenadas
		public static <T> MySimpleLinkedListIterable<Integer> listaEnComunOrdenada(MySimpleLinkedListIterable<Integer> lista1,MySimpleLinkedListIterable<Integer> lista2){
			MySimpleLinkedListIterable<Integer> listaFinal = new MySimpleLinkedListIterable<>();
			
			for (int i = 0; i < lista1.size; i++) {
				for (int j = 0; j < lista2.size; j++) {
					System.out.println(lista1.get(i));
					
					if(lista1.get(i) == lista2.get(i)) {
						System.out.println("asd");
						//listaFinal.insertarOrdenado(lista1.get(i));
					}
				}
			}
			
			return listaFinal;
		}

}
