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

// -------------------------- PRINT IN ORDER ---------------------------------------------
	
	public void printInOrder() {
		if(this.raiz != null) {
			this.raiz.printInOrder(this.raiz);
		}
	}
	

// -------------------------- PRINT PRE ORDER ---------------------------------------------
	
	public void printPreOrder() {
		if(this.raiz != null) {
			this.raiz.printPreOrder(this.raiz);
		}
	}
	
// -------------------------- PRINT POST ORDER ---------------------------------------------
	
	public void printPostOrder() {
		if(this.raiz != null) {
			this.raiz.printPostOrder(this.raiz);
		}
	}
	
//---------------------------------- ADD NODO ---------------------------------------------	
	public void addNodo(int valor) {
		if(this.raiz == null) {
			this.raiz = new Nodo(valor);
		}else {
			this.addNodo(this.raiz, valor);
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
	

// ------------------------------ GET ROOT -------------------------------------------------
	public Nodo getRoot() {
		if(this.raiz != null) {
			return this.raiz;
		}
		return null;
	}
	
//------------------------------ HAS ELEMMENT ----------------------------------------------
	
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
	
//----------------------------- GET FRONTERA -------------------------------------------	
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

//----------------------------------- GET LONGEST BRANCH ------------------------------------	
	
	public ArrayList<Integer> getLongestBranch(){
		ArrayList<Integer> listaIzq = new ArrayList<>();
		ArrayList<Integer> listaDer = new ArrayList<>();
		
		if(this.raiz != null && this.raiz.esHoja()) {
			return listaIzq;
		}else {
			listaIzq.add(this.raiz.getValor());
			listaDer.add(this.raiz.getValor());
			listaIzq = getLongestBranch(this.raiz.getNodoIzquierdo(), listaIzq);
			listaDer = getLongestBranch(this.raiz.getNodoDerecho(), listaDer);
		}
		if(listaIzq.size() >= listaDer.size()) {
			return listaIzq;
		}else {
			return listaDer;
		}
	}
	
	private ArrayList<Integer> getLongestBranch(Nodo nodo, ArrayList<Integer> lista) {
		ArrayList<Integer> listaIzq = new ArrayList<>();
		ArrayList<Integer> listaDer = new ArrayList<>();
		
		lista.add(nodo.getValor());
		
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

// ------------------------------- GET MAX ELEMENT ------------------------------------------------
	
	
	public int getMaxElement() {
		if(this.raiz.esHoja()) {
			return this.raiz.getValor();
		}else{
			 return getMaxElement(this.raiz.getNodoDerecho());
		}
	}

	private int getMaxElement(Nodo nodo) {
		if(nodo.esHoja() || (nodo.getNodoIzquierdo() != null && nodo.getNodoDerecho() == null)) {
			return nodo.getValor();			
		}
		return getMaxElement(nodo.getNodoDerecho());
	}

// ------------------------------- GET HEIGHT MAL ------------------------------------------------
	
	/*
	 * forma muy rebuscada, posiblemente consuma muchos recursos
	 */
//	public int getHeight() {
//		int altura = -1;
//		if(this.raiz.esHoja()) {
//			return altura;
//		}else{
//			int alturaIzq = getHeight(this.raiz, altura);
//			int alturaDer = getHeight(this.raiz, altura);
//			if(alturaIzq >= alturaDer) {
//				altura = alturaIzq;
//			}else {
//				altura = alturaDer;
//			}
//		}
//		return altura;
//	}
//
//	private int getHeight(Nodo nodo, int altura) {
//		if(nodo.esHoja()) {
//			altura++;
//		}else {		
//			if(nodo.getNodoIzquierdo()!= null && nodo.getNodoDerecho() == null) {
//				return getHeight(nodo.getNodoIzquierdo(), altura+1);
//			}
//			if(nodo.getNodoIzquierdo()== null && nodo.getNodoDerecho() != null) {
//				return getHeight(nodo.getNodoDerecho(), altura+1);
//			}
//			if(nodo.getNodoIzquierdo()!= null && nodo.getNodoDerecho() != null){
//				int aux = getHeight(nodo.getNodoIzquierdo(),altura+1);
//				int aux2 = getHeight(nodo.getNodoDerecho(), altura+1);
//				if(aux>= aux2) {
//					altura = aux;
//				}else {
//					altura = aux2;
//				}
//			}
//		}
//		return altura;
//	}
	
// ------------------------------- GET HEIGHT BIEN ------------------------------------------------
	
	public int getHeight() {
		if(this.raiz.isEmpty()) {
			return -1;
		}else {
			return getHeight(this.raiz);
		}
	}

	private int getHeight(Nodo nodo) {
		int alturaIzq = 0;
		int alturaDer = 0;
		
		if(nodo.getNodoIzquierdo()!= null) {
			alturaIzq = getHeight(nodo.getNodoIzquierdo());
			alturaIzq++;
		}
		if(nodo.getNodoDerecho()!= null) {
			alturaDer = getHeight(nodo.getNodoDerecho());
			alturaDer++;
		}
		if(alturaIzq >= alturaDer) {
			return alturaIzq;
		}else {
			return alturaDer;
		}
	}
	
//------------------------------- GET ELEMENTS AT LEVEL -------------------------------------
	public ArrayList<Integer> getElementAtLevel(int nivelBuscado){
		ArrayList<Integer> lista = new ArrayList<>();
		if(this.raiz.isEmpty()) {
			return lista;
		}else if(this.raiz.esHoja()) {
			lista.add(this.raiz.getValor());
		}else {
			int nivelActual = 0;
			lista.addAll(getElementAtLevel(this.raiz, nivelActual, nivelBuscado));

		}
		return lista;
	}

	private ArrayList<Integer> getElementAtLevel(Nodo nodo, int nivelActual, int nivelBuscado) {
		ArrayList<Integer> lista = new ArrayList<>();
		if(nivelActual == nivelBuscado){
			lista.add(nodo.getValor());
		}
		
		if(nodo.getNodoIzquierdo() != null ) {
			lista.addAll(getElementAtLevel(nodo.getNodoIzquierdo(), nivelActual +1,nivelBuscado)) ;
		}
		if(nodo.getNodoDerecho() != null) {
			lista.addAll(getElementAtLevel(nodo.getNodoDerecho(), nivelActual +1,nivelBuscado));
		}

		
		return lista;
	}
 //------------------------ DELETE -------------------------------------------
	
	public boolean delete(int valor) {
		if(this.raiz == null){
			return false;
		} 
		if(this.raiz.getValor() == valor){
			if(this.raiz.esHoja()) {
				this.raiz = null;
				return true;
			}else {
				return false;
			}
		}
		return delete(this.raiz, valor);			
		
	}

	private boolean delete(Nodo nodo, int valor) {
		if(valor < nodo.getValor()) {
			if(nodo.getNodoIzquierdo() != null) {
				if(nodo.getNodoIzquierdo().getValor() == valor){
					if(nodo.getNodoIzquierdo().esHoja()){
						nodo.setNodoIzquierdo(null);
						return true;
					}else {
						if(nodo.getNodoIzquierdo().getNodoIzquierdo().esHoja()) {
							nodo.setNodoIzquierdo(nodo.getNodoIzquierdo().getNodoIzquierdo());
							return true;
						}
					}
				}else {
					 delete(nodo.getNodoIzquierdo(), valor);
				}
			}
		}
		
		if(valor > nodo.getValor()) {
			if(nodo.getNodoDerecho() != null) {
				if(nodo.getNodoDerecho().getValor() == valor){
					if(nodo.getNodoDerecho().esHoja()){
						nodo.setNodoDerecho(null);
						return true;
					}else {
						if(nodo.getNodoDerecho().getNodoDerecho().esHoja()) {
							nodo.setNodoDerecho(nodo.getNodoDerecho().getNodoDerecho());
							return true;
						}
					}
				}else {
					 delete(nodo.getNodoDerecho(), valor);
				}
				
				// parte izquierda
			}
		}	
		return false;
	}

}


