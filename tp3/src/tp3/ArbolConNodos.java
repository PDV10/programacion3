package tp3;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class ArbolConNodos {
	public Nodo raiz = null;
	
	public ArbolConNodos(Nodo nodo) {
		this.raiz = nodo;
	}
	
	public ArbolConNodos() {
	}

	public Nodo getRaiz() {
		return raiz;
	}

	public void setRaiz(Nodo raiz) {
		this.raiz = raiz;
	}
	
	public void printInOrder() {
		if(this.raiz != null) {
			this.raiz.printInOrder(this.raiz);
		}
	}
	
	public void printPreOrder() {
		if(this.raiz != null) {
			this.raiz.printPreOrder(this.raiz);
		}
	}
	
	public void printPostOrder() {
		if(this.raiz != null) {
			this.raiz.printPostOrder(this.raiz);
		}
	}
	
	private void addNodo(Nodo raiz, int valor) {  //addnodo a nivel de arbol
		if(valor < raiz.getValor()){
			if(raiz.getNodoIzquierdo() == null){
				Nodo nuevo = new Nodo(valor);
				raiz.setNodoIzquierdo(nuevo);				
			}else {
				addNodo(raiz.getNodoIzquierdo(),valor);				
			}
		}else if(valor >= raiz.getValor()) {
			if(raiz.getNodoDerecho() == null) {
				Nodo nuevo = new Nodo(valor);
				raiz.setNodoDerecho(nuevo);					
			}else {
				addNodo(raiz.getNodoDerecho(),valor);				
			}
		}
	}
	
	public void addNodo(int valor) {
		if(this.raiz == null) {
			this.raiz = new Nodo(valor);
		}else {
			this.addNodo(this.raiz, valor);
		}
	}
	
	public Nodo getRoot() {
		if(this.raiz != null) {
			return this.raiz;
		}
		return null;
	}
	
	public boolean hasElem(int valor) {
		if(this.raiz == null) {
			return false;
		}else {
			return this.hasElem(this.raiz, valor);
		}
	}
	
	private boolean hasElem(Nodo raiz,int valor) {
		if(raiz != null) {
			if(raiz.getValor() == valor) {
				return true;
			}else {
				if(valor < raiz.getValor()) {
					return hasElem(raiz.getNodoIzquierdo(), valor);
				}else if(valor > raiz.getValor()) {
					return hasElem(raiz.getNodoDerecho(), valor);
				}
			}
		}
		return false;
	}

	private ArrayList<Integer> getFrontera(Nodo nodo) {
		ArrayList<Integer> hojas = new ArrayList<>();
		if(nodo.esHoja()) {
			hojas.add(nodo.getValor());	
		}else {
			if(nodo.getNodoIzquierdo() != null  ) {
				hojas.addAll(getFrontera(nodo.getNodoIzquierdo()));				
			}
			if(nodo.getNodoDerecho() != null ) {
				hojas.addAll(getFrontera(nodo.getNodoDerecho()));
			}
		}
		return hojas;
	}

	public ArrayList<Integer> getFrontera() { 
		ArrayList<Integer> hojas = new ArrayList<>();
	
		if(this.raiz != null && this.raiz.esHoja()) {
			hojas.add(this.raiz.getValor());
			return hojas;
		}else {
			hojas.addAll(getFrontera(this.raiz.getNodoIzquierdo()));
			
			hojas.addAll(getFrontera(this.raiz.getNodoDerecho()));	
		}
		return hojas;
	}
	
	public ArrayList<Integer> getLongestBranch(){
		ArrayList<Integer> lista = new ArrayList<>();
		ArrayList<Integer> aux = new ArrayList<>();
		
		if(this.raiz != null && this.raiz.esHoja()) {
			return lista;
		}else {
			lista.add(this.raiz.getValor());
			aux.add(this.raiz.getValor());
			lista = getLongestBranch(this.raiz.getNodoIzquierdo(), lista);
			aux = getLongestBranch(this.raiz.getNodoDerecho(), aux);
		}
		if(lista.size() >= aux.size()) {
			return lista;
		}else {
			return aux;
		}
	}
	
	private ArrayList<Integer> getLongestBranch(Nodo nodo, ArrayList<Integer> lista) {
		ArrayList<Integer> listaIzq = new ArrayList<>();
		ArrayList<Integer> listaDer = new ArrayList<>();
		
		if(nodo.getNodoIzquierdo() != null || nodo.getNodoDerecho() != null || nodo.esHoja()) {
			lista.add(nodo.getValor());
		}
		
		if(nodo.getNodoIzquierdo() != null && nodo.getNodoDerecho() == null) {
			listaIzq.addAll(getLongestBranch(nodo.getNodoIzquierdo(), lista));
		}
		if(nodo.getNodoIzquierdo() == null && nodo.getNodoDerecho() != null) {
		  listaDer.addAll(getLongestBranch(nodo.getNodoDerecho(), lista));
		}
		if(nodo.getNodoIzquierdo() != null && nodo.getNodoDerecho() != null) {
			ArrayList<Integer> aux1 = new ArrayList<>();
			ArrayList<Integer> aux2 = new ArrayList<>();
			listaIzq.addAll(getLongestBranch(nodo.getNodoIzquierdo(), aux1));
			listaDer.addAll(getLongestBranch(nodo.getNodoDerecho(), aux2));
			if(listaIzq.size() > listaDer.size()) {
				lista.addAll(listaIzq);
			}else {
				lista.addAll(listaDer);
			}
		}
		return lista;
	}
}

