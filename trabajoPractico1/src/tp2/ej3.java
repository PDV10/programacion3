package tp2;

public class ej3 {
	public static void main(String[] args) {
		int valor = 4;
		obtenerValorBinario(valor);
	}

	public static void obtenerValorBinario(int valor) {
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


}
