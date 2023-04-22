package tp2;

public class ej1 {
	/*
	 * 1) tiene una complejidad o(n) hay que recorrer hasta el fin en el peor de los casos
	 * 2)
	 * 3) a nivel funcional no cambiaria nada, pero tiene menor gasto computacional
	 * 	   es mejor hacer un for
	 * */
	public static void main(String[] args) {
		int[] arreglo = { 1, 2, 3, 5, 6, 7, 8, 9, 11 };
		int i = 0;
		
		boolean r =estaOrdenado(arreglo, i);
		if(r) {
			System.out.println("el arreglo esta ordenado");
		}else {
			System.out.println("el arreglo esta desordenado");
		}
	}

	// para este tipo de ejercicios no tiene sentido hacer recursividad
	// es preferible usar un for
	private static boolean estaOrdenado(int[] arreglo, int i) {
		if(i < arreglo.length - 1) {
			if(arreglo[i] > arreglo[i+1]) {	
				return false;
			}else {
				return estaOrdenado(arreglo, i+1);						
			}
		}
		return true;
	}
			
}
