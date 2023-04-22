package tp2;

public class ej9 {
	public static void main(String[] args) {
		int[] arr = new int[10];
		int valor = 5;
		int anterior= 0;
		int secuencia = 1;
		//completarArreglo(arr);
		//for (int i = 0; i < 10000; i++) {
		//obtenerValorBinario(valor);
		obtenerSecuenciaFibonacci(valor, anterior, secuencia);
		//}
		//mostrar(arr);
	}
	
	public static void obtenerSecuenciaFibonacci(int numero, int anterior, int secuencia) {
		if(numero > 0) {
			System.out.print(secuencia + " ");
			obtenerSecuenciaFibonacci(numero-1, secuencia, secuencia + anterior);
		}
	}
	
	private static void obtenerValorBinario(int valor) {
		String r = "" ;
		
		if(valor>0) {
			if(valor%2 == 0) {
				r += " 0 ";
			}else {
				r += " 1 ";
			}
			obtenerValorBinario(valor/2);
		}
		System.out.print(r);
	}

	private static void completarArreglo(int[] arr) {	
		for (int i = 0; i < arr.length; i++) {
			arr[i] = (int) (Math.random()*100);
		}
	}
	
	private static void mostrar(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]+ " ");
		}
	}
}
