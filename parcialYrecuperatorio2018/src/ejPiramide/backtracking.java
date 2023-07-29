package ejPiramide;

import java.util.ArrayList;

public class backtracking {
	
	public Piramide back() {
		Estado estado = new Estado();				// el estado cuenta con una piramide
		estado.setPos(0);
		return backtracking(estado, estado.getPos());
	}
	
	public Piramide backtracking(Estado estado, Posicion posicion) {	// posicion es la posicion actual de la base de la piramide 	
		if(estado.piramideCompleta()) {									// verifica que la piramide este completa cuando completa la base 					
			return estado.getPiramide();								// retorna una base (Solucion) completa sin repetir numeros y valida
		}else {
			for (int i = 0; i < 200; i++) {
				if(!estado.getPiramide().contains(i)) {					// si la piramide no contiene i
					estado.getBase().add(i,posicion);					// le agrego a la base el numero i en la posicion actual
					estado.completarPiramide();							// es estado va auto completando la piramide a medida que se genera la base
					if(estado.getPiramide().esValida()){				// verifica que la piramide no genere numeros repetidos (mantiene la piramide consistente)
						Piramide solucion = backtrackin(estado, posicion.setPos(posicion++));
						if(solucion != null) {
							return solucion;
						}
					}
					estado.getBase().remove(i);							// deshacer
					estado.completarPiramide();	
				}
			}
		}
		return null;	
	}	
}
