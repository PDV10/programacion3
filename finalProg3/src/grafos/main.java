package grafos;

import java.util.Iterator;

public class main {
	public static <T> void main(String[] args) {
		GrafoDirigido<T> grafo = new GrafoDirigido<>();
		
		grafo.agregarVertice(15);
		grafo.agregarVertice(10);
		grafo.agregarVertice(20);
		grafo.agregarVertice(5);
		
		
		
		
		
/*--------------------------------- OBTENER VERTICES ----------------------------------------*/	
		Iterator<Integer> vertices = grafo.obtenerVertices();
		while (vertices.hasNext()) {
			int vertice = vertices.next();
			System.out.print(vertice + "-");
		
		}
		System.out.println("\n");
/*--------------------------------- CANTIDAD DE VERTICES ----------------------------------------*/	
		System.out.println("\n"+grafo.cantidadVertices());
		
	}
}
