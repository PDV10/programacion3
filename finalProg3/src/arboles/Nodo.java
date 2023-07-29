package arboles;

public class Nodo {

	private Integer valor;
	private Nodo left;
	private Nodo right;

	public Nodo(Integer value) {
		this.valor = value;
		this.left = null;
		this.right = null;
	}

	public Nodo getNodoIzquierdo() {
		return left;
	}

	public void setNodoIzquierdo(Nodo left) {
		this.left = left;
	}

	public Nodo getNodoDerecho() {
		return right;
	}

	public void setNodoDerecho(Nodo right) {
		this.right = right;
	}

	public Integer getValor() {
		return valor;
	}

	public void printInOrden(Nodo raiz) {
		
		if(raiz == null) {
			return;
		}
		
		printInOrden(raiz.getNodoIzquierdo());
		
		System.out.print(raiz.getValor() + " ");
		
		printInOrden(raiz.getNodoDerecho());	
	}
	
	public void printPreOrden(Nodo raiz) {
			
			if(raiz == null) {
				return;
			}

			System.out.print(raiz.getValor() + " ");
		
			printInOrden(raiz.getNodoIzquierdo());
			
			printInOrden(raiz.getNodoDerecho());	
		}

	public void printPostOrden(Nodo raiz) {
		
		if(raiz == null) {
			return;
		}

		printInOrden(raiz.getNodoIzquierdo());
				
		printInOrden(raiz.getNodoDerecho());	
		
		System.out.print(raiz.getValor() + " ");
	}
	
/* --------------------------------------- ES HOJA ------------------------------------------------------------*/
	public boolean esHoja() {
		return this.getNodoIzquierdo() == null && this.getNodoDerecho() == null;
	}

	public int suma() {
		int total = this.getValor();
		if(this.getNodoIzquierdo() != null) {
			total += this.getNodoIzquierdo().suma();
		}
		if(this.getNodoDerecho() != null) {
			total+= this.getNodoDerecho().suma();
		}
		return total;
	}
	
}
