package ej2Parcial;

public class CdFolcklore {
	public int MINUTOS_MAX = 60;
 	public conjunto<Cancion> greedy(conjunto<Cancion> canciones) {		// conjunto cuenta con un arraylist de las canciones y cancion cuenta con el titulo y duracion
		conjunto<Cancion> solucion = new conjunto<Cancion>();
		canciones.getCanciones() = this.ordenar(canciones.getCanciones());							// se ordenan las cancions por duracion minima
		
		while(!canciones.getCanciones().isEmpty() && solucion.sumarMinutos() < this.MINUTOS_MAX) {	// sumar minutos retorna la suma de la duracion de todas las canciones de la solucion 
			Cancion cancion = canciones.getCanciones().get(0);
			
			if(esfactible(cancion, solucion.getCanciones())) {			// si la cancion todavia no se agrego en la solucion (posibles canciones repetidas)
																		// y si al agregar la cancion no supera el tiempo de 60 minutos en la solucion
				solucion.getCanciones().add(cancion);
			}
			canciones.remove(cancion);
		}
	}
}