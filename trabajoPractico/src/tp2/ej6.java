package tp2;

import java.util.Iterator;

public class ej6 {
	public static void main(String[] args) {
		int[] arreglo = {1,12,23,42,55,7,4,19,13,103};
		
		mostrar(arreglo);
		
		ordenarPorSeleccion(arreglo);	
		ordenarPorBurbujeo(arreglo);	
		System.out.println();
		System.out.println();
		mostrar(arreglo);
	}
	
	private static void ordenarPorBurbujeo(int[] arreglo) {
		int aux = 0;
		for (int i = 0; i < arreglo.length -1 ; i++) {
			for (int j = 0; j < arreglo.length- i -1; j++) {
				if(arreglo[j+1] < arreglo[j]) {
					aux = arreglo[j+1];
					arreglo[j+1] = arreglo[j];
					arreglo[j] = aux;
				}
			}
		}
	}

	public static void ordenarPorSeleccion(int[] arreglo) {
	   int aux = 0;
	   for (int i = 0; i < arreglo.length; i++) {
		   for (int j = 0; j < arreglo.length; j++) {
			   if(arreglo[i] < arreglo[j]) {
				   aux = arreglo[i];
				   arreglo[i] = arreglo[j];
				   arreglo[j] = aux;
			   }
		   }
	   }
	}
	
	
	
	public static void mostrar(int[] arreglo) {
		for (int i = 0; i < arreglo.length; i++) {
			System.out.print(arreglo[i] + " ");
		}
	}
}
