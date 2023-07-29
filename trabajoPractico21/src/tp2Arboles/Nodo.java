package tp2Arboles;

public class Nodo {
	private int valor;
	private Nodo nodoIzquierdo;
	private Nodo nodoDerecho;
	
	public Nodo(int valor) {
		this.valor = valor;
		this.nodoDerecho = null;
		this.nodoIzquierdo = null;
	}

	public Nodo() {
		this.nodoDerecho = null;
		this.nodoIzquierdo = null;
	}
	
	public void addNodo(int nuevoValor) { // add a nivel de nodo, (suponiendo que ya existe una raiz seteada)
		if(this.valor > nuevoValor) {
			if(this.nodoIzquierdo == null) {
				this.nodoIzquierdo = new Nodo(nuevoValor);
			}else {
				this.nodoIzquierdo.addNodo(nuevoValor);
			}
		}else if(this.valor < nuevoValor){
			if(this.nodoDerecho == null) {
				this.nodoDerecho = new Nodo(nuevoValor);
			}else {
				this.nodoDerecho.addNodo(nuevoValor);
			}
		}
	}
	
	public boolean isEmpty() {	
		return this == null;
	}
	
	public int getValor() {
		return valor;
	}

	public void setValor(int valor) {
		this.valor = valor;
	}

	public Nodo getNodoIzquierdo() {
		return nodoIzquierdo;
	}
	
	public Integer getValorNodoIzquierdo() {
		return nodoIzquierdo.getValor();
	}

	public void setNodoIzquierdo(Nodo nodoIzquierdo) {
		this.nodoIzquierdo = nodoIzquierdo;
	}

	public Nodo getNodoDerecho() {
		return nodoDerecho;
	}

	public void setNodoDerecho(Nodo nodoDerecho) {
		this.nodoDerecho = nodoDerecho;
	}

	public void printInOrder(Nodo nodo) { 
		if (nodo == null) {
			return; 			
		}
		printInOrder(nodo.getNodoIzquierdo()); 
		
		System.out.print(nodo.getValor() + " "); 
		
		printInOrder(nodo.getNodoDerecho()); 
	} 
	
	public void printPreOrder(Nodo nodo) { 
		if (nodo == null) {
			return; 			
		}
		System.out.print(nodo.getValor() + " "); 

		printPreOrder(nodo.getNodoIzquierdo()); 
		if(nodo.getNodoIzquierdo() == null) {
			System.out.print(" - ");
		}
		
		printPreOrder(nodo.getNodoDerecho()); 
		
		if(nodo.getNodoDerecho() == null) {
			System.out.print(" - ");
		}
		
	} 
	
	public void printPostOrder(Nodo nodo) { 
		if (nodo == null) {
			return; 			
		}
		printPostOrder(nodo.getNodoIzquierdo()); 
		
		printPostOrder(nodo.getNodoDerecho()); 
		
		System.out.print(nodo.getValor() + " "); 
	} 
	
	public boolean esHoja() {
		return this.getNodoIzquierdo() == null && this.getNodoDerecho() == null;
	}
}
