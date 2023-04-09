package Tp1.ej3;

import Tp1.MySimpleLinkedList;
import Tp1.Node;

public class Pila<T> {
	private MySimpleLinkedList<T> lista = null;

	public Pila() {
	
		lista = new MySimpleLinkedList<T>();
	}

	//------------------------- trabajado a nivel lista ---------------------------------------
	
	public void reverse() {
		MySimpleLinkedList<T> listaInvertida = new MySimpleLinkedList<T>();
        while (!lista.isEmpty()) {
            T dato = (T) lista.extractFront();
            listaInvertida.insertFront(dato);
        }
        lista = listaInvertida;
    }
	//-----------------------------------------------------------------------------------------
	
	public void push(T o) {
		this.lista.insertFront(o);
	}
	
	public void pop() {
		this.lista.extractFront();
	}

	public T top() {
		return this.lista.get(0);
	}

	public boolean isEmpty() {
		return this.lista.isEmpty();
	}
	
	public int indexOf(T valor) {
		return this.lista.indexOF(valor);
	}

	public int getSize() {
		return this.lista.getSize();
	}

	public void imprimir() {
		System.out.println(this.lista);
	}
}
