package recuperatorio2018;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;



public class servicioBFS {
	// asumimos que se marcan todos los vertices como no visitados con un boolean false de manera global
	// y se llama a bfs forest con el primer vertice que encuentra no visitado del grafo
	// asumimos que el servicio recibe un grafo dirigidos de enteros 
	// y recibimos un entero "nivel " que indica en que nivel hay que sumar los elementos
	
	public ArrayList<Integer> fila = new ArrayList<>();
	private Map<Integer,Boolean> vertices;
	private Grafo<Integer> grafo = new GrafoDirigido<>();
	private int cont = 0;
	private int suma = 0;
		
	public servicioBFS(Grafo<Integer> grafo) {
		this.grafo = grafo;
		this.vertices = new HashMap<Integer,Boolean>();
	}
	
	public void bfsForest(int k) {
		// obtenemos todos los vertices del grafo
		Iterator<Integer> verticesAux = this.grafo.obtenerVertices();
		fila = new ArrayList<Integer>();

		//TOMAMOS LOS VERTICES UTILIZADOS EN EL GRAFO Y LOS INICIALIZAMOS EN BLANCO
		while(verticesAux.hasNext()){
			this.vertices.put(verticesAux.next(), false);
		}
		// reiniciamos los vertices del grafo
		verticesAux = this.grafo.obtenerAdyacentes(5);

		//los volvemos a iterrar desde el principio
		if(k >0) {
			while(verticesAux.hasNext()){
				//obtengo el actual y avanzo al siguiente
				int auxVertice = verticesAux.next();
				// si el color del vertice actual es blanco entro al if
				if(vertices.get(auxVertice) == false){
					// agrego a la lista todo lo que retorne
					cont = 0;
					this.bfsForest_visit(auxVertice,k);
				}
			}
		}else {
			suma = 5;
		}
		
	}
	
	public Integer bfsForest_visit(int vertice, int nivel){

		cont++;
		this.fila.add(vertice);
		this.vertices.put(vertice, true);
		if(cont == nivel) {
			this.suma += vertice;
		}
		while(!this.fila.isEmpty()) {
			int retorno = this.fila.remove(0);
			Iterator<Integer> adyacentes = this.grafo.obtenerAdyacentes(retorno);
			
			while(adyacentes.hasNext()) {
				cont++;
				int adyacente = adyacentes.next();
				if(this.vertices.get(adyacente) == false) {
					this.fila.add(adyacente);
					this.vertices.put(adyacente, true);
					
					if(cont == nivel) {
						this.suma += adyacente;
					}
				}
				if(adyacentes.hasNext()) {		
					cont--;	
				}
			}		
		}
		return this.suma;
	}
	
	public int getSuma() {
		return this.suma;
	}
	
	
}
