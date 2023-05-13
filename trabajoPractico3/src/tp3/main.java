package tp3;

import java.util.Iterator;

public class main {
	public static <T> void main(String[] args) {
		GrafoDirigido<T> grafo = new GrafoDirigido<>();	
	
		grafo.agregarVertice(0);
		grafo.agregarVertice(10);
		grafo.agregarVertice(11);
		grafo.agregarVertice(12);
		grafo.agregarVertice(13);
		grafo.agregarVertice(14);
		
		grafo.agregarArco(0,10,null);
		grafo.agregarArco(0,11,null);
		grafo.agregarArco(12,13,null);
		grafo.agregarArco(12,14,null);
		
//		System.out.println( grafo.existeArco(0, 10));
		

//		System.out.println(grafo.obtenerArco(0, 10));
//		System.out.println( grafo.existeArco(0, 10));
//		System.out.println( grafo.existeArco(0, 11));
//		System.out.println( grafo.existeArco(12, 13));
//		System.out.println( grafo.existeArco(12, 14));
//		System.out.println(grafo.cantidadVertices());
		System.out.println(grafo.cantidadArcos());
//		grafo.borrarArco(0, 10);
//		System.out.println(grafo.cantidadArcos());
//		
//		Iterator<Integer> adyacentes = grafo.obtenerAdyacentes(12);
//		while(adyacentes.hasNext()) {
//			System.out.println(adyacentes.next());
//		}
		
		Iterator<Integer> vertices = grafo.obtenerVertices();
		while(vertices.hasNext()) {
			System.out.println(vertices.next());
		}
	
//		Iterator<Arco<T>> arcos = grafo.obtenerArcos();
//		Iterator<Arco<T>> arcosDeVertice = grafo.obtenerArcos(0);
//		
	}
}
