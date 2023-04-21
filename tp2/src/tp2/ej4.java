package tp2;

public class ej4 {
	public static void main(String[] args) {
		int numero = 6;
		int anterior =0;
		int secuencia = 1;
		
		obtenerSecuenciaFibonacci(numero,anterior,secuencia);
	}

	public static void obtenerSecuenciaFibonacci(int numero, int anterior, int secuencia) {
		if(numero > 0) {
			System.out.print(secuencia + " ");
			obtenerSecuenciaFibonacci(numero-1, secuencia, secuencia + anterior);
		}
	}
}
