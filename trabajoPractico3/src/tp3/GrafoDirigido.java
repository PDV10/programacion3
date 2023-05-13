package tp3;

import java.util.Iterator;
import java.util.Map;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;

public class GrafoDirigido<T> implements Grafo<T> {

	private Map<Integer, ArrayList<Arco<T>>> grafo = new HashMap<Integer, ArrayList<Arco<T>>>();
	
	@Override
	public void agregarVertice(int verticeId) {
		if(!contieneVertice(verticeId)) {
			grafo.put(verticeId,new ArrayList<Arco<T>>());
		}
	}

	@Override
	public void borrarVertice(int verticeId) {
		if(contieneVertice(verticeId)) {
			this.grafo.remove(verticeId);
			Iterator<Arco<T>> arcos = obtenerArcos();
			while(arcos.hasNext()) {
				if(arcos.next().getVerticeDestino() == verticeId ) {
					borrarArco(arcos.next().getVerticeOrigen(), arcos.next().getVerticeDestino());
				}
			}
		}
	}

	@Override
	public void agregarArco(int verticeInicio, int verticeDestino, T etiqueta) {
		// verifico que los vertices existan en el grafo                 y que el arco no exista (si existe no se puede crear de vuelta)
		if(contieneVertice(verticeInicio) && contieneVertice(verticeDestino) && !existeArco(verticeInicio, verticeInicio)) {
			// si cumple, creamos el arco con los parametros necesarios
			Arco nuevoArco = new Arco(verticeInicio,verticeDestino,etiqueta);
			// obtenemos el indice(clave) del grafo a partir del inicio
			// una vez que encuentra nos devuelve la lista, y a esa lista le agregamos el nuevo arco creado
			grafo.get(verticeInicio).add(nuevoArco);
			
			//System.out.println("crear arco entre: " + verticeInicio + " y " + verticeDestino);
		}else {
			//System.out.println("no existe algun vertice");
		}

	}

	@Override
	public void borrarArco(int verticeInicio, int verticeDestino) {
		if(existeArco(verticeInicio, verticeDestino)) {
			this.grafo.get(verticeInicio).remove(obtenerArco(verticeInicio, verticeDestino));
		}
	}

	@Override
	public boolean contieneVertice(int verticeId) {
		return grafo.get(verticeId) != null;
	}

	@Override
	public boolean existeArco(int verticeInicio, int verticeDestino) {
		// primero compruebo que los vertices existan
		if(contieneVertice(verticeInicio) && contieneVertice(verticeDestino)) {
			// obtengo la arraylist de arcos a partir del verticeInicio del grafo
			ArrayList<Arco<T>> arcos = grafo.get(verticeInicio);
			
				// con iterator
				Iterator<Arco<T>> aux = arcos.iterator();
				while(aux.hasNext()) {
					Arco<T> arco = (Arco<T>) aux.next();
					if(arco.getVerticeDestino() == verticeDestino) {
						return true;
					}
				}
				
				// bien pero mal O(n2)
//				for (int i = 0; i < arcos.size(); i++) {
//					// si el vertice de origen y destino del arco son iguales al de los paremetros retorno true
//					if(arcos.get(i).getVerticeOrigen() == verticeInicio && arcos.get(i).getVerticeDestino() == verticeDestino) {
//						return true;
//					}
//				}
			
		}
		return false;
	}

	@Override
	public Arco<T> obtenerArco(int verticeInicio, int verticeDestino) {
		if(contieneVertice(verticeInicio) && contieneVertice(verticeDestino) && existeArco(verticeInicio, verticeDestino)) {
			ArrayList<Arco<T>> arcos = grafo.get(verticeInicio);
			Iterator<Arco<T>> aux = arcos.iterator();
			while(aux.hasNext()) {
				Arco<T> arco = (Arco<T>) aux.next();
				if(arco.getVerticeDestino() == verticeDestino) {
					return arco;
				}
			}
		}
		return null;
	}

	@Override
	public int cantidadVertices() {
		return grafo.size();
	}

	@Override
	public int cantidadArcos() {
		// creo una variable vacia
		int cantArcos = 0;
		// obtengo una lista con todos los vertices del grafo y lo hago iterable
		Iterator<Integer> vertices = this.grafo.keySet().iterator();
		while(vertices.hasNext()) {
			// a cantAcos le sumo la cantidad de arcos de cada vertice mientras que exista
			cantArcos += this.grafo.get(vertices.next()).size();
		}
		return cantArcos;
	}

	@Override
	public Iterator<Integer> obtenerVertices() {
		//creo una lista vacia a la cual le voy a agregar todos los vertices del grafo
		ArrayList<Integer> vertices = new ArrayList<>();
		// key set devuelve una lista(no accecible)  de las claves del grafo
		// a vertices le hago addall ya que this.grafo.keySet devuelve una lista con todos los vertices
		vertices.addAll(this.grafo.keySet());
		return vertices.iterator();
	}

	@Override
	public Iterator<Integer> obtenerAdyacentes(int verticeId) {
		//creo una lista vacia a la cual le voy a agregar los adyacentes
		ArrayList<Integer> adyacentes = new ArrayList<>();
		//obtengo los arcos del vertice que me llega por parametro
		if(contieneVertice(verticeId)) {
			ArrayList<Arco<T>> arcos = this.grafo.get(verticeId);
			//lo transformo en interable 
			Iterator<Arco<T>> aux = arcos.iterator();
			while(aux.hasNext()) {
				//al arraylist adyacentes le agrego todos los vertices adyacentes que existan
				adyacentes.add(aux.next().getVerticeDestino());
			}			
		}
		return adyacentes.iterator();
	}

	@Override
	public Iterator<Arco<T>> obtenerArcos() {
		//creo una lista vacia a la cual le voy a agregar los arcos
		ArrayList<Arco<T>> arcos = new ArrayList<>();
		// obtengo todos los vertices (en una lista) y lo hago iterable con .iterator()
		Iterator<Integer> vertices = this.grafo.keySet().iterator();
		while(vertices.hasNext()) {
			//a arcos le realizo addAll con cada lista de arcos de cada vertice
			arcos.addAll(this.grafo.get(vertices.next()));
		}
		return arcos.iterator();
	}

	@Override
	public Iterator<Arco<T>> obtenerArcos(int verticeId) {
		//creo una lista vacia a la cual le voy a agregar los arcos
		ArrayList<Arco<T>> arcos = new ArrayList<>();
		//a arcos le realizo addAll con cada lista de arcos del vertice que llega por parametro
		arcos.addAll(this.grafo.get(verticeId));
		
		return arcos.iterator();
	}
	
}
