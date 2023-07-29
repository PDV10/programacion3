package ej4;

public class greedy {   
					
	public Conjunto<Actividad> greedy(Conjunto<Actividad> actividades){		// se recibe un conjunto de actividades de tipo actividad 
		Conjunto<Actividad> solucion = new Conjunto<Actividad>();
		this.ordenar(actividades); 											// ordena las actividades por tiempo de finalizacion
		
		while(!actividades.getActividades().isEmpty()) {
			Actividad actividad = actividades.getActividades().get(0);
			
			if(esFactible(actividad, solucion.getActividades())) {			// comprueba si el tiempo de inicio de la actividad sea >= que el tiempo de fin de la ultima actividad que este en la solucion 
				solucion.getActividades().add(actividad);					
			}
			actividades.remove(0);
			
		}
		return solucion;
	}
}