package tp2.ej7;

public class ej7 {
	
	public static void main(String[] args) {
		int[] arr = {1,32,5,7,14,62,51,83};
		System.out.println("arreglo desordenado");
		mostrar(arr);
		
		System.out.println("\n\n"+"arreglo ordenado" );
		MergeSort arreglo = new MergeSort(arr);
		mostrar(arr);
	}

	private static void mostrar(int[] arreglo) {
		for (int i = 0; i < arreglo.length; i++) {
			System.out.print(arreglo[i]+ " ");
		}
	}
}	
