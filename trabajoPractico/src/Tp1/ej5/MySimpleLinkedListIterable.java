package Tp1.ej5;

import java.util.Iterator;

import Tp1.Node;

public class MySimpleLinkedListIterable<T> {
	public Node<T> first;
	public int size;

	public MySimpleLinkedListIterable() {
		this.first = null;
		this.size = 0;
	}
	
	public void insertarOrdenado(T valor) {
		Node<T> aux = this.first;
		
		if(aux == null) { 
			this.first = new Node<T>(valor,null);
		}else {
			while(aux.getNext() != null && (int) aux.getInfo() < (int) valor) {
				if((int) valor >= (int)aux.getInfo() && (int)valor <= (int)aux.getNext().getInfo()) {
					Node<T> siguiente = new Node<>(valor, aux.getNext());
					aux.setNext(siguiente);
				}
				aux = aux.getNext();
			}
			if((int) valor > (int)aux.getInfo()) {
				Node<T> ultimo = new Node<>(valor, null);
				aux.setNext(ultimo);
			}
			else if((int)aux.getInfo() > (int)valor) {
				Node<T> primero = new Node<>(valor,aux);
				this.first = primero;
				aux = this.first;
			}
		}		
	}
	
	public MySimpleLinkedListIterable<T> ObtenerLista(MySimpleLinkedListIterable<T> lista1, MySimpleLinkedListIterable<T> lista2){
		Node<T> NodoLista1 = lista1.first;
		Node<T> NodoLista2 = lista2.first;
		MySimpleLinkedListIterable<T> listaFinal = new MySimpleLinkedListIterable<>();
	
		//System.out.println(NodoLista1.getInfo());
		while(NodoLista1.getNext() != null) {
			while(NodoLista1.getNext() != null && NodoLista1.getInfo() != NodoLista2.getInfo() && NodoLista2.getNext() != null) {
					NodoLista2 = NodoLista2.getNext();
			}
			if(NodoLista1.getInfo() != NodoLista2.getInfo()) {
				listaFinal.insertarOrdenado(NodoLista1.getInfo());				
			}
			NodoLista1 = NodoLista1.getNext();
			NodoLista2 = lista2.first;	
		}
		return listaFinal;
	}

	public T obtnerMayorActual(MySimpleLinkedListIterable lista,int i) {
		return (T) lista.get(i);
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
	
}
