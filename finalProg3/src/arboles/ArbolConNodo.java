package arboles;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Collection;

public class ArbolConNodo {

	private Nodo raiz;
	
	public ArbolConNodo() {
		this.raiz = null;
	}
	
	public void add(int valor) {
		if(this.raiz == null){
			raiz = new Nodo(valor);
		}else {
			this.add(raiz,valor);
		}
	}
	
	private void add(Nodo raiz, int valor) {
		if(valor < raiz.getValor()) {
			if(raiz.getNodoIzquierdo() == null) {
				Nodo aux = new Nodo(valor);
				raiz.setNodoIzquierdo(aux);				
			}else {
				this.add(raiz.getNodoIzquierdo(),valor);				
			}
		}else if(valor > raiz.getValor()) {
			if(raiz.getNodoDerecho() == null) {
				Nodo aux = new Nodo(valor);
				raiz.setNodoDerecho(aux);
			}else {				
				this.add(raiz.getNodoDerecho(), valor);
			}
		}
	}

/*---------------------------------------- Mostrar Arbol ---------------------------------------------------------*/
	
	public void printInOrden(){
		if(this.raiz != null) {
			this.raiz.printInOrden(this.raiz);
		}	
	}
	
	public void printPreOrden(){
		if(this.raiz != null) {
			this.raiz.printPreOrden(this.raiz);
		}	
	}
	
	public void printPostOrden(){
		if(this.raiz != null) {
			this.raiz.printPostOrden(this.raiz);
		}	
	}
	
/* --------------------------------------- GET RAIZ ---------------------------------------------------------------*/
	// Retorna valor de la raiz si es que existe
	public Integer getRaiz() {
		if(this.raiz.getValor() != null) {
			return this.raiz.getValor();			
		}else {
			return null;
		}
	}

/* --------------------------------------- HAZ ELEMENT ------------------------------------------------------------*/
	// retorna si un valor existe o no en el arbol
	
	public boolean hasElem(int valor) {
		if(this.raiz == null) {
			return false;
		}
		else {
			return hasElem(this.raiz,valor);
		}
	}

	private boolean hasElem(Nodo raiz, int valor) {
		
		if(raiz != null) {
			if(raiz.getValor() == valor) {
				return true;
			}
			else if(valor < this.raiz.getValor()) {
				return hasElem(raiz.getNodoIzquierdo(),valor);
			}
			else if(valor > this.raiz.getValor()){
				return hasElem(raiz.getNodoDerecho(),valor);
			}
		}
		return false;
	}			
	
	public boolean isEmpty() {
		return this.raiz == null;
	}
	

/* --------------------------------------- GET HEIGHT -------------------------------------------------------------*/
	public int getHeight() {
		
		if(this.raiz == null) {
			return -1;
		}else {
			return getHeight(this.raiz);	
		}
	}

	private int getHeight(Nodo raiz) {
		int alturaIzq = 0;
		int alturaDer = 0;
		if(raiz != null) {
			if(raiz.getNodoIzquierdo() != null) {				
				alturaIzq = getHeight(raiz.getNodoIzquierdo());
				alturaIzq++;
			}
			if(raiz.getNodoDerecho() != null) {
				alturaDer = getHeight(raiz.getNodoDerecho());
				alturaDer++;
			}
		}
		if(alturaIzq > alturaDer) {
			return alturaIzq;
		}else {
			return alturaDer;
		}
	}
/* --------------------------------------- GET LONGEST BRANCH -------------------------------------------------------------*/	
	public ArrayList<Integer> getLongestBranch(){
		if(this.raiz == null) {
			return new ArrayList<>();
		}else {
			return getLongestBranch(this.raiz);
		}
	}

	private ArrayList<Integer> getLongestBranch(Nodo raiz) {
		ArrayList<Integer> lista = new ArrayList<>();
		ArrayList<Integer> lista2 = new ArrayList<>();
		
		lista.add(raiz.getValor());
		lista2.add(raiz.getValor());
		
		if(raiz.getNodoIzquierdo() != null) {
			lista.addAll(getLongestBranch(raiz.getNodoIzquierdo()));
		}
		if(raiz.getNodoDerecho() != null) {
			lista2.addAll(getLongestBranch(raiz.getNodoDerecho()));
		}
		
		if(lista.size() > lista2.size()) {
			return lista;
		}else {
			return lista2;
		}
	}	
	
/*---------------------------------- GET FRONTERA -------------------------------------------------*/
	public ArrayList<Integer> getFrontera(){
		ArrayList<Integer> hojas = new ArrayList<>();
		if(this.raiz == null) {
			return hojas;
		}else if (this.raiz.esHoja()) {
			hojas.add(this.raiz.getValor());
		}else {
			hojas.addAll(getFrontera(this.raiz));
		}
		return hojas;
	}

	private ArrayList<Integer> getFrontera(Nodo raiz) {
		ArrayList<Integer> hojas = new ArrayList<>();
		
		if(raiz.esHoja()) {
			hojas.add(raiz.getValor());
		}else {	
			if(raiz.getNodoIzquierdo() != null) {
				hojas.addAll(getFrontera(raiz.getNodoIzquierdo()));
			}
			if(raiz.getNodoDerecho() != null){
				hojas.addAll(getFrontera(raiz.getNodoDerecho()));
			}
		}
		
		return hojas;
	}
	
/*---------------------------------- GET MAX ELEM -------------------------------------------------*/
	
	public int getMaxElem(){
		if(this.raiz.esHoja()) {
			return this.raiz.getValor();
		}else {
			return getMaxElem(this.raiz);
		}
	}

	private int getMaxElem(Nodo raiz) {
		
		if(raiz.esHoja() || !raiz.esHoja() && raiz.getNodoIzquierdo() != null && raiz.getNodoDerecho() == null ) {
			return raiz.getValor();
		}
						
		return getMaxElem(raiz.getNodoDerecho());
		
	}
	
/*---------------------------------- ELEMS AT LEVEL -------------------------------------------------*/
	
	public ArrayList<Integer> elemsAtLevel(int nivel){
		ArrayList<Integer> nodos = new ArrayList<>();
		
 		if(this.raiz != null) {
			 if(nivel == 0){
				 nodos.add(this.raiz.getValor());
			 }else {
				 nodos = elemsAtLevel(this.raiz, nivel, 0);
			 }
		}
		return nodos;
	}

	private ArrayList<Integer> elemsAtLevel(Nodo raiz, int nivel,int nivelActual) {
		ArrayList<Integer> nodos = new ArrayList<>();
		
		
		if(nivelActual == nivel) {
			nodos.add(raiz.getValor());
		}
		
		if(raiz.getNodoIzquierdo() != null){
			nodos.addAll(elemsAtLevel(raiz.getNodoIzquierdo(), nivel,nivelActual+1));			
		}
		if(raiz.getNodoDerecho() != null) {
			nodos.addAll(elemsAtLevel(raiz.getNodoDerecho(), nivel,nivelActual+1));	
		}
		
		return nodos;
	}
	
/*----------------------------------------------- SUMA  ---------------------------------------------------------------------*/	
	
	public int suma() {
		int total = 0;
		if(this.raiz == null) {
			return total;
		}else {
			total = this.raiz.suma();
			
		}
		return total;
	}
	
/*------------------------------------------ HOJAS MAYORES QUE K ----------------------------------------------------------------*/	
	
	public ArrayList<Integer> HojasMayores(int k) {
		ArrayList<Integer> hojas= new ArrayList<>();
		if(this.raiz == null) {
			return hojas;
		}
		else if(this.raiz.esHoja()) {
			if(this.raiz.getValor() > k) {
				hojas.add(this.getRaiz());				
			}
		}else {
			hojas = HojasMayores(this.raiz,k);
		}
		
		return hojas;
	}

	private ArrayList<Integer> HojasMayores(Nodo raiz, int k) {
		ArrayList<Integer> hojas= new ArrayList<>();
		if( raiz != null) {			
			if(raiz.esHoja()) {
				if(raiz.getValor() > k) {
					hojas.add(raiz.getValor());
				}
			}else {
				hojas.addAll(HojasMayores(raiz.getNodoIzquierdo(),k));
	
				hojas.addAll(HojasMayores(raiz.getNodoDerecho(),k));
			}
		}
		return hojas;
	}
/*------------------------------------------ RESTA CON SUCESOR NO SUPERA K ----------------------------------------------------------------*/	
	
	public boolean superaK (int k) {
		if(this.raiz == null) {
			return false;
		}
		else if(this.raiz.esHoja()) {
			return this.raiz.getValor() > k;
		}else {
			return superaK(this.raiz, k);
		}
		
	}

	private boolean superaK(Nodo raiz, int k) {
		if(raiz != null) {			
			if(raiz.getNodoIzquierdo() != null) {
				if(!raiz.getNodoIzquierdo().esHoja()) {
					if(raiz.getValor() - raiz.getNodoIzquierdo().getValor() > k) {
						System.out.println(k);
						System.out.println(raiz.getValor() - raiz.getNodoIzquierdo().getValor());
						return true;
					}else {
						return superaK(raiz.getNodoIzquierdo(), k);
					}
				}	
			}
			if(raiz.getNodoDerecho() != null) {
				if(!raiz.getNodoDerecho().esHoja()) {
					if(raiz.getValor() - raiz.getNodoDerecho().getValor() > k) {
						System.out.println(k);
						System.out.println(raiz.getValor() - raiz.getNodoDerecho().getValor());
						return true;
					}else {
						return superaK(raiz.getNodoDerecho(), k);
					}
				}
			}
		}
		return false;
	}
}