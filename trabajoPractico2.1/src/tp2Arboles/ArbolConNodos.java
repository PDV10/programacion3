package tp2Arboles;

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
//------------------------------ HAS ELEMENT ----------------------------------------------
	
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
	//----------------------------- GET FRONTERA SUPERIORES A UN VALOR-------------------------------------------	
		
	public ArrayList<Integer> getFrontera(int valor) { 
		ArrayList<Integer> hojas = new ArrayList<>();
		if(valor >= this.raiz.getValor()) {
			
			if(this.raiz != null && this.raiz.esHoja() && this.raiz.getValor() == valor) {
				hojas.add(this.raiz.getValor());
				return hojas;
			}else {
				hojas.addAll(getFrontera(this.raiz.getNodoDerecho(),valor));	
			}
		}
		return hojas;
	}
		
	private ArrayList<Integer> getFrontera(Nodo nodo,int valor) {
		ArrayList<Integer> hojas = new ArrayList<>();
		if(nodo.esHoja() && valor >= nodo.getValor()) {
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
	
// ------------------------------- GET MIN ELEMENT ------------------------------------------------
	
	
		public int getMinElement() {
			if(this.raiz.esHoja()) {
				return this.raiz.getValor();
			}else{
				 return getMinElement(this.raiz.getNodoIzquierdo());
			}
		}

		private int getMinElement(Nodo nodo) {
			if(nodo.esHoja() || (nodo.getNodoIzquierdo() == null && nodo.getNodoDerecho() != null)) {
				return nodo.getValor();			
			}
			return getMinElement(nodo.getNodoIzquierdo());
		}
		
	
// ------------------------------- DELETE MAX ELEMENT ------------------------------------------------
	
	private void deleteMaxElementSubIzq(Nodo nodo, int valor) {
		if(valor < nodo.getValor() ) {
			deleteMaxElementSubIzq(nodo.getNodoIzquierdo(), valor);
		}
		
		if(valor > nodo.getValor()) {
			deleteMaxElementSubIzq(nodo.getNodoDerecho(), valor);		
		}
		if(valor == nodo.getValor()) {
			if(nodo.getNodoIzquierdo().getNodoDerecho().esHoja()) {
				nodo.getNodoIzquierdo().setNodoDerecho(null);
			}else {
				deleteMaxElementSubIzq(nodo.getNodoDerecho(), valor);
			}
		}
	}
// ------------------------------- GET HEIGHT  ------------------------------------------------
	
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
						if(nodo.getNodoIzquierdo().getNodoIzquierdo() != null && nodo.getNodoIzquierdo().getNodoDerecho() == null) {
							if(nodo.getNodoIzquierdo().getNodoIzquierdo().esHoja()) {
								nodo.setNodoIzquierdo(nodo.getNodoIzquierdo().getNodoIzquierdo());
								return true;
							}							
						}
						
						if(nodo.getNodoIzquierdo().getNodoIzquierdo() == null && nodo.getNodoDerecho().getNodoDerecho() != null) {
							nodo.setNodoIzquierdo(nodo.getNodoIzquierdo().getNodoDerecho());
							return true;
						}
						
						if(nodo.getNodoIzquierdo().getNodoDerecho() != null) {
							if(nodo.getNodoIzquierdo().getNodoDerecho().esHoja() ) {
								if(nodo.getNodoIzquierdo().getNodoIzquierdo() == null) {
									nodo.setNodoIzquierdo(nodo.getNodoIzquierdo().getNodoDerecho());									
								}else {
									// al ultimo nodo derecho le seteo el ultimo nodo izquierdo
									nodo.getNodoIzquierdo().getNodoDerecho().setNodoIzquierdo(nodo.getNodoIzquierdo().getNodoIzquierdo());
									// al nodo anterior al nodo a borrar le seteo el ultimo nodo mas derecho
									nodo.setNodoIzquierdo(nodo.getNodoIzquierdo().getNodoDerecho());
								}
								return true;
							}
						}
						if(nodo.getNodoIzquierdo().getNodoDerecho() == null || !nodo.getNodoIzquierdo().getNodoDerecho().esHoja() ){
							int MayorDerecho = getMaxElement(nodo.getNodoIzquierdo().getNodoIzquierdo());
							//nodo mas derecho sub izquierdo 
							Nodo nmdsi = new Nodo(MayorDerecho);
							nmdsi.setNodoIzquierdo(nodo.getNodoIzquierdo().getNodoIzquierdo());
							nmdsi.setNodoDerecho(nodo.getNodoIzquierdo().getNodoDerecho());
							//elimino el nmdsi para que no quede duplicado
							deleteMaxElementSubIzq(this.raiz.getNodoIzquierdo(),valor);
							nodo.setNodoIzquierdo(nmdsi);
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
						if(nodo.getNodoDerecho().getNodoIzquierdo() != null && nodo.getNodoDerecho().getNodoDerecho() == null) {
							if(nodo.getNodoIzquierdo().getNodoIzquierdo().esHoja()) {
								nodo.setNodoIzquierdo(nodo.getNodoIzquierdo().getNodoIzquierdo());
								return true;
							}							
						}
						if(nodo.getNodoDerecho().getNodoIzquierdo() == null && nodo.getNodoDerecho().getNodoDerecho() != null) {
							nodo.setNodoDerecho(nodo.getNodoDerecho().getNodoDerecho());
							return true;
						}
						
						if(nodo.getNodoDerecho().getNodoDerecho() != null) {
							if(nodo.getNodoDerecho().getNodoDerecho().esHoja()) {
								if(nodo.getNodoDerecho().getNodoIzquierdo() == null) {
									nodo.setNodoIzquierdo(nodo.getNodoDerecho().getNodoDerecho());									
								}else {
									// al ultimo nodo derecho le seteo el ultimo nodo izquierdo
									nodo.getNodoDerecho().getNodoDerecho().setNodoIzquierdo(nodo.getNodoDerecho().getNodoIzquierdo());
									// al nodo anterior al nodo a borrar le seteo el ultimo nodo mas derecho
									nodo.setNodoDerecho(nodo.getNodoDerecho().getNodoDerecho());
								}
								return true;
							}
							if(nodo.getNodoDerecho().getNodoDerecho() == null || !nodo.getNodoDerecho().getNodoDerecho().esHoja() ){
								int MayorDerecho = getMaxElement(nodo.getNodoDerecho().getNodoIzquierdo());
								//nodo mas derecho sub izquierdo 
								Nodo nmdsi = new Nodo(MayorDerecho);
								nmdsi.setNodoIzquierdo(nodo.getNodoDerecho().getNodoIzquierdo());
								nmdsi.setNodoDerecho(nodo.getNodoDerecho().getNodoDerecho());

								deleteMaxElementSubIzq(this.raiz.getNodoDerecho(),valor);
								nodo.setNodoDerecho(nmdsi);
								return true;									
							}
						}
					}
				}else {
					 delete(nodo.getNodoDerecho(), valor);
				}
			}
		}	
		return false;
	}
	
	//------------------------------- GET SUMA DE NODOS INTERNOS ------------------------------------------------
	
		public int getSumaInternos() {
			int total = 0;
			if(this.raiz.esHoja() || this.raiz == null) {
				return total;
			}else{
				total += getSumaInternos(this.raiz, total);
			}
			return total;
		}

		private int getSumaInternos(Nodo nodo, int total) {	
			if(!nodo.esHoja()) {
				 total += nodo.getValor();
			}
			
			if(nodo.getNodoIzquierdo() != null) {
				total = getSumaInternos(nodo.getNodoIzquierdo(),total);
			}
			
			if(nodo.getNodoDerecho() != null) {
				total = getSumaInternos(nodo.getNodoDerecho(),total);
			}
				
			return total;
		}
		
		
}



	
