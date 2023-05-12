package tp3;

import java.util.Iterator;
import java.util.Map;

import Tp1.ej5.MyIterator;

import java.util.ArrayList;
import java.util.HashMap;

public class GrafoDirigido<T> implements Grafo<T> {

	private Map<Integer, ArrayList<Arco>> grafo = new HashMap<Integer, ArrayList<Arco>>();
	
	@Override
	public void agregarVertice(int verticeId) {
		if(grafo.get(verticeId) == null) {
			grafo.put(verticeId,new ArrayList<Arco>());
		}
	}

	@Override
	public void borrarVertice(int verticeId) {
		// borrar los vertices origen de este vertice que nos llega
		// los vertices destino de este vertice(los adyacentes ) se borran automaticamente

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
			// arreglar
			ArrayList<Arco> arcos = grafo.get(verticeInicio);
			Arco arcoNuevo = new Arco(verticeInicio, verticeDestino, null);
			arcos.remove(arcoNuevo);
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
			ArrayList<Arco> arcos = grafo.get(verticeInicio);
			// compruebo que la Arraylist no este vacia
			if(!arcos.isEmpty()) {
				// bien pero mal O(n2)
				for (int i = 0; i < arcos.size(); i++) {
					// si el vertice de origen y destino del arco son iguales al de los paremetros retorno true
					if(arcos.get(i).getVerticeOrigen() == verticeInicio && arcos.get(i).getVerticeDestino() == verticeDestino) {
						return true;
					}
				}
				// hacer con iterator
//				if(){
//					
//				}
			}
		}
		return false;
	}

	@Override
	public Arco<T> obtenerArco(int verticeId1, int verticeId2) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int cantidadVertices() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int cantidadArcos() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Iterator<Integer> obtenerVertices() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterator<Integer> obtenerAdyacentes(int verticeId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterator<Arco<T>> obtenerArcos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterator<Arco<T>> obtenerArcos(int verticeId) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public Iterator<T> iterator() {
		//genero un nuevo iterador que apunta al primer elemento
		
		return new MyIterator<>(grafo);
	}

}
