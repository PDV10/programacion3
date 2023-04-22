package Tp1.ej4;

import Tp1.ej3.Pila;

public class ej4 {
	public static void main(String[] args) {
		Pila<String> lista = new Pila<>();
		
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
		lista.push("nodo 4");
		lista.push("nodo 5");
		lista.push("nodo 6");
		//lista.push("nodo push 3");
//		lista.extractFront();
//		lista.extractFront();
//		lista.extractFront();
		
//		lista.top();
		//System.out.println(lista.get(0));
	//	lista.imprimir();
	//	System.out.println("Lista invertida: ");
	//	lista.reverse();
		
		System.out.println(lista.indexOf("nodo 9"));
		
		lista.imprimir(); 
	}
}
