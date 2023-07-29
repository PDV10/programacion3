package Tp1.ej7;

import Tp1.ej5.MySimpleLinkedListIterable;

public class ej7 {
	public static void main(String[] args) {
		MySimpleLinkedListIterable<Integer> lista = new MySimpleLinkedListIterable<>();
		MySimpleLinkedListIterable<Integer> lista2 = new MySimpleLinkedListIterable<>();
		
		lista.insertFront(4);
		lista.insertFront(100000);
		lista.insertFront(24);
		lista.insertFront(47);
		lista.insertFront(470000000);
		lista.insertFront(4700);
		lista.insertFront(470000);
		lista.insertFront(62090);
		
		lista2.insertFront(4);
		lista2.insertFront(11);
		lista2.insertFront(24);
		lista2.insertFront(47);
		lista2.insertFront(62);
		System.out.println("lista 1: ");
		System.out.println(lista);
		System.out.println("lista 2: ");
		System.out.println(lista2);
		
		System.out.println("elemento de lista 1 que no estan en lista 2: ");
		System.out.println(lista.ObtenerLista(lista, lista2));
	}
}
