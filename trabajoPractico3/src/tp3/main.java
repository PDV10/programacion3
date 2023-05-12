package tp3;

public class main {
	public static <T> void main(String[] args) {
		GrafoDirigido<T> grafo = new GrafoDirigido<>();	
		
		grafo.agregarVertice(0);

		grafo.agregarVertice(10);
		
		grafo.agregarArco(0,10,null);
		
		System.out.println( grafo.existeArco(0, 10));
		
		grafo.borrarArco(0, 10);
		
		System.out.println( grafo.existeArco(0, 10));
		
	}
}
