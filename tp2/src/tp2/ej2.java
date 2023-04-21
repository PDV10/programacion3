package tp2;

public class ej2 {
	public static void main(String[] args) {
		int[] arreglo = { 1, 2, 3, 5, 6, 7, 8, 9, 11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26 };
		//System.out.println(Buscar(arreglo,i,2));
		int inicio = 0;
		int fin = arreglo.length-1;
		System.out.println(Buscar(arreglo,26,inicio,fin)); // bien
		System.out.println("");
		System.out.println(Buscar(arreglo,inicio,26)); // mal
	}
	
	
	// metodo de busqueda optimo
	private static boolean Buscar(int[] arreglo, int valor, int inicio,int fin) {
		int mitad= (inicio+fin) / 2;
		
		if(fin<inicio) {
			return false;
		}else {
			if(valor > arreglo[mitad]) {
				return Buscar(arreglo, valor, mitad+1,fin);
			}else {
				//System.out.println("mayor");
				if(valor < arreglo[mitad]) {
					return Buscar(arreglo, valor, inicio,mitad-1);
				}else {
					return true;
				}
			}
		}			
	}


	// metodo obsoleto consume muchos recursos
	private static boolean Buscar(int[] arreglo, int i,int valor) {
		if(i < arreglo.length - 1) {
			if(arreglo[i] == valor) {	
				return true;
			}else {
				return Buscar(arreglo, i+1,valor);	
			}
		}
		return false;
	}
	
	
}
