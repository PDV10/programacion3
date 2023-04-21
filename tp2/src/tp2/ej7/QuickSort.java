package tp2.ej7;

public class QuickSort {
	
	// ordena un tramo del arreglo que le digamos 
	public static void main(String[] args) {
		int[] arr = {1,32,5,7,14,62,83,820,100,92,30};
		mostrar(arr);
		System.out.println();
		System.out.println();
		quicksort(arr, 7, 8);
		mostrar(arr);
	}
	
	private static void quicksort(int arreglo[], int izquierda, int derecha) {
	    if (izquierda < derecha) {
	        int indiceParticion = particion(arreglo, izquierda, derecha);
	        quicksort(arreglo, izquierda, indiceParticion);
	        quicksort(arreglo, indiceParticion + 1, derecha);
	    }
	}
		
	private static int particion(int arreglo[], int izquierda, int derecha) {
        int pivote = arreglo[izquierda];
        // Ciclo infinito
        while (true) {
            while (arreglo[izquierda] < pivote) {
                izquierda++;
            }
            while (arreglo[derecha] > pivote) {
                derecha--;
            }
            if (izquierda >= derecha) {
                return derecha;
            } else {//Nota: yo sé que el else no hace falta por el return de arriba, pero así el algoritmo es más claro
                int temporal = arreglo[izquierda];
                arreglo[izquierda] = arreglo[derecha];
                arreglo[derecha] = temporal;
                izquierda++;
                derecha--;
            }
            // El while se repite hasta que izquierda >= derecha
        }
    }
	
	private static void mostrar(int[] arreglo) {
		for (int i = 0; i < arreglo.length; i++) {
			System.out.print(arreglo[i]+ " ");
		}
	}
	
}
