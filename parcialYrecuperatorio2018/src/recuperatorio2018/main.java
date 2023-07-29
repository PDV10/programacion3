package recuperatorio2018;

import java.util.ArrayList;
import java.util.Iterator;


public class main {
	public static <T> void main(String[] args) {
		GrafoDirigido<Integer> grafo = new GrafoDirigido<>();

		grafo.agregarVertice(5);
		grafo.agregarVertice(3);
		grafo.agregarVertice(8);
		grafo.agregarVertice(1);
		grafo.agregarVertice(4);
		grafo.agregarVertice(0);
		grafo.agregarVertice(2);
		grafo.agregarVertice(6);
		grafo.agregarVertice(7);
		grafo.agregarVertice(10);
		grafo.agregarVertice(11);
		grafo.agregarVertice(100);
		
		grafo.agregarArco(5,3,null);
		grafo.agregarArco(5,8,null);
		grafo.agregarArco(5,1,null);
		grafo.agregarArco(3,4,null);
		grafo.agregarArco(8,0,null);
		grafo.agregarArco(8,2,null);
		grafo.agregarArco(8,6,null);
		grafo.agregarArco(1,7,null);
		grafo.agregarArco(1,10,null);
		grafo.agregarArco(7,11,null);
		grafo.agregarArco(7,100,null);

//		ServicioDFS<T> service = new ServicioDFS<>(grafo);
//		System.out.println(service.dfsForest());

		servicioBFS serviceBFS = new servicioBFS(grafo);
		serviceBFS.bfsForest(3);
		System.out.println(serviceBFS.getSuma());
//		ServicioCaminos<T> caminos = new ServicioCaminos<>(grafo,3,1,5);
//		System.out.println(caminos.caminos());

//		System.out.println( grafo.existeArco(0, 10));


//		System.out.println(grafo.obtenerArco(0, 10));
//		System.out.println( grafo.existeArco(0, 10));
//		System.out.println( grafo.existeArco(0, 11));
//		System.out.println( grafo.existeArco(12, 13));
//		System.out.println( grafo.existeArco(12, 14));
//		System.out.println(grafo.cantidadVertices());
//		System.out.println(grafo.cantidadArcos());
//		grafo.borrarArco(0, 10);
//		System.out.println(grafo.cantidadArcos());
//		
//		Iterator<Integer> adyacentes = grafo.obtenerAdyacentes(12);
//		while(adyacentes.hasNext()) {
//			System.out.println(adyacentes.next());
//		}

//		Iterator<Integer> vertices = grafo.obtenerVertices();
//		while(vertices.hasNext()) {
//			System.out.println(vertices.next());
//		}

//		Iterator<Arco<T>> arcos = grafo.obtenerArcos();
//		Iterator<Arco<T>> arcosDeVertice = grafo.obtenerArcos(0);
//		
	}
}
