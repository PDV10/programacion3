package grafos;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.ArrayList;

public class GrafoDirigido<T> implements Grafo<T> {
	public Map<Integer, ArrayList<Arco<T>>> grafo = new HashMap<>();
		
	@Override
	public void agregarVertice(int vertice) {
		if(!grafo.containsKey(vertice)) {
			grafo.put(vertice,new ArrayList<Arco<T>>());
		}

	}

	@Override
	public void borrarVertice(int verticeId) {
		if(contieneVertice(verticeId)) {
			
		}
	}

	@Override
	public void agregarArco(int verticeOrigen, int verticeDestino, T etiqueta) {
		if(contieneVertice(verticeOrigen) && contieneVertice(verticeDestino)) {
			if(!existeArco(verticeOrigen, verticeDestino)) {
				Arco<T> arco = new Arco<T>(verticeOrigen, verticeDestino, etiqueta);
				grafo.get(verticeOrigen).add(arco);
			}
		}
	}

	@Override
	public void borrarArco(int verticeId1, int verticeId2) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean contieneVertice(int verticeId) {
		return grafo.get(verticeId) != null;
	}

	@Override
	public boolean existeArco(int verticeId1, int verticeId2) {
		if(contieneVertice(verticeId1) && contieneVertice(verticeId2)){
			
			ArrayList<Arco<T>> arcos = this.grafo.get(verticeId1);
			Iterator<Arco<T>> arcosAux = arcos.iterator();
			
			while (arcosAux.hasNext()) {
				Arco<T> arco = arcosAux.next();
				if(arco.getVerticeOrigen() == verticeId1 && arco.getVerticeDestino() == verticeId2) {
					return true;
				}
			}		
		}
		
		return false;
	}

	@Override
	public Arco<T> obtenerArco(int verticeId1, int verticeId2) {
		if(contieneVertice(verticeId1)) {				
			Iterator<Arco<T>> arcos = this.grafo.get(verticeId1).iterator();
			while (arcos.hasNext()) {
				Arco<T> arco = (Arco<T>) arcos.next();
				if(existeArco(verticeId1, verticeId2)) {
					return arco;
				}
			}
		}
		return null;
	}

	@Override
	public int cantidadVertices() {
		return this.grafo.keySet().size();
	}

	@Override
	public int cantidadArcos() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Iterator<Integer> obtenerVertices() {
		Iterator<Integer> vertices = grafo.keySet().iterator();
		return vertices;
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

}
